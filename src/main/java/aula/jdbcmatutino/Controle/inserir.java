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

@WebServlet("/inserir")
public class inserir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Produto produto = new Produto("teste", "testedescricao", 30.0f);
        try {
            ProdutoDaoInterface dao = new ProdutoDaoClasse();
            dao.insert(produto);
            dao.sair();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }


    }
}
