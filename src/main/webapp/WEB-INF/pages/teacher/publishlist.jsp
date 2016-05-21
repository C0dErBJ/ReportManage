<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/24
  Time: 下午6:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>毕设列表</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <%@ include file="../common/globalCSS.jsp" %>
    <link href="/themes/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <style>
        body{
            font-size: 18px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-title">
                <h3>任务书列表</h3>

            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover wrapper-content " id="datatable">
                        <thead>
                        <tr>
                            <th>创建时间</th>
                            <th>课题名称</th>
                            <th>课题描述</th>
                            <th>文件下载</th>
                            <th>提交情况</th>
                        </tr>
                        </thead>
                    </table>

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
            {"data": "date"},
            {"data": "title"},
            {"data": "des"},
            {"data": "url"},
            {"data": "detail"}
        ],
        "ajax": {
            "url": "/mypublishlist",
            "type": "get",
        }
    })
</script>

</body>

</html>
