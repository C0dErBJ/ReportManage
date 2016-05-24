<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/23
  Time: 下午2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布毕设</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="../common/globalCSS.jsp" %>
    <link href="/themes/css/plugins/steps/jquery.steps.css" rel="stylesheet">
    <link href="/themes/css/plugins/uploadify/uploadify.css" rel="stylesheet">
    <style>
        body{
            font-size: 18px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-content">
                    <h2>
                        任务书
                    </h2>
                    <p>
                        填写任务书信息以及上传任务书
                    </p>

                    <form id="form" action="/require" class="wizard-big" method="post">
                        <h1>信息</h1>
                        <fieldset>
                            <h2>任务书信息</h2>
                            <div class="row">
                                <div class="col-sm-8">
                                    <div class="form-group">
                                        <label>课题 *</label>
                                        <input id="lessontitle" name="title" type="text"
                                               class="form-control required" >
                                    </div>
                                    <div class="form-group">
                                        <label>描述 *</label>
                                        <textarea id="description" name="des"
                                                  class="form-control required" ></textarea>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="text-center">
                                        <div style="margin-top: 20px">
                                            <i class="fa fa-sign-in" style="font-size: 180px;color: #e5e5e5 "></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </fieldset>
                        <h1>任务书上传</h1>
                        <fieldset>
                            <h2>资料上传</h2>
                            <div class="row">
                                <input type="hidden" name="fileid" class="required" id="fileid">

                                <div class="col-md-12"><span id="fileuploadify"/></div>
                            </div>
                            <div class="row" id="result" style="display: none">
                                <div class="col-md-1">
                                    <div>
                                        <a href="" id="path" class="btn btn-primary" target="_blank">下载</a>
                                    </div>
                                </div>
                                <div class="col-md-1">
                                    <div>
                                        <a href="javaScript:;" class="btn btn-danger" id="delete">删除</a>
                                    </div>
                                </div>
                            </div>
                        </fieldset>

                    </form>
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
<script>
    $(document).ready(function () {
        $("#form").steps({
            bodyTag: "fieldset",
            onStepChanging: function (d, a, b) {
                return $(this).valid()
            },
            onStepChanged: function (b, a, c) {
            }
            ,
            onFinishing: function (c, a) {
                var b = $(this);
                b.validate().settings.ignore = ":disabled";
                return b.valid()
            }
            ,
            onFinished: function (c, a) {
                var b = $(this);
                b.submit()
            },
            onCanceled:function(){
                window.location.href= window.location.href;
            }
        }).validate({
            errorPlacement: function (a, b) {
                b.before(a)
            }
        })

        $('#fileuploadify').uploadify({
            uploader: 'file/upload',           // 服务器端处理地址
            swf: '/themes/images/uploadify/uploadify.swf',    // 上传使用的 Flash
            width: 60,                          // 按钮的宽度
            height: 23,                         // 按钮的高度
            buttonText: "上传",                 // 按钮上的文字
            buttonCursor: 'hand',                // 按钮的鼠标图标
            method: 'post',
            folder: 'uploads',//您想将文件保存到的路径
            fileObjName: 'files',            // 上传参数名称
//             两个配套使用
            fileTypeExts: "*.doc;*.docx;*.pdf",             // 扩展名
            fileTypeDesc: "请选择文件",     // 文件说明
            auto: true,                // 选择之后，自动开始上传
            onUploadSuccess: function (file, data, response) {
                var result = JSON.parse(data);
                if (result.id != "") {
                    $('#path').attr("href", "/file/" + result.id);
                    $("#fileid").val(result.id);
                    $("#result").show();
                }
            }
            ,
            onSelect: function (file) {
                console.log(file.name);
            }
            ,
        })

        $('#delete').click(function () {
            $.ajax({
                type: "get",
                url: "/file/delete/" + $("#fileid").val(),
                dataType: "text",
                success: function (data) {
                    if (data == "Success") {
                        $('#fileid').val("");
                        $('#result').hide();
                    }
                }
            });
        });
    })
    ;
</script>
</body>
</html>
