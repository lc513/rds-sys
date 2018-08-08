<%--
Created by IntelliJ IDEA.
User: JinKun
Date: 2016-12-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="generate">
    <a href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" onclick="javascript:QualityInspectTask.list.generate()">按批次生成</a>
</div>
<div id="tableDetail">
    <!-- 工具栏 -->
    <div id="QualityInspectTaskDetailToolbar" style="padding:5px;height:auto">
        <div>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:QualityInspectTask.list.detail()">明细</a>
        </div>
    </div>
    <!-- 列表 -->
    <table id="QualityInspectTaskDetailList" data-options="border:false"  style="width:100%;overflow-x:hidden " title="组织机构"></table>
</div>
<!-- 弹窗  --> <!-- inline:true 不然多次打开tab会重复提交表单 -->
<div id="QualityInspectTaskDetailEdit" title="明细" style="width:500px;height:400px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true"></div>
<script src="<%=request.getContextPath()%>/jsp/gw/gw-quality-inspect-task/gw-quality-inspect-task.js"></script>
<script>
    QualityInspectTask.list.initDetail('<%=request.getContextPath()%>');
</script>
