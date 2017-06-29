<%--
  Created by IntelliJ IDEA.
  User: Paul Brown
  Date: 19.01.2017
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Друзья</title>

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
            <li id="avatar"><img src="${pageContext.request.contextPath}/resources/images/132.png"></li>
            <li><a href="news.jsp">Новости</a></li>
            <li><a href="messages.jsp">Сообщения</a></li>
            <li><a href="friends.jsp">Друзья</a></li>
            <li><a href="videos.jsp">Видео</a></li>
            <li><a href="books.jsp">Книги</a></li>
            <li><a href="music.jsp">Музыка</a></li>
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
            <h1>Друзья</h1>
        </div>
    </div>
</div>
</body>
</html>
</html>
