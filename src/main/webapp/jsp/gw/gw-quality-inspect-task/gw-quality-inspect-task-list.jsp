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
<div style="float:left;min-width: 100px;height:100%;overflow-y: scroll">
    <ul id="SupplierList"></ul>
</div>
<div style="float: left;width: 1px;height: 100%; background-color: #aaaaaa"></div>
<div style="overflow: hidden">
    <!-- 工具栏 -->
    <div id="QualityInspectTaskToolbar" style="padding:5px;height:auto">
        <div>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" onclick="javascript:QualityInspectTask.list.add()">增加</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain="true" onclick="javascript:QualityInspectTask.list.delete()">删除</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:QualityInspectTask.list.edit()">详情</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true" onclick="javascript:QualityInspectTask.list.reload()">刷新</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-standard-plugin-delete'" plain="true" onclick="javascript:QualityInspectTask.list.collapseAll()">折叠</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-standard-plugin-add'" plain="true" onclick="javascript:QualityInspectTask.list.expandAll()">展开</a>
            <!-- 权限控制标签 对应me.jinkun.rds.common.shiro.ShiroDbRealm.doGetAuthorizationInfo方法 -->
            <shiro:hasPermission name="user:create1">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-options="disabled:false" onclick="del()">删除</a>
                <span class="toolbar-item dialog-tool-separator"></span>
            </shiro:hasPermission>
        </div>
    </div>
    <!-- 列表 -->
    <table id="QualityInspectTaskList" data-options="border:false"  style="width:100%;overflow-x:hidden " title="组织机构"></table>
</div>
<!-- 弹窗  --> <!-- inline:true 不然多次打开tab会重复提交表单 -->
<div id="QualityInspectTaskEdit" title="新增计划" style="width:500px;height:400px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){QualityInspectTask.input.submitForm()}},{text:'取消',iconCls:'icon-cancel',handler:function(){QualityInspectTask.input.close()}}]"  ></div>
<script src="<%=request.getContextPath()%>/jsp/gw/gw-quality-inspect-task/gw-quality-inspect-task.js"></script>
<script>
    QualityInspectTask.list.init('<%=request.getContextPath()%>');
</script>