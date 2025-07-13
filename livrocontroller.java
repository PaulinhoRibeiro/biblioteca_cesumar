package controller;

import dao.LivroDAO;
import model.Livro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LivroController {
  private Livro livro = new Livro("", "", 0, "");
  private LivroDAO livroDAO = new LivroDAO();
  private String mensagemErro;

  public String cadastrar() {
    if (validarCampos()) {
      livroDAO.cadastrar(livro);
      livro = new Livro("", "", 0, "");
      mensagemErro = null;
      return "lista-livros?faces-redirect=true";
    }
    return null;
  }

  public List<Livro> listarTodos() {
    return livroDAO.listarTodos();
  }

  public String removerPorIsbn(String isbn) {
    livroDAO.removerPorIsbn(isbn);
    return "lista-livros?faces-redirect=true";
  }

  public String removerPorId(int id) {
    livroDAO.removerPorId(id);
    return "lista-livros?faces-redirect=true";
  }

  private boolean validarCampos() {
    if (livro.getTitulo().isEmpty() || livro.getAutor().isEmpty() ||
        livro.getIsbn().isEmpty()) {
      mensagemErro = "Todos os campos são obrigatórios!";
      return false;
    }

    if (!livro.getIsbn().matches("\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d")) {
      mensagemErro = "ISBN inválido! Formato esperado: XXX-XX-XXXX-XXX-X";
      return false;
    }

    return true;
  }

  // Getters e Setters
  public Livro getLivro() {
    return livro;
  }

  public String getMensagemErro() {
    return mensagemErro;
  }
}
