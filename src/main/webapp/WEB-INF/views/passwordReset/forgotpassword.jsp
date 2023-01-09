<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="../fragments/header.jsp"/>
</header>
<section class="login-page">
    <h2>Zresetuj Haslo</h2>
    <form method="post" action="/reset">
        <div class="form-group">
            <input type="email" name="email" placeholder="Email"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zresetuj Hasło</button>
        </div>
    </form>
</section>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
