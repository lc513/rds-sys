var ctx = "";//项目部署的工程名
var QualityInspectTaskList;
var QualityInspectTaskEdit;
var QualityInspectTaskForm;
var SupplierList;

//其它组件
var ctIdSelect;//检查模板

var QualityInspectTask = {
    URL: {
        inputUI: function () {
            return ctx + "/QualityInspectTask/ui/input";
        },
        listUI: function () {
            return ctx + "/journal/topage/list";
        },
        list: function () {
            return ctx + "/QualityInspectTask/list";
        },
        update: function () {
            return ctx + "/journal/update";
        },
        add: function () {
            return ctx + "/journal/add";
        },
        project: function () {
            return ctx + "/project/tree";
        },
        delete: function (ids) {
            return ctx + "/journal/delete" + ids;
        },
        get: function (id) {
            return ctx + "/journal/select/" + id;
        }
    },
    input: {
        init: function (ct) {
            ctx = ct;
            QualityInspectTask.input.initComponent();
            QualityInspectTask.input.initForm();
        },

        initComponent: function () {
            QualityInspectTaskForm = $("#QualityInspectTaskForm");
            ctIdSelect = $("#ctIdSelect");
        },
        //edit时候调用
        initForm: function () {
            //提交时调用
            QualityInspectTaskForm.form({
                url: QualityInspectTask.URL.add(),
                onSubmit: function () {

                },
                success: function (data) {
                    console.log(data);
                    var data = eval('(' + data + ')');
                    if (data.code == 200) {
                        QualityInspectTask.input.close();
                        QualityInspectTask.list.reload();
                    }
                }
            });
        },
        submitForm: function () {
            // submit the form
            // alert("啥时候回调用你");
            QualityInspectTaskForm.submit();
        },
        close: function () {
            QualityInspectTaskEdit.dialog('close');
        },
    },
    list: {
        init: function (ct) {
            ctx = ct;
            QualityInspectTask.list.initComponent();

            QualityInspectTask.list.initSupplierList();
            QualityInspectTask.list.initList(null);
        },
        initComponent: function () {
            QualityInspectTaskList = $("#QualityInspectTaskList");
            QualityInspectTaskEdit = $('#QualityInspectTaskEdit');
            SupplierList = $("#SupplierList");
        },
        initSupplierList: function () {
            SupplierList.tree({
                url: '/Supplier/tree',
                onClick: function (node) {
                    // alert(node.id);  // alert node text property when clicked
                    QualityInspectTask.list.initList(node.id);
                }
            });
        },
        initList: function (supplierId) {
            QualityInspectTaskList.datagrid({
                url: QualityInspectTask.URL.list(),
                data: [{sId: supplierId,}],
                method: 'get',
                pagination: true,
                pageSize: 30,
                toolbar: '#QualityInspectTaskToolbar',//SysUser.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    // {field: 'sId', title: '外键sId', hidden: true},
                    // {field: 'ctId', title: '外键ctId', hidden: true},
                    // {field: 'inspector_id', title: '外键inspector_id', hidden: true},
                    {field: 'cId', title: '外键cId', hidden: true},
                    // {field: 'uId', title: '外键uId', hidden: true},
                    // {field: 'inspectorId', title: '外键uId', hidden: true},
                    {field: 'name', title: '计划名称', width: '18%', hidden: false},
                    {field: 'sId', title: '所属项目', width: '13%', hidden: false ,
                        formatter: function(value,row,index){
                            if (row.gwSupplier) {
                                return row.gwSupplier.name;
                            }
                            return value;
                        }
                    },
                    {field: 'ctId', title: '检查模板', width: '13%', hidden: false,
                        formatter: function (value, row, index) {
                        if (row.gwCheckTemp){
                            return row.gwCheckTemp.name;
                        }
                            return value;
                        }
                    },
                    {field: 'year', title: '计划年份', width: '5%', hidden: false},
                    {
                        field: 'startTime',
                        title: '开始时间',
                        width: '10%',
                        hidden: false,
                        formatter: function (value, row, index) {
                            var unixTimestamp = new Date(value);
                            return unixTimestamp.toLocaleString();
                        }
                    },
                    {
                        field: 'endTime',
                        title: '结束时间',
                        width: '10%',
                        hidden: false,
                        formatter: function (value, row, index) {
                            var unixTimestamp = new Date(value);
                            return unixTimestamp.toLocaleString();
                        }
                    },
                    {field: 'uId', title: '编制人', width: '6%', hidden: false,
                        formatter: function (value, row, index) {
                            if (row.compileUser){
                                return row.compileUser.loginName;
                            }
                            return value;
                        }
                    },
                    {field: 'inspectorId', title: '检查人', width: '10%', hidden: false,
                        formatter: function (value, row, index) {
                            if (row.inspectorUser){
                                return row.inspectorUser.loginName;
                            }
                            return value;
                        }
                    },
                    {
                        field: 'createTime',
                        title: '编制时间',
                        width: '10%',
                        hidden: false,
                        formatter: function (value, row, index) {
                            var unixTimestamp = new Date(value);
                            return unixTimestamp.toLocaleString();
                        }
                    },
                    // {
                    //     field: 'sysProject', title: '组织名', width: '13.571%', hidden: false,
                    //     formatter: function (value, row, index) {
                    //         return value.name;
                    //     }
                    // },
                    // {
                    //     field: 'examine', title: '是否审查', width: '13.571%', hidden: false,
                    //     formatter: function (value, row, index) {
                    //         return value == 1 ? '是' : '否';
                    //     }
                    // },
                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index, row) {
                    QualityInspectTaskList.datagrid("unselectAll");
                    QualityInspectTaskList.datagrid("selectRow", index);
                },
                onLoadSuccess: function (data) {
                    console.log(data);
                },
            });
        },
        getSelectionsIds: function () {
            var sels = QualityInspectTaskList.datagrid("getSelections");
            var ids = [];
            for (var i in sels) {
                ids.push(sels[i].id);
            }
            ids = ids.join(",");
            return ids;
        },
        //增
        add: function () {
            QualityInspectTaskEdit.dialog({
                href: QualityInspectTask.URL.inputUI(),
                width: 600,
                height: 450,
                onLoad: function () {
                    //检查模板
                    ctIdSelect.combotree({
                        url: QualityInspectTask.URL.project(),
                        method: 'get',
                        panelHeight: 'auto'
                    });
                }
            })
                .dialog("open");
        },
        //改
        edit: function () {
            var sels = QualityInspectTaskList.treegrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }

            QualityInspectTaskEdit.dialog({
                href: QualityInspectTask.URL.inputUI(),
                onLoad: function () {
                    //方案一：使用Form的load去load数据
                    //QualityInspectTaskForm.form("load", QualityInspectTask.URL.get(sels[0].id));
                    //方案二：直接使用列表的row数据
                    //项目数据
                    ctIdSelect.combotree({
                        url: QualityInspectTask.URL.project(),
                        method: 'get',
                        panelHeight: 'auto'
                    });
                    QualityInspectTaskForm.form("load", sels[0]);
                    //方案三：使用Ajax请求数据
                    // $.ajax({
                    //     type: "GET",
                    //     url: QualityInspectTask.URL.get(sels[0].id),
                    //     success: function (data) {
                    //         if (data.code == 200) {
                    //             QualityInspectTaskForm.form("load", data.data);
                    //             ctIdSelect.combotree({
                    //                 url: QualityInspectTask.URL.update(),
                    //                 method: 'get',
                    //                 panelHeight: 'auto',
                    //                 onLoadSuccess: function () {
                    //                     ctIdSelect.combotree('setValue', data.data.pid);
                    //                 }
                    //             });
                    //         }
                    //     }
                    // });
                }
            })
                .dialog("open");
        },
        //删
        delete: function () {
            var ids = QualityInspectTask.list.getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            $.messager.confirm({
                title: '确认提示框',
                msg: '你确定要删除吗？',
                fn: function (r) {
                    if (r) {
                        $.ajax({
                            type: "DELETE",
                            url: QualityInspectTask.URL.delete(ids),
                            success: function () {
                                QualityInspectTask.list.reload();
                                QualityInspectTask.list.clearSelectionsAndChecked();
                            }
                        });
                    }
                }
            });
        },
        //刷新
        reload: function () {
            QualityInspectTaskList.treegrid("reload");
        },
        collapseAll: function () {
            var roots = QualityInspectTaskList.treegrid("getRoots");
            for (var i in roots) {
                QualityInspectTaskList.treegrid("collapseAll", roots[i].id);
            }
        },
        expandAll: function () {
            var roots = QualityInspectTaskList.treegrid("getRoots");
            for (var i in roots) {
                QualityInspectTaskList.treegrid("expandAll", roots[i].id);
            }
        },
        clearSelectionsAndChecked: function () {
            QualityInspectTaskList.treegrid("clearChecked");
            QualityInspectTaskList.treegrid("clearSelections");
        },
        //搜索
        search: function () {
            var searchName = [];
            var searchValue = [];
            $("input[lang='searchQualityInspectTask']").each(function (i) {
                searchName[i] = $(this).attr("name");
                searchValue[i] = $(this).val();
            });

            var queryParamsArr = [];
            for (var i = 0; i < searchName.length; i++) {
                queryParamsArr.push(searchName[i] + ":'" + searchValue[i] + "'")
            }
            var queryParams = "{" + queryParamsArr.join(",") + "}";

            QualityInspectTaskList.treegrid({
                queryParams: eval('(' + queryParams + ')'),
                onLoadSuccess: function (data) {
                    //回显搜索内容
                    $("input[lang='searchQualityInspectTask']").each(function (i) {
                        $(this).val(searchValue[i]);
                    });
                }
            });
        },
        //清空
        clear: function () {
            $("input[lang='searchQualityInspectTask']").each(function (i) {
                $(this).val("");
            });
        },
        timestampToTime: function (timestamp) {
            var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
            Y = date.getFullYear() + '-';
            M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
            D = date.getDate() + ' ';
            h = date.getHours() + ':';
            m = date.getMinutes() + ':';
            s = date.getSeconds();
            return Y + M + D + h + m + s;
        }
    }
}
