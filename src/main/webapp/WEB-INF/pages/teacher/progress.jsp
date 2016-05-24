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
    <title>进度</title>
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
            <div class="ibox">
                <div class="ibox-content">
                    <div class="row">
                        <table class="table table-bordered table-striped" id="datatable">
                            <thead>
                            <tr>
                                <td>课题名称</td>
                                <td>作业提交人数</td>
                                <td>通过人数</td>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<%@ include file="../common/globalJs.jsp" %>

<script src="/themes/js/plugins/jeditable/jquery.jeditable.js"></script>
<!-- Data Tables -->
<script src="/themes/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="/themes/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<script>
    $('#datatable').dataTable({
        "paging": false,
        "searching": false,
        "ordering": false,
        "processing": true,
        "serverSide": true,
        "columns": [
            {"data": "Title"},
            {"data": "commitnum"},
            {"data": "passnum"},
        ],
        "ajax": {
            "url": "/progress",
            "type": "get",
        }
    })
</script>
</body>
</html>
