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

import java.io.IOException;
import java.util.List;


@WebServlet("/buscarProduto")
public class BuscarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");

        if (nome != null && !nome.isBlank()) {

                try {
                    ProdutoDaoInterface dao = new ProdutoDaoClasse();
                    List<Produto> p = dao.buscar(nome);
                    dao.sair();
                    request.setAttribute("Produtos", p);
                    // Despacha para a JSP
                    request.getRequestDispatcher("WEB-INF/Produtos.jsp").forward(request, response);
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
        } else {
            request.setAttribute("Mensagem", "error ao pesquisar");
            // Despacha para a JSP
            request.getRequestDispatcher("/WEB-INF/Produtos.jsp").forward(request, response);
        }

    }
}
