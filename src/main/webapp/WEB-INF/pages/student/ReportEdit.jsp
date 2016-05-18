<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/28
  Time: 下午7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的任务书</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="../common/globalCSS.jsp" %>
    <link href="/themes/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="/themes/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class=" float-e-margins">
            <div class="ibox-title">
                <h5>模板编辑</h5>
                <button id="edit" class="btn btn-primary btn-xs m-l-sm" onclick="edit()" type="button">编辑
                </button>
                <button id="save" class="btn btn-primary  btn-xs" onclick="save()" type="button">下载</button>
            </div>
            <div class="ibox-content" id="eg">
                <div class="summernote click2edit">
                    <h2>标题</h2>
                    <p>
                        这个段落你可以自己编辑
                    </p>
                    <p>
                        <b>当前版本：</b>v3.0
                    </p>

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
                $("#file").attr("src","/file/"+response);
            }
        });
    };

</script>
</body>

</html>
