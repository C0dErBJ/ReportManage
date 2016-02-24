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
    <link href="/themes/css/plugins/steps/jquery.steps.css" rel="stylesheet">
</head>
<body class="gray-bg top-navigation">
<div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="common/thmenu.jsp"/>
        <div class="wrapper-content" >
            <iframe class="J_iframe" id="mainframe" width="100%"  frameborder="0" seamless height="100%" src="/welcome"></iframe>
        </div>
        <jsp:include page="common/foot.jsp"/>
    </div>
</div>

</body>
</html>
