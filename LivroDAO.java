package dao;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
  private static List<Livro> livros = new ArrayList<>();
  private static int proximoId = 1;

  public void cadastrar(Livro livro) {
    livro.setId(proximoId++);
    livros.add(livro);
  }

  public List<Livro> listarTodos() {
    return new ArrayList<>(livros);
  }

  public boolean removerPorIsbn(String isbn) {
    return livros.removeIf(l -> l.getIsbn().equals(isbn));
  }

  public boolean removerPorId(int id) {
    return livros.removeIf(l -> l.getId() == id);
  }

}2.3

Página JSP (index.jsp)
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Biblioteca Cesumar</title>
</head>
<body>
    <h1>Bem-vindo ao Sistema da Biblioteca</h1>
    <a href="cadastro-livro.xhtml">Cadastrar Livro</a> | 
    <a href="lista-livros.xhtml">Ver Acervo</a>
</body>
</html>
