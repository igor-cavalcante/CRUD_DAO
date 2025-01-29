package aula.jdbcmatutino.Controle;

import aula.jdbcmatutino.Dao.ErroDao;
import aula.jdbcmatutino.Dao.ProdutoDaoClasse;
import aula.jdbcmatutino.Dao.ProdutoDaoInterface;
import aula.jdbcmatutino.Modelo.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Produtos")
public class ListarProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProdutoDaoInterface dao = new ProdutoDaoClasse();
            List<Produto> produtos = dao.buscar();
            request.setAttribute("Produtos",produtos);
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }

        // Obtém a mensagem da sessão, se existir
        HttpSession session = request.getSession(false);
        if(session != null) {
            String mensagem = (String) session.getAttribute("Mensagem");
            if (mensagem != null) {
                // Define a mensagem como atributo da requisição
                request.setAttribute("Mensagem", mensagem);
                // Remove a mensagem da sessão para evitar exibição repetida
                session.removeAttribute("Mensagem");
            }
        }

        // Despacha para a JSP
        request.getRequestDispatcher("/WEB-INF/Produtos.jsp").forward(request, response);

    }
}
