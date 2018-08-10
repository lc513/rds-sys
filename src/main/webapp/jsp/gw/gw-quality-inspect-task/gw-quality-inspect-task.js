var ctx = "";//项目部署的工程名
var QualityInspectTaskList;
var QualityInspectTaskDetailList;
var QualityInspectTaskEdit;
var QualityInspectTaskDetailEdit;
var QualityInspectTaskResultList;
var QualityInspectTaskForm;
var SupplierList;

//其它组件
var ctIdSelect;//检查模板
var cIdSelect;//所属部门
var uIdSelect;//所属部门
var inspectorIdSelect;//所属部门
var sId;//受检项目
var sName;//受检项目

var QualityInspectTask = {
    data:{
        SupplierId: 1,
        SupplierName:"苏州市阳澄湖半岛游客中心",
        taskId:0,
        generate:false,
    },
    URL: {
        inputUI: function () {
            return ctx + "/QualityInspectTask/ui/input";
        },
        inputDetialUI: function () {
            return ctx + "/QualityInspectTask/ui/input-detail";
        },
        inputResultUI: function () {
            return ctx + "/QualityInspectTask/ui/input-result";
        },
        listUI: function () {
            return ctx + "/journal/topage/list";
        },
        list: function () {
            return ctx + "/QualityInspectTask/list";
        },
        detailList: function () {
            return ctx + "/QualityInspectTaskDetail/list";
        },
        resultList: function () {
            return ctx + "/GwQualityInspectTaskResult/list";
        },
        update: function () {
            return ctx + "/journal/update";
        },
        add: function () {
            return ctx + "/QualityInspectTask/addTask";
        },
        checkTempTree: function () {
            return ctx + "/GwCheckTemp/tree";
        },
        companyTree: function () {
            return ctx + "/Company/tree";
        },
        userTree: function () {
            return ctx + "/sys/users/tree";
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
            cIdSelect = $("#cIdSelect");
            uIdSelect = $("#uIdSelect");
            inspectorIdSelect = $("#inspectorIdSelect");
            sName = $("#sName");
            sId = $("#sId");
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
        initDetail: function (ct) {
            ctx = ct;
            QualityInspectTask.list.initDetailComponent();


        },
        initResult: function (ct) {
            ctx = ct;
            QualityInspectTask.list.initResultComponent();


        },
        initComponent: function () {
            QualityInspectTaskList = $("#QualityInspectTaskList");
            QualityInspectTaskEdit = $('#QualityInspectTaskEdit');
            SupplierList = $("#SupplierList");
        },
        initDetailComponent: function () {
            QualityInspectTaskDetailList = $("#QualityInspectTaskDetailList");
            QualityInspectTaskDetailEdit = $('#QualityInspectTaskDetailEdit');
        },
        initResultComponent: function () {
            QualityInspectTaskResultList = $("#QualityInspectTaskResultList");
        },
        initSupplierList: function () {
            SupplierList.tree({
                url: '/Supplier/tree',
                onClick: function (node) {
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
                nowrap:false,
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
                    QualityInspectTask.list.detail();
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
                title:"新增计划",
                onLoad: function () {
                    // var sels = QualityInspectTaskList.datagrid("getSelections");
                    // QualityInspectTaskForm.form("load",sels[0]);
                    // sName.val(QualityInspectTask.data.SupplierName);
                    sName.textbox('setValue',QualityInspectTask.data.SupplierName);
                    sId.val(QualityInspectTask.data.SupplierId);
                    //检查模板
                    ctIdSelect.combotree({
                        url: QualityInspectTask.URL.checkTempTree(),
                        method: 'get',
                        panelHeight: 'auto'
                    });
                    //所属部门
                    cIdSelect.combotree({
                        url: QualityInspectTask.URL.companyTree(),
                        method: 'get',
                        panelHeight: 'auto'
                    });

                    uIdSelect.combotree({
                        url: QualityInspectTask.URL.userTree(),
                        method: 'get',
                        panelHeight: 'auto'
                    });
                    inspectorIdSelect.combotree({
                        url: QualityInspectTask.URL.userTree(),
                        method: 'get',
                        panelHeight: 'auto'
                    });
                }
            })
                .dialog("open");
        },
        //改
        edit: function () {
            return false;

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
        //详情弹框
        detail: function(){

            QualityInspectTaskEdit.dialog({
                href: QualityInspectTask.URL.inputDetialUI(),
                title:"查看任务",
                width:1200,
                height:600,
                onLoad: function () {
                    var sels = QualityInspectTaskList.datagrid("getSelections");
                    console.log(sels[0]);
                    var generate = false;
                    try{
                        generate = sels[0].generate;
                    }catch(err){
                        // console.log(err.stack);
                    }

                    QualityInspectTask.data.SupplierId = sels[0].sId;
                    QualityInspectTask.data.taskId = sels[0].id;
                    QualityInspectTask.data.generate = generate;
                    // alert(QualityInspectTask.data.taskId);
                    if (generate) {
                        //请求详情数据
                        QualityInspectTask.list.initDetailList(sels[0].id);
                        // $("#generate").css("display","none");
                        // $("#tableDetail").css("display","block");
                        $("#generate .l-btn-text").text("已生成");
                    }else {
                        QualityInspectTask.list.initDetailList(sels[0].id);
                        $("#generate .l-btn-text").text("根据批次生成");
                        // $("#generate").css("display","block");
                        // $("#tableDetail").css("display","none");
                    }
                }
            })
                .dialog("open");
        },
        generate :function(){
            if (QualityInspectTask.data.generate) {
                return;
            }
            var taskId = QualityInspectTask.data.taskId;
            //按批次生成
            $.ajax({
                type: "GET",
                url: "/QualityInspectTaskDetail/generate",
                data:{'taskId':taskId},
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {

                    }
                }
            });
        },
        //详情的检查标准弹框
        result: function(){

            QualityInspectTaskDetailEdit.dialog({
                href: QualityInspectTask.URL.inputResultUI(),
                title:"检查标准",
                width:1000,
                height:550,
                onLoad: function () {
                    var sels = QualityInspectTaskDetailList.datagrid("getSelections");
                    console.log(sels[0]);
                    // alert(sels[0].id);
                    //请求详情数据
                    QualityInspectTask.list.initResultList(sels[0].id);
                }
            })
                .dialog("open");
        },
        initDetailList: function (supplierId) {
            QualityInspectTaskDetailList.datagrid({
                url: QualityInspectTask.URL.detailList()+"/"+supplierId,
                method: 'get',
                pagination: true,
                nowrap:false,
                pageSize: 30,
                toolbar: '#QualityInspectTaskDetailToolbar',//SysUser.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    {field: 'checkProject', title: '检查项目', width: '15%', hidden: false},
                    {field: 'checkPoint', title: '检查点', width: '8%', hidden: false},
                    {field: 'frequency', title: '频次', width: '10%', hidden: false},
                    {field: 'qualified', title: '是否合格', width: '5%', hidden: false},
                    {field: 'score', title: '得分/总分', width: '6%', hidden: false},
                    {field: 'checkTime', title: '检查时间', width: '10%', hidden: false,
                        formatter: function (value, row, index) {
                            var unixTimestamp = new Date(value);
                            return unixTimestamp.toLocaleString();
                        }
                    },
                    {field: 'checkUser', title: '检查人', width: '10%', hidden: false},
                    {field: 'isChecked', title: '是否检查', width: '5%', hidden: false},
                    {field: 'taskStime', title: '开始时间', width: '10%', hidden: false,
                            formatter: function (value, row, index) {
                                var unixTimestamp = new Date(value);
                                return unixTimestamp.toLocaleString();
                            }
                    },
                    {field: 'taskEtime', title: '结束时间', width: '10%', hidden: false,
                        formatter: function (value, row, index) {
                            var unixTimestamp = new Date(value);
                            return unixTimestamp.toLocaleString();
                        }
                    },
                    {field: 'enclosure', title: '附件', width: '5%', hidden: false},
                    // {field: 'ctId', title: '检查模板', width: '13%', hidden: false,
                    //     formatter: function (value, row, index) {
                    //         if (row.gwCheckTemp){
                    //             return row.gwCheckTemp.name;
                    //         }
                    //         return value;
                    //     }
                    // },
                    // {field: 'year', title: '计划年份', width: '5%', hidden: false},
                    // {
                    //     field: 'startTime',
                    //     title: '开始时间',
                    //     width: '10%',
                    //     hidden: false,
                    //     formatter: function (value, row, index) {
                    //         var unixTimestamp = new Date(value);
                    //         return unixTimestamp.toLocaleString();
                    //     }
                    // }
                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index, row) {
                    QualityInspectTaskDetailList.datagrid("unselectAll");
                    QualityInspectTaskDetailList.datagrid("selectRow", index);
                    QualityInspectTask.list.result();
                },
                onLoadSuccess: function (data) {
                    console.log(data);
                },
            });
        },
        initResultList: function (qitdId) {
            QualityInspectTaskResultList.datagrid({
                url: QualityInspectTask.URL.resultList()+"/"+qitdId,
                method: 'get',
                pagination: true,
                pageSize: 30,
                nowrap:false,
                // toolbar: '#QualityInspectTaskResultToolbar',//SysUser.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    {field: 'checkContent', title: '检查内容', width: '30%', hidden: false},
                    {field: 'isQualified', title: '是否合格', width: '8%', hidden: false,
                        formatter: function (value, row, index) {
                            return value==1?"合格":"不合格";
                        }
                    },
                    {field: 'score', title: '得分(分)', width: '8%', hidden: false,
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {field: 'checkTime', title: '检查时间', width: '20%', hidden: false,
                        formatter: function (value, row, index) {
                            var unixTimestamp = new Date(value);
                            return unixTimestamp.toLocaleString();
                        }
                    },
                    {field: 'checkSituation', title: '检查情况', width: '25%', hidden: false},
                    {field: 'enclosure', title: '附件', width: '8%', hidden: false,
                        formatter: function (value, row, index) {
                        if (value) {

                            var enclosure = value.split(",");
                            return enclosure.length+"个";
                        }
                        return "0个";
                        }
                    },
                    // {field: 'checkUser', title: '检查人', width: '10%', hidden: false},
                    // {field: 'isChecked', title: '是否检查', width: '5%', hidden: false},
                    // {field: 'taskStime', title: '开始时间', width: '10%', hidden: false,
                    //     formatter: function (value, row, index) {
                    //         var unixTimestamp = new Date(value);
                    //         return unixTimestamp.toLocaleString();
                    //     }
                    // },
                    // {field: 'taskEtime', title: '结束时间', width: '10%', hidden: false,
                    //     formatter: function (value, row, index) {
                    //         var unixTimestamp = new Date(value);
                    //         return unixTimestamp.toLocaleString();
                    //     }
                    // },
                    // {field: 'enclosure', title: '附件', width: '5%', hidden: false},
                    // {field: 'ctId', title: '检查模板', width: '13%', hidden: false,
                    //     formatter: function (value, row, index) {
                    //         if (row.gwCheckTemp){
                    //             return row.gwCheckTemp.name;
                    //         }
                    //         return value;
                    //     }
                    // },
                    // {field: 'year', title: '计划年份', width: '5%', hidden: false},
                    // {
                    //     field: 'startTime',
                    //     title: '开始时间',
                    //     width: '10%',
                    //     hidden: false,
                    //     formatter: function (value, row, index) {
                    //         var unixTimestamp = new Date(value);
                    //         return unixTimestamp.toLocaleString();
                    //     }
                    // }
                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index, row) {
                    QualityInspectTaskDetailList.datagrid("unselectAll");
                    QualityInspectTaskDetailList.datagrid("selectRow", index);

                },
                onLoadSuccess: function (data) {
                    console.log(data);
                },
            });
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
