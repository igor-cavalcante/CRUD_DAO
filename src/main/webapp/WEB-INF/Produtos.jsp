<%--
  Created by IntelliJ IDEA.
  User: Igorc
  Date: 28/01/2025
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Mensagem Temporária</title>

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
    <td>nome</td>
    <td>descrição</td>
    <td>Valor</td>
    </thead>
</table>

</body>
</html>
