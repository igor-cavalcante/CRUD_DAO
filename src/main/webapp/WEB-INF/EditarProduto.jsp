<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 29/01/2025
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Editar</title>
</head>
<body>

<%@ include file="../header.jsp" %>

<main>
<h1>Form de Edição de produtos </h1>



<form action="editarProduto" method="post">
    <input type="hidden" name="id" value="${Produto.id}"/>
    <label>Nome: <input type="text" name="nome" value="${Produto.nome}"/></label>
    <label>descrição: <input type="text" name="descricao" value="${Produto.descricao}"/></label>
    <label>Valor <input type="number" name="valor" value="${Produto.preco}"/></label>
    <input type="submit" value="Enviar"/>

</form>
</main>
</body>
</html>
