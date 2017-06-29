<%@ page import="com.entity.News" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ic" uri="/tags/imagecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: Paul Brown
  Date: 19.01.2017
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $("[data-toggle]").click(function() {
                var toggle_el = $(this).data("toggle");
                $(toggle_el).toggleClass("open-sidebar");
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div id="sidebar">
        <ul>
            <li id="avatar"><img src="${pageContext.request.contextPath}/resources/images/132.png   "></li>
            <li><a href="${pageContext.request.contextPath}/pages/news.jsp?value=/news">Новости</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/messages.jsp">Сообщения</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/friends.jsp">Друзья</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/videos.jsp">Видео</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/books.jsp">Книги</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/music.jsp">Музыка</a></li>
            <li><a href="#">Настройки</a></li>
        </ul>
    </div>
    <div class="main-content">
        <a href="#" data-toggle=".container" id="sidebar-toggle">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
        <div class="content">
            <h1>Новости</h1>

            <c:forEach items="${newsAttr}" var="news">
                <p><b> ${news.name} </b></p>

                <c:if test="${news.picture ne null}">
                    <img src="<ic:imageCoder imageByte="${news.picture}"/>" height="300">
                </c:if>

                <p><b> ${news.text} </b></p>

                <p> Новость создал <b>${news.userID.login}</b>, время:<b> ${news.newsDate}</b></p>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>