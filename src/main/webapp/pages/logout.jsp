<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Регистрация</title>

    <link href="${pageContext.request.contextPath}/resources/style/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/logout" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading">Введите данные</h2>
        <input name="firstName" type="text" class="form-control" placeholder="Имя" required autofocus>
        <input name="lastName" type="text" class="form-control" placeholder="Фамилия" required>
        <input name="date" type="date" class="form-control" placeholder="День рождения" required>
        <label>
            <select name="sex" size="1" class="form-control">
                <option value="man" id="man">Мужчина</option>
                <option value="woman" id="woman">Женщина</option>
            </select>
        </label>
        <input name="login" type="email" class="form-control" placeholder="Email" required>
        <input name="password" type="password" class="form-control" placeholder="Пароль" required>

        <p class="error" style="color: red;">${error}</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Регистрация</button>
    </form>
</div>
</body>
</html>
