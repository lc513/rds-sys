var ctx = "";//项目部署的工程名
var SysJournalList;
var SysJournalEdit;
var SysJournalForm;

//其它组件
var parentJournal;

var SysJournal = {
    faild:{
      add :false,
    },
    URL: {
        inputUI: function () {
            return ctx + "/journal/topage/input";
        },
        listUI: function () {
            return ctx + "/journal/topage/list";
        },
        list: function () {
            return ctx + "/journal/select";
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
            SysJournal.input.initComponent();
            SysJournal.input.initForm();
        },
        initComponent: function () {
            SysJournalForm = $("#SysJournalForm");
            parentJournal = $("#parentJournal");
        },
        //edit时候调用
        initForm: function () {
            //提交时调用
            SysJournalForm.form({
                url: SysJournal.URL.add(),
                onSubmit: function () {

                },
                success: function (data) {
                    console.log(data);
                    var data = eval('(' + data + ')');
                    if (data.code == 200) {
                        SysJournal.input.close();
                        SysJournal.list.reload();
                    }
                }
            });
        },
        submitForm: function () {
            // submit the form
            // alert("啥时候回调用你");
            SysJournalForm.submit();
        },
        close: function () {
            SysJournalEdit.dialog('close');
        },
    },
    list: {
        init: function (ct) {
            ctx = ct;
            SysJournal.list.initComponent();
            SysJournal.list.initList();
        },
        initComponent: function () {
            SysJournalList = $("#SysJournalList");
            SysJournalEdit = $('#SysJournalEdit');
        },
        initList: function () {
            SysJournalList.datagrid({
                url: SysJournal.URL.list(),
                method: 'get',
                pagination: true,
                pageSize: 30,
                toolbar: '#SysJournalToolbar',//SysUser.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    {field: 'pId', title: '外键pId', hidden: true},
                    {field: 'uId', title: '外键uId', hidden: true},
                    {field: 'sysProject', title: '组织名', width: '13.571%', hidden: false,
                        formatter: function(value,row,index){
                            return value.name;
                        }
                    },
                    {field: 'jDate', title: '日期', width: '13.571%', hidden: false,
                        formatter: function(value){
                            if (value == undefined) {
                                return "";
                            }
                            return SysJournal.list.timestampToTime(value);
                        }
                    },
                    {field: 'workDuration', title: '工作时长', width: '13.571%', hidden: false},
                    {field: 'workDesc', title: '工作内容', width: '13.571%', hidden: false},
                    {field: 'overTime', title: '加班时长', width: '13.571%', hidden: false},
                    {field: 'overDesc', title: '加班内容', width: '13.571%', hidden: false},
                    {field: 'examine', title: '是否审查', width: '13.571%', hidden: false,
                        formatter:function(value,row,index){return value==1?'是':'否';}
                    },
                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index,row) {
                    SysJournalList.datagrid("unselectAll");
                    SysJournalList.datagrid("selectRow",index);
                },
            });
        },
        getSelectionsIds: function () {
            var sels = SysJournalList.datagrid("getSelections");
            var ids = [];
            for (var i in sels) {
                ids.push(sels[i].id);
            }
            ids = ids.join(",");
            return ids;
        },
        //增
        add: function () {
            SysJournal.faild.add = true;
            alert(SysJournal.faild.add);
            SysJournalEdit.dialog({
                    href: SysJournal.URL.inputUI(),
                    onLoad: function () {
                        parentJournal.combotree({
                            url: SysJournal.URL.project(),
                            method: 'get',
                            panelHeight: 'auto'
                        });
                    }
                })
                .dialog("open");
        },
        //改
        edit: function () {
            var sels = SysJournalList.treegrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }

            SysJournalEdit.dialog({
                    href: SysJournal.URL.inputUI(),
                    onLoad: function () {
                        //方案一：使用Form的load去load数据
                        //SysJournalForm.form("load", SysJournal.URL.get(sels[0].id));
                        //方案二：直接使用列表的row数据
                        //项目数据
                        parentJournal.combotree({
                            url: SysJournal.URL.project(),
                            method: 'get',
                            panelHeight: 'auto'
                        });
                        SysJournalForm.form("load",sels[0]);
                        //方案三：使用Ajax请求数据
                        // $.ajax({
                        //     type: "GET",
                        //     url: SysJournal.URL.get(sels[0].id),
                        //     success: function (data) {
                        //         if (data.code == 200) {
                        //             SysJournalForm.form("load", data.data);
                        //             parentJournal.combotree({
                        //                 url: SysJournal.URL.update(),
                        //                 method: 'get',
                        //                 panelHeight: 'auto',
                        //                 onLoadSuccess: function () {
                        //                     parentJournal.combotree('setValue', data.data.pid);
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
            var ids = SysJournal.list.getSelectionsIds();
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
                            url: SysJournal.URL.delete(ids),
                            success: function () {
                                SysJournal.list.reload();
                                SysJournal.list.clearSelectionsAndChecked();
                            }
                        });
                    }
                }
            });
        },
        //刷新
        reload: function () {
            SysJournalList.treegrid("reload");
        },
        collapseAll: function () {
            var roots = SysJournalList.treegrid("getRoots");
            for (var i in roots) {
                SysJournalList.treegrid("collapseAll", roots[i].id);
            }
        },
        expandAll: function () {
            var roots = SysJournalList.treegrid("getRoots");
            for (var i in roots) {
                SysJournalList.treegrid("expandAll", roots[i].id);
            }
        },
        clearSelectionsAndChecked: function () {
            SysJournalList.treegrid("clearChecked");
            SysJournalList.treegrid("clearSelections");
        },
        //搜索
        search: function () {
            var searchName = [];
            var searchValue = [];
            $("input[lang='searchSysJournal']").each(function (i) {
                searchName[i] = $(this).attr("name");
                searchValue[i] = $(this).val();
            });

            var queryParamsArr = [];
            for (var i = 0; i < searchName.length; i++) {
                queryParamsArr.push(searchName[i] + ":'" + searchValue[i] + "'")
            }
            var queryParams = "{" + queryParamsArr.join(",") + "}";

            SysJournalList.treegrid({
                queryParams: eval('(' + queryParams + ')'),
                onLoadSuccess: function (data) {
                    //回显搜索内容
                    $("input[lang='searchSysJournal']").each(function (i) {
                        $(this).val(searchValue[i]);
                    });
                }
            });
        },
        //清空
        clear: function () {
            $("input[lang='searchSysJournal']").each(function (i) {
                $(this).val("");
            });
        },
        timestampToTime: function(timestamp) {
            var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
            Y = date.getFullYear() + '-';
            M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
            D = date.getDate() + ' ';
            h = date.getHours() + ':';
            m = date.getMinutes() + ':';
            s = date.getSeconds();
            return Y+M+D+h+m+s;
        }
    }
}
