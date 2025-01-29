package aula.jdbcmatutino.Controle;

import aula.jdbcmatutino.Dao.ErroDao;
import aula.jdbcmatutino.Dao.ProdutoDaoClasse;
import aula.jdbcmatutino.Dao.ProdutoDaoInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deletarProduto")
public class DeletarProduto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");

        if (sid != null && !sid.isBlank()) {
            try {
                int id = Integer.parseInt(sid);
                try {
                    ProdutoDaoInterface dao = new ProdutoDaoClasse();
                    dao.deleta(id);
                    dao.sair();

                    response.sendRedirect("Produtos");
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
            }catch (NumberFormatException e) {
                    String errorMessage = "O valor de 'id' não é um número válido: " + request.getAttribute("id");
                    // Logando ou manipulando a exceção de maneira mais detalhada
                }

        } else {
            response.sendRedirect("Podutos?mensagem=O id não é um numero");
        }
    }
}
