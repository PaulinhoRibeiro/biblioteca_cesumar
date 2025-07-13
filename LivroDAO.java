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
}
