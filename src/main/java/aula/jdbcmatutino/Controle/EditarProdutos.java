package aula.jdbcmatutino.Controle;

import aula.jdbcmatutino.Dao.ErroDao;
import aula.jdbcmatutino.Dao.ProdutoDaoClasse;
import aula.jdbcmatutino.Dao.ProdutoDaoInterface;
import aula.jdbcmatutino.Modelo.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/editarProduto")
public class EditarProdutos extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String sid = request.getParameter("id");

        if (sid != null && !sid.isBlank()) {
            try {
                int id = Integer.parseInt(sid);
                try {
                    ProdutoDaoInterface dao = new ProdutoDaoClasse();
                    Produto p = dao.buscar(id);
                    dao.sair();
                    request.setAttribute("Produto", p);


                    // Despacha para a JSP
                    request.getRequestDispatcher("/WEB-INF/EditarProduto.jsp").forward(request, response);
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
            }catch (NumberFormatException e) {
                String errorMessage = "O valor de 'id' não é um número válido: " + request.getAttribute("id");
            }
        } else {
            response.sendRedirect("Podutos?mensagem=O id não é um numero");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor =request.getParameter("valor");

        if (sid == null || sid.isBlank()) {
            response.sendRedirect("Produtos?mensagem=ID não informado");
            return;
        }

        if (nome !=null && !nome.isBlank() && descricao != null && !descricao.isBlank() && valor !=null && !valor.isBlank()){
            try {
                int id = Integer.parseInt(sid);
                Produto produto = new Produto(nome, descricao, Float.parseFloat(valor));

                // Logando para depuração
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Descrição: " + descricao);
                System.out.println("Valor: " + valor);


                ProdutoDaoInterface dao = new ProdutoDaoClasse();
                dao.editar(produto, id);
                dao.sair();

                HttpSession session = request.getSession();
                session.setAttribute("Mensagem", "Produto "+produto.getNome()+" Editado com sucesso!");
                response.sendRedirect("Produtos");

            } catch (NumberFormatException e) {
                System.out.println("Erro : o valor informado deve ser um numero valido"+e);;
                response.sendRedirect("Produtos?mensagem= erro ao tentar Editar");
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        }else{
            response.sendRedirect("Podutos?mensagem=preencha todos os campos");
        }


    }
}
