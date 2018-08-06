var ctx = "";//项目部署的工程名
var SysResourceList;
var SysResourceEdit;
var SysResourceForm;

//其它组件
var parentResource;
//选择图片对话框
var SysResourceChooseIcon;
//图片textbox
var iconText;
var SysResource = {
    roleId:0,
    URL: {
        inputUI: function () {
            return ctx + "/sys/resources/ui/input";
        },
        listUI: function () {
            return ctx + "/sys/resources/ui/list";
        },
        iconUI: function () {
            return ctx + "/sys/resources/ui/icon";
        },
        list: function (roleId) {

            return ctx + "/sys/resourcesbyRole/"+roleId;
        },
        save: function () {
            return ctx + "/sys/resources/";
        },
        delete: function (ids) {
            return ctx + "/sys/resources/" + ids;
        },
        get: function (id) {
            return ctx + "/sys/resources/" + id;
        },
        tree: function () {
            return ctx + "/sys/resources/tree"
        },
        update: function () {
            return ctx + "sys/role/resources"
        }
    },
    input: {
        init: function (ct) {
            ctx = ct;
            SysResource.input.initComponent();
            SysResource.input.initForm();
        },
        initComponent: function () {
            SysResourceForm = $("#SysResourceForm");
            parentResource = $('#parentResource');
            SysResourceChooseIcon = $('#SysResourceChooseIcon');
            iconText = $("input[name='icon']");
        },
        initForm: function () {
            SysResourceForm.form({
                url: SysResource.URL.save(),
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                },
                success: function (data) {
                    var data = eval('(' + data + ')');
                    if (data.code == 200) {
                        SysResource.input.close();
                        SysResource.list.reload();
                    }
                }
            });
        },
        submitForm: function () {
            // submit the form
            SysResourceForm.submit();
        },
        close: function () {
            SysResourceEdit.dialog('close');
        },
        chooseIcon: function () {
            //使用全局弹窗
            globalWindow.dialog({
                    title:'选择图标',
                    width:605,
                    height:400,
                    modal:true,
                    href: SysResource.URL.iconUI(),
                    cache:false
                });
        },
        setIcon: function (value) {
            iconText.textbox("setValue", value);
            globalWindow.dialog("close");
        }
    },
    list: {
        init: function (ct) {
            ctx = ct;
            SysResource.list.initComponent();
            SysResource.list.initList(14);
        },
        initComponent: function () {
            SysResourceList = $("#SysResourceList");
            SysResourceEdit = $('#SysResourceEdit');
        },
        initList: function (roleId) {
            SysResource.roleId = roleId;
            SysResourceList.treegrid({
                url: SysResource.URL.list(roleId),
                method: 'get',
                pagination: true,
                pageSize: 30,
                toolbar: '#SysResourceToolbar',//SysResource.list.toolbar,
                singleSelect: false,
                collapsible: false,
                idField: 'id',
                treeField: 'name',
                parentField: 'pid',//自定义属性
                columns: [[
                    {field: 'ck',checkbox: true  },
                    {field: 'hasJurisdiction', title: '是否选择', width: '10%', hidden: false,
                        formatter: function (value, row, index) {
                            return value == true ? '是' : '否';
                        }
                    },
                    {field: 'id', title: '主键', hidden: true},
                    {field: 'name', title: '资源名称', width: '10%', hidden: false},
                    {field: 'url', title: '资源路径', width: '10%', hidden: false},
                    {
                        field: 'openMode',
                        title: '打开方式',
                        width: '7.917%',
                        hidden: false,
                        formatter: function (value, row, index) {
                            return value == '0' ? 'ajax' : 'iframe';
                        }
                    },
                    {field: 'description', title: '资源介绍', width: '7.917%', hidden: false},
                    {
                        field: 'icon', title: '资源图标', width: '7.917%', hidden: false,
                        formatter: function (value, row, index) {
                            if (value) {
                                return '<img src="'+value+'" style="margin:0px;width: 20px;height: 20px;"/>';
                            }
                            return value;
                        }
                    },
                    {field: 'seq', title: '排序', width: '7.917%', hidden: false},
                    {
                        field: 'status',
                        title: '状态',
                        width: '7.917%',
                        hidden: false,
                        formatter: function (value, row, index) {
                            return value == 0 ? '启用' : '停用';
                        }
                    },
                    {
                        field: 'resourceType',
                        title: '资源类别',
                        width: '7.917%',
                        hidden: false,
                        formatter: function (value, row, index) {
                            return value == 0 ? '菜单' : '按钮';
                        }
                    },
                    {field: 'delFlag', title: '删除标记', width: '7.917%', hidden: true},
                    {field: 'updateTime', title: '更新时间', width: '9%', hidden: false},
                    {field: 'createTime', title: '创建时间', width: '9%', hidden: false},
                ]],
                //对返回的数据进行处理,便于显示树形结构
                loadFilter: function (data, parentId) {
                    console.log(JSON.stringify(data));
                    data.ck = data.hasJurisdiction;
                    var opt = $(this).data().treegrid.options;
                    var parentField;//获取自定义属性
                    if (opt.parentField) {
                        parentField = opt.parentField;
                        var jsonStr = JSON.stringify(data); //可以将json对象转换成json字符串
                        jsonStr = jsonStr.replace(new RegExp(parentField, "gm"), "_parentId");
                        return JSON.parse(jsonStr); //可以将json字符串转换成json对象
                    }
                },
                //设置选中事件，清除之前的行选择
                onClickRow: function (row) {
                    SysResourceList.treegrid("unselectAll");
                    SysResourceList.treegrid("selectRow",row.id);
                    row.hasJurisdiction = true;
                },
            });
        },
        getSelectionsIds: function () {
            var sels = SysResourceList.treegrid("getSelections");
            var ids = [];
            for (var i in sels) {
                ids.push(sels[i].id);
            }
            ids = ids.join(",");
            return ids;
        },
        //增
        add: function () {
            SysResourceEdit.dialog({
                    href: SysResource.URL.inputUI(),
                    onLoad: function () {
                        parentResource.combotree({
                            url: SysResource.URL.tree(),
                            method: 'get',
                            panelHeight: 'auto'
                        });
                    }
                })
                .dialog("open");
        },
        //改
        edit: function () {
            var sels = SysResourceList.treegrid("getSelections");

            var json = {
                roleId:SysResource.roleId,
                sels:sels
            }
            //提交资源权限
            console.log(JSON.stringify(json));
            $.ajax({
                type: "POST",
                url: SysResource.URL.update(),
                contentType:"application/json",
                data: JSON.stringify(json),
                success: function (data) {
                    console.log(data);

                    if (data.code == 200) {
                        alert("成功  "+data.msg);
                        SysResource.list.initList(SysResource.roleId);
                    }else {
                        alert("失败  "+data.msg);
                    }
                },
                error:function(e){
                    console.log(e);
                    alert("失败  "+e);
                }
            });
            return;
            //编辑
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }
            SysResourceEdit.dialog({
                    href: SysResource.URL.inputUI(),
                    onLoad: function () {
                        //方案一：使用Form的load去load数据
                        //SysResourceForm.form("load", SysResource.URL.get(sels[0].id));
                        //方案二：直接使用列表的row数据
                        //SysResourceForm.form("load",sels[0]);
                        //方案三：使用Ajax请求数据
                        $.ajax({
                            type: "GET",
                            url: SysResource.URL.get(sels[0].id),
                            success: function (data) {
                                if (data.code == 200) {
                                    SysResourceForm.form("load", data.data);
                                    parentResource.combotree({
                                        url: SysResource.URL.tree(),
                                        method: 'get',
                                        panelHeight: 'auto',
                                        onLoadSuccess: function () {
                                            parentResource.combotree('setValue', data.data.pid);
                                        }
                                    });
                                }
                            }
                        });
                    }
                })
                .dialog("open");
        },
        //删
        delete: function () {
            var ids = SysResource.list.getSelectionsIds();
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
                            url: SysResource.URL.delete(ids),
                            success: function () {
                                SysResource.list.reload();
                                //如果不清空，删除还可以编辑BUG
                                SysResource.list.clearSelectionsAndChecked();
                            }
                        });
                    }
                }
            });
        },
        //刷新
        reload: function () {
            SysResourceList.treegrid("reload");
        },
        clearSelectionsAndChecked: function () {
            SysResourceList.treegrid("clearChecked");
            SysResourceList.treegrid("clearSelections");
        },
        //搜索
        search: function () {
            var searchName = [];
            var searchValue = [];
            $("input[lang='searchSysResource']").each(function (i) {
                searchName[i] = $(this).attr("name");
                searchValue[i] = $(this).val();
            });

            var queryParamsArr = [];
            for (var i = 0; i < searchName.length; i++) {
                queryParamsArr.push(searchName[i] + ":'" + searchValue[i] + "'")
            }
            var queryParams = "{" + queryParamsArr.join(",") + "}";

            SysResourceList.treegrid({
                queryParams: eval('(' + queryParams + ')'),
                onLoadSuccess: function (data) {
                    //回显搜索内容
                    $("input[lang='searchSysResource']").each(function (i) {
                        $(this).val(searchValue[i]);
                    });
                }
            });
        },
        //清空
        clear: function () {
            $("input[lang='searchSysResource']").each(function (i) {
                $(this).val("");
            });
        },
        //折叠
        collapseAll: function () {
            var roots = SysResourceList.treegrid("getRoots");
            for (var i in roots) {
                SysResourceList.treegrid("collapseAll", roots[i].id);
            }
        },
        //展开
        expandAll: function () {
            var roots = SysResourceList.treegrid("getRoots");
            for (var i in roots) {
                SysResourceList.treegrid("expandAll", roots[i].id);
            }
        },
    }
}
