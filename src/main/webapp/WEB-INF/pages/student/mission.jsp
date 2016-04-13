<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/28
  Time: 下午5:39
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
    <link href="/themes/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h3>我的任务书
                    </h3>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课题名称:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" disabled value="${title}">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">描述:</label>
                                <div class="col-sm-10">
                                    <textarea type="text" class="form-control" style="min-height: 200px" disabled>${des}</textarea>
                                    <span class="help-block m-b-none">要求</span>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">下载:</label>
                                <div class="col-sm-10">
                                    <a href="/file/${filepath}" class="form-control" style="border: hidden" target="_blank">下载地址</a>
                                </div>
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


</body>

</html>