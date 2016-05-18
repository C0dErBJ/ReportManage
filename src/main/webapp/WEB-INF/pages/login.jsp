<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/23
  Time: 下午1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>课程报告系统 - 登录</title>

    <%@ include file="common/globalCSS.jsp" %>

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">LRM</h1>
        </div>
        <h3>${systemname}系统</h3>

        <form class="m-t" role="form" id="signin" action="login" METHOD="post">
            <div class="form-group">
                <input type="tel" name="username" class="form-control" placeholder="用户名" required=""
                       aria-required="true" aria-invalid="true" class="error">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" required=""
                       aria-required="true" aria-invalid="true" class="error">
            </div>
            <input type="hidden" value="${systemname}" name="logintype"/>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-muted text-center"><a href="${systemname=="教师"?"loginstu":"loginth"}">
                <small>${systemname.equals("教师")?"学生登录":"教师登陆"}</small>
            </a>
            </p>
        </form>
    </div>
</div>

<!-- 全局js -->
<%@ include file="common/globalJs.jsp" %>
<!-- jQuery Validation plugin javascript-->
<script src="/themes/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/themes/js/plugins/validate/messages_zh.min.js"></script>
<script>
    var a = "<i class='fa fa-times-circle'></i> ";
    $("#signin").validate({
        rules: {
            username: {
                required: true,
                minlength: 1
            },
            password: {
                required: true,
                minlength: 1
            },
        },
        messages: {
            username: {
                required: a + "请输入您的用户名",
                minlength: a + "用户名必须两个字符以上"
            },
            password: {
                required: a + "请输入您的密码",
                minlength: a + "密码必须5个字符以上"
            },
        }
    });
</script>
</body>

</html>
