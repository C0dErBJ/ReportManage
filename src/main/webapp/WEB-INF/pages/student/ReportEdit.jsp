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
                    <h2>H+ 后台主题</h2>
                    <p>
                        H+是一个完全响应式，基于Bootstrap3.4.0最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的就jQuery插件，她可以用于所有的Web应用程序，如<b>网站管理后台</b>，<b>网站会员中心</b>，<b>CMS</b>，<b>CRM</b>，<b>OA</b>等等，当然，您也可以对她进行深度定制，以做出更强系统。
                    </p>
                    <p>
                        <b>当前版本：</b>v3.0
                    </p>
                    <p>
                        <b>定价：</b><span class="label label-warning">&yen;768（不开发票）</span>
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
