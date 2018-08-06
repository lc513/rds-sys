<%--
<%--
Created by IntelliJ IDEA.
User: JinKun
Date: 2016-12-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 权限控制标签库 -->
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!-- 工具栏 -->
<div id="SysJournalToolbar" style="padding:5px;height:auto">
    <div>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" onclick="javascript:SysJournal.list.add()">增加</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain="true" onclick="javascript:SysJournal.list.delete()">删除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:SysJournal.list.edit()">编辑</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true" onclick="javascript:SysJournal.list.reload()">刷新</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-standard-plugin-delete'" plain="true" onclick="javascript:SysJournal.list.collapseAll()">折叠</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-standard-plugin-add'" plain="true" onclick="javascript:SysJournal.list.expandAll()">展开</a>
        <!-- 权限控制标签 对应me.jinkun.rds.common.shiro.ShiroDbRealm.doGetAuthorizationInfo方法 -->
        <shiro:hasPermission name="user:create1">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-options="disabled:false" onclick="del()">删除</a>
            <span class="toolbar-item dialog-tool-separator"></span>
        </shiro:hasPermission>
    </div>
</div>
<!-- 列表 -->
<table id="SysJournalList" data-options="border:false"  style="width: 100%;" title="组织机构"></table>
<!-- 弹窗  --> <!-- inline:true 不然多次打开tab会重复提交表单 -->
<div id="SysJournalEdit" title="组织机构" style="width:500px;height:400px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){SysJournal.input.submitForm()}},{text:'取消',iconCls:'icon-cancel',handler:function(){SysJournal.input.close()}}]"  ></div>
<script src="<%=request.getContextPath()%>/jsp/sys/sys-journal/sys-journal.js"></script>
<script>
    SysJournal.list.init('<%=request.getContextPath()%>');
</script>