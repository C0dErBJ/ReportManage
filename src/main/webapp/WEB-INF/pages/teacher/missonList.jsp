<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/4/14
  Time: 下午5:38
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
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-title">
                <h3>学生完成情况</h3>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover wrapper-content " id="datatable">
                        <thead>
                        <tr>
                            <th>名字</th>
                            <th>是否完成</th>
                            <th>详情</th>
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
            {"data": "title"},
            {"data": "des"},
            {"data": "url"},
        ],
        "ajax": {
            "url": "/detail/${id}",
            "type": "get",
        }
    })
</script>

</body>

</html>
