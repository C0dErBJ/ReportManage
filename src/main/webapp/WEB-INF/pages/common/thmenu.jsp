<%--
  Created by IntelliJ IDEA.
  User: C0dEr
  Date: 16/2/23
  Time: 下午12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row border-bottom white-bg">
    <nav class="navbar navbar-static-top" role="navigation">
        <div class="navbar-header">
            <div class="dropdown profile-element">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear" style="margin-left: 10px">
                               <span class="block m-t-xs"><strong class="font-bold">LRM</strong></span>
                                <span class="text-muted text-xs block">${name}<b class="caret"></b></span>
                                </span>
                </a>
                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                    <%--<li class="divider"></li>--%>
                    <li><a href="/loginstu">安全退出</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a aria-expanded="false" role="button" href="/main"> 返回首页</a>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">任务书
                        <span class="caret"></span></a>
                    <ul role="menu" class="dropdown-menu">
                        <li><a class="menuitem" href="javascript:;" data-value="/publish">发布任务书</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">指导书
                        <span class="caret"></span></a>
                    <ul role="menu" class="dropdown-menu">
                        <li><a class="menuitem" href="javascript:;" data-value="/guidebook">发布指导书</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">要求
                        <span class="caret"></span></a>
                    <ul role="menu" class="dropdown-menu">
                        <li><a class="menuitem" href="javascript:;" data-value="/require">发布要求</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">进度
                        <span class="caret"></span></a>
                    <ul role="menu" class="dropdown-menu">
                        <li><a class="menuitem" href="javascript:;" data-value="/progressview">进度查看</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">课题模板
                        <span class="caret"></span></a>
                    <ul role="menu" class="dropdown-menu">
                        <li><a class="menuitem" href="javascript:;" data-value="/template">上传课题模板</a>
                        </li>
                        <li><a class="menuitem" href="javascript:;" data-value="/templatechakan">模板查看</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">审阅
                        <span class="caret"></span></a>
                    <ul role="menu" class="dropdown-menu">

                        <li><a class="menuitem" href="javascript:;" data-value="/publishlist">课题列表</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a href="/loginstu">
                        <i class="fa fa-sign-out"></i> 退出
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<jsp:include page="globalJs.jsp"/>
<script>
    $(".menuitem").click(function(){
        var url=$(this).attr("data-value");
        $("#mainframe").attr("src",url);
    });
</script>