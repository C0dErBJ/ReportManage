<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/23
  Time: 下午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程报告系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="common/globalCSS.jsp" %>
</head>
<style>
    body{
        font-size: 18px;
    }
</style>
<script>
    var red="${red}"
    if(red!=""){
        window.parent.location.href=red;
    }
</script>
<body class="gray-bg top-navigation">
<div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
        <%
            if (request.getAttribute("role")!=null&&request.getAttribute("role").equals("教师")) {
        %>
        <jsp:include page="common/thmenu.jsp"/>
        <%
        } else {
        %>
        <jsp:include page="common/stumenu.jsp"/>
        <%
            }

        %>

        <div class="wrapper-content">
            <iframe class="J_iframe" id="mainframe" width="100%" frameborder="0" seamless height="100%"
                    src="/welcome"></iframe>
        </div>
        <jsp:include page="common/foot.jsp"/>
    </div>
</div>

</body>
</html>
