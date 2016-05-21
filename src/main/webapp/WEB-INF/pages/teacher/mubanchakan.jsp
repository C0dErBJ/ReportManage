<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/5/18
  Time: 下午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模板查看</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="../common/globalCSS.jsp" %>
    <link href="/themes/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="/themes/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">

    <style>
        body {
            font-size: 18px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class=" float-e-margins">
            <div class="ibox-title">
                <h5>模板查看</h5>
            </div>
            <div class="ibox-content" id="eg">
                <div class="summernote click2edit">
                    ${html}
                </div>

            </div>
        </div>
    </div>

</div>
<iframe style="display: none" src="" id="file"></iframe>
<%@ include file="../common/globalJs.jsp" %>

<!-- SUMMERNOTE -->
<script src="/themes/js/plugins/summernote/summernote.min.js"></script>
<script src="/themes/js/plugins/summernote/summernote-zh-CN.js"></script>
<script>
    var edit = function () {
        $("#eg").addClass("no-padding");
        $(".click2edit").summernote({lang: "zh-CN", focus: true})
    };
    var save = function () {
        $("#eg").removeClass("no-padding");
        var a = $(".click2edit").code();
        $(".click2edit").destroy()
        var data = new Object();
        data.content = $("#eg").children().html()
        $.ajax({
            type: "post",
            url: "/student/content",
            data: data,
            dataType: "json",
            success: function (response) {
                $("#file").attr("src", "/file/" + response);
            }
        });
    };

</script>
</body>

</html>
