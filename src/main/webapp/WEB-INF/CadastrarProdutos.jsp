<%--
  Created by IntelliJ IDEA.
  User: Igorc
  Date: 28/01/2025
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/inserir" method="post">
    <label>Nome: <input type="text" name="nome"/></label>
    <label>descrição: <input type="text" name="descricao"/></label>
    <label>Valor <input type="number" name="valor" /></label>
    <input type="submit" value="Enviar"/>
</form>

</body>
</html>
