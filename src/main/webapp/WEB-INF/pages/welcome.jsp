<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/23
  Time: 下午3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登陆</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="common/globalCSS.jsp" %>
</head>
<body>
<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">欢迎使用课程报告系统
            <br>本系统包含如下功能:
            <ul>
                <li>
                    发布题目
                </li>
                <li>
                    审批
                </li>
            </ul>
        </blockquote>
        <hr>
    </div>
</div>
<jsp:include page="common/globalJs.jsp"/>
</body>
</body>
</html>
