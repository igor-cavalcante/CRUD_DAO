<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar produto</title>
</head>
<body>
</h1>
<br/>

<h1>Form de cadastro de produtos </h1>

<form action="inserirProduto" method="post">
    <label>Nome: <input type="text" name="nome"/></label>
    <label>descrição: <input type="text" name="descricao"/></label>
    <label>Valor <input type="number" name="valor" /></label>
    <input type="submit" value="Enviar"/>
</form>

</body>
</html>