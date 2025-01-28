package aula.jdbcmatutino.Dao;

import aula.jdbcmatutino.Modelo.Produto;

import java.util.List;


public interface ProdutoDaoInterface {

    public void insert (Produto produto) throws ErroDao;
    public Produto buscar(int codigo) throws ErroDao;
    public List<Produto> buscar() throws ErroDao;
    public void deleta(int codigo) throws ErroDao;
    public void sair() throws ErroDao;


}
