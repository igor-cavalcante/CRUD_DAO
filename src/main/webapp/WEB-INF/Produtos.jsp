<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Produtos</title>
    <style>
        /* Mensagem de sucesso */
        .mensagem {
            color: darkgreen;
            padding: 10px;
            background-color: #dff0d8;
            border: 1px solid #3c763d;
            border-radius: 5px;
            margin-bottom: 20px;
            text-align: center;
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }

        /* Estilo para o body */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f5f5f5;
        }

        /* Estilo para o contêiner da tabela */
        .table-produtos {
            display: flex;
            justify-content: center;
        }

        /* Estilo para a tabela */
        table {
            border-collapse: collapse;
            width: 80%;
            background-color: white;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        th, td {
            text-align: left;
            padding: 10px;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f4f4f4;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
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
        };
    </script>
</head>
<body>

<%@ include file="../header.jsp" %>


<main>


    <!-- Exibindo a mensagem de feedback -->
    <c:if test="${not empty Mensagem}">
        <div id="mensagem" class="mensagem">
            <c:out value="${Mensagem}" />
        </div>
    </c:if>

<!-- Tabela de produtos -->
<div class="table-produtos">
    <table>
        <thead>
        <tr>
            <th scope="col">Nome</th>
            <th scope="col">Descrição</th>
            <th scope="col">Valor</th>
            <th scope="col">Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="produto" items="${Produtos}">
            <tr>
                <td><c:out value="${produto.nome}" /></td>
                <td><c:out value="${produto.descricao}" /></td>
                <td><c:out value="${produto.preco}" /></td>
                <td>
                    <a href="editarProduto?id=${produto.id}">Editar</a> |
                    <a href="deletarProduto?id=${produto.id}" onclick="return confirm('Tem certeza que deseja deletar este produto?')">Deletar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</main>
</body>
</html>
