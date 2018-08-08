<%--
Created by IntelliJ IDEA.
User: JinKun
Date: 2016-12-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="QualityInspectTaskForm" method="post">
     <table class="com_table"  align="center">
        <input type="hidden" name="id">
        <input type="hidden" name="uId">
        <tr>
            <td></td>
            <td><label>计划名称:</label></td>
            <td><input class="easyui-textbox com_input" name="name" data-options="required:true" value="游客中心8月-10月项目安全检查"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>检查模板:</label></td>
            <td><select class="easyui-combobox com_input"  id="ctIdSelect"  name="ctId" data-options="required:true,textField:'text',valueField:'ctId'"></select></td>
            <td></td>
        </tr>
         <tr>
             <td></td>
             <td><label>计划年限:</label></td>
             <td><input class="easyui-textbox com_input" type="number" name="year" data-options="required:true" value="2018"/></td>
             <td></td>
         </tr>
        <tr>
            <td></td>
            <td><label>开始时间:</label></td>
            <td><input class="easyui-textbox com_input" name="startTime" data-options="required:true" value="2018-08-08"/></td>
            <%--<td><input class="easyui-datetimebox com_input" name="jDate" value="2018-01-01 11:11:11" data-options="required:false" /></td>--%>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>结束时间:</label></td>
            <td><input class="easyui-textbox com_input" name="endTime" data-options="required:true" value="2018-10-08"/></td>
            <%--<td><input class="easyui-datetimebox com_input" name="jDate" value="2018-01-01 11:11:11" data-options="required:false" /></td>--%>
            <td></td>
        </tr>
         <tr>
             <td></td>
             <td><label>所属部门:</label></td>
             <td><select class="easyui-combobox com_input"  id="cIdSelect"  name="cId" data-options="required:true,textField:'text',valueField:'cId'"></select></td>
             <td></td>
         </tr>
         <tr>
             <td></td>
             <td><label>受检项目:</label></td>
             <td><input class="easyui-textbox com_input" name="sId" data-options="required:true"/></td>
             <td></td>
         </tr>
         <tr>
             <td></td>
             <td><label>检查人:</label></td>
             <td><input class="easyui-textbox com_input" name="inspectorId" data-options="required:true"/></td>
             <td></td>
         </tr>
    </table>
</form>

<script src="<%=request.getContextPath()%>/jsp/gw/gw-quality-inspect-task/gw-quality-inspect-task.js"></script>
<script>
    QualityInspectTask.input.init('<%=request.getContextPath()%>');
</script>
