<%--
Created by IntelliJ IDEA.
User: JinKun
Date: 2016-12-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="tableResult">

    <!-- 列表 -->
    <table id="QualityInspectTaskResultList" data-options="border:false"  style="width:100%;overflow-x:hidden " title="组织机构"></table>
</div>
<script src="<%=request.getContextPath()%>/jsp/gw/gw-quality-inspect-task/gw-quality-inspect-task.js"></script>
<script>
    QualityInspectTask.list.initResult('<%=request.getContextPath()%>');
</script>
