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


        .form-pesquisar {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 20px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 90%; /* Responsivo */
            max-width: 400px; /* Limite para telas grandes */
        }

        .form-pesquisar h2 {
            margin-bottom: 15px;
            color: #333;
            font-size: 1.5rem;
            font-weight: bold;
        }

        .pesquisar {
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 10px;
            width: 100%; /* Para se adaptar ao container */
        }

        .pesquisar input[type="text"] {
            flex: 1;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
        }

        .pesquisar button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .pesquisar button:hover {
            background-color: #0056b3;
        }

        .pesquisar button i {
            margin-right: 5px;
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

        .false{
            color: rgba(0, 0, 0, 0.87);
            background-color: rgba(136, 24, 24, 0.45);
            border: 1px solid black;
        }
    </style>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var mensagemDiv = document.getElementById("mensagem");
            if (mensagemDiv) {
                // Obtém o valor de Sucess vindo do servidor
                var isSucess = '<c:out value="${sessionScope.Sucess}" default="true" />';

                // Lógica para alterar a classe com base no Sucess
                if (isSucess === 'false') {
                    mensagemDiv.classList.add("false");
                } else {
                    mensagemDiv.classList.remove("false"); // Garante que a classe não esteja presente
                }

                // Esconde a mensagem após 5 segundos
                setTimeout(function () {
                    mensagemDiv.style.display = 'none';
                }, 5000);
            }
        });

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




    <div class="form-pesquisar">
        <h2>Pesquisar Produto</h2>
        <form action="buscarProduto" method="GET" >
            <div class="pesquisar">
                <input
                        type="text"
                        name="nome"
                        placeholder="Nome do produto"
                        aria-label="Pesquisar produto"
                />
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i> Buscar
                </button>
            </div>
        </form>
    </div>


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
