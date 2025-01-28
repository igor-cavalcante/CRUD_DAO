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

@WebServlet("/inserirProduto")
public class inserirProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");
        if (nome !=null && !nome.isBlank() && descricao != null && !descricao.isBlank() && valor !=null && !valor.isBlank()){
            Produto produto = new Produto(nome, descricao, Float.parseFloat(valor));
            try {
                ProdutoDaoInterface dao = new ProdutoDaoClasse();
                dao.insert(produto);
                dao.sair();
                response.sendRedirect("Produtos?mensagem= Produto Cadastrado com sucesso");
            } catch (NumberFormatException e) {
                System.out.println("Erro : o valor informado deve ser um numero valido"+e);;
                response.sendRedirect("Produtos?mensagem= erro ao tentar inserir");
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        }else{
            response.sendRedirect("Podutos?mensagem=preencha todos os campos");
        }
    }
}
