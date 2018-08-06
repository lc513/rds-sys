<%--
Created by IntelliJ IDEA.
User: JinKun
Date: 2016-12-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="SysJournalForm" method="post">
     <table class="com_table"  align="center">
        <input type="hidden" name="id">
        <input type="hidden" name="pid">
        <input type="hidden" name="uid">
        <tr>
            <td></td>
            <td><label>组织名:</label></td>
            <td><select class="easyui-combobox com_input"  id="parentJournal"  name="sysProject.name" data-options="textField:'text',valueField:'pId'"></select></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>日期:</label></td>
            <td><input class="easyui-textbox com_input" name="jDate" data-options="required:false"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>工作时长:</label></td>
            <td><input class="easyui-textbox com_input" name="workDuration" data-options="required:false"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>工作内容:</label></td>
            <td><input class="easyui-textbox com_input" name="workDesc" data-options="required:false"/></td>
            <td></td>
        </tr>
         <tr>
             <td></td>
             <td><label>加班时长:</label></td>
             <td><input class="easyui-numberspinner" name="overTime" data-options="min:0,max:10000,editable:true,required:false,value:0"/></td>
             <td></td>
         </tr>
        <tr>
            <td></td>
            <td><label>加班内容:</label></td>
            <td><input class="easyui-textbox com_input" name="overDesc" data-options="required:true"/></td>
            <td></td>
        </tr>

    </table>
</form>

<script src="<%=request.getContextPath()%>/jsp/sys/sys-journal/sys-journal.js"></script>
<script>
    SysJournal.input.init('<%=request.getContextPath()%>');
</script>
