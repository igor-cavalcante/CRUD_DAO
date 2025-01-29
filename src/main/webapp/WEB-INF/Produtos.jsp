<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Produtos</title>
    <style>
        .mensagem {
            color: darkgreen;
            padding: 10px;
            background-color: #dff0d8;
            border: 1px solid #3c763d;
            border-radius: 5px;
            margin-bottom: 10px;
        }
    </style>

    <script>
        window.onload = function() {
            // Verifica se existe uma mensagem para exibir
            var mensagemDiv = document.getElementById("mensagem");
            if (mensagemDiv) {
                // Esconde a mensagem após 5 segundos
                setTimeout(function() {
                    mensagemDiv.style.display = 'none';
                }, 5000);
            }
        }
    </script>
</head>
<body>

<!-- Exibindo a mensagem dentro de uma div -->
<c:if test="${not empty Mensagem}">
    <div id="mensagem" class="mensagem">
        <c:out value="${Mensagem}" />
    </div>
</c:if>


<table border="1">
    <thead>
    <tr>
        <td>nome</td>
        <td>descrição</td>
        <td>Valor</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="produto" items="${Produtos}">
        <tr>
            <td><c:out value="${produto.nome}" /></td>
            <td><c:out value="${produto.descricao}"/></td>
            <td><c:out value="${produto.preco}" /></td>
        </tr>
    </c:forEach>

    </tbody>


</table>




</body>
</html>
