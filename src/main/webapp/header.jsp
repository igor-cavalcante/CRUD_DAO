<%--
  Created by IntelliJ IDEA.
  User: Igorc
  Date: 29/01/2025
--%>

<html>
<head>
    <script src="https://kit.fontawesome.com/aa0a6797c8.js" crossorigin="anonymous"></script>
    <style>
        /* Estilo global */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Estilos para o cabeçalho */
        #header {
            background-color: #2c3e50;
            color: #ecf0f1;
            width: 100%;
            padding: 15px 20px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            position: fixed; /* Fixa o cabeçalho no topo */
            top: 0;
            left: 0;
            z-index: 1000;
        }

        #header .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
        }

        #logo a {
            text-decoration: none;
            color: #ecf0f1;
            font-size: 28px;
            font-weight: bold;
        }

        #menu ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            gap: 20px;
        }

        #menu ul li a {
            text-decoration: none;
            color: #ecf0f1;
            font-size: 16px;
            padding: 10px 15px;
            border-radius: 4px;
            transition: all 0.3s ease;
        }

        #menu ul li a:hover {
            background-color: #34495e;
        }

        /* Espaçamento do conteúdo principal */
        main {
            margin-top: 80px; /* Adiciona espaço abaixo do cabeçalho fixo */
            padding: 20px;
        }

        /* Responsividade para dispositivos menores */
        @media (max-width: 768px) {
            #menu ul {
                flex-direction: column;
                gap: 10px;
            }
        }

        @media (max-width: 576px) {
            #header .container {
                flex-direction: column;
                gap: 10px;
            }

            #logo a {
                font-size: 22px;
            }

            #menu ul li a {
                font-size: 14px;
                padding: 8px 10px;
            }
        }
    </style>
</head>
<body>
<header id="header">
    <div class="container">
        <div id="logo">
            <a href="index.jsp">Minha Loja</a>
        </div>
        <nav id="menu">
            <ul>
                <li><a href="index.jsp">Cadastrar produto</a></li>
                <li><a href="Produtos">Produtos</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
    </div>
</header>


</body>
</html>
