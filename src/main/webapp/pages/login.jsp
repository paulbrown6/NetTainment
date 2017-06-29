<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Вход</title>

    <link href="${pageContext.request.contextPath}/resources/style/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
        <form action="${pageContext.request.contextPath}/login" method="post" class="form-signin" role="form">
            <h2 class="form-signin-heading">Введите данные</h2>
            <input name="login" type="email" class="form-control" placeholder="Email" required autofocus>
            <input name="password" type="password" class="form-control" placeholder="Пароль" required>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
            <p>Вы здесь впервые? <a href="logout.jsp">Зарегистрируйтесь!</a></p>
            <p class="error" style="color: red;">${error}</p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        </form>
</div>
</body>
</html>
