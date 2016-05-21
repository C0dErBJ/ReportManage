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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="../common/globalCSS.jsp" %>
    <link href="/themes/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="/themes/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="/themes/css/plugins/uploadify/uploadify.css" rel="stylesheet">
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
                <h5>模板上传</h5>
            </div>
            <div class="ibox-content" id="eg">
                <form id="form" action="/template" class="wizard-big" method="post">
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

                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <button type="submit" class=" btn btn-success">确认</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<iframe style="display: none" src="" id="file"></iframe>
<%@ include file="../common/globalJs.jsp" %>
<script src="/themes/js/plugins/uploadify/jquery.uploadify.min.js"></script>
<!-- SUMMERNOTE -->
<script src="/themes/js/plugins/summernote/summernote.min.js"></script>
<script src="/themes/js/plugins/summernote/summernote-zh-CN.js"></script>
</body>
<script>
    $('#fileuploadify').uploadify({
        uploader: '/file/upload',           // 服务器端处理地址
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
    });</script>
</html>