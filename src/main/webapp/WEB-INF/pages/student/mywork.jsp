<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/4/14
  Time: 上午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="../common/globalCSS.jsp" %>
    <link href="/themes/css/plugins/steps/jquery.steps.css" rel="stylesheet">
    <link href="/themes/css/plugins/uploadify/uploadify.css" rel="stylesheet">

    <style>
        body {
            font-size: 18px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h3>我的作业
                    </h3>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">状态:</label>
                                <div class="col-sm-10">
                                    <label style="line-height: 30px;">${status==0?"差":status==1?"中":status==2?"良":"优"}</label>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">老师留言:</label>
                                <div class="col-sm-10">
                                    <textarea type="text" class="form-control" style="min-height: 200px"
                                              disabled>${thdes}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">我的留言:</label>
                                <div class="col-sm-10">
                                    <textarea type="text" class="form-control" style="min-height: 200px"
                                              disabled>${stdes}</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">下载:</label>
                                <div class="col-sm-10">
                                    <a href="/file/${filepath}" class="form-control" style="border: hidden"
                                       target="_blank">下载地址</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/globalJs.jsp" %>

<script src="/themes/js/plugins/uploadify/jquery.uploadify.min.js"></script>
<!-- Steps -->
<script src="/themes/js/plugins/staps/jquery.steps.min.js"></script>
<script src="/themes/js/content.min.js?v=1.0.0"></script>
<!-- Jquery Validate -->
<script src="/themes/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/themes/js/plugins/validate/messages_zh.min.js"></script>
</body>
</html>
