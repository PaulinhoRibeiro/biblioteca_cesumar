package controller;

import dao.LivroDAO;
import model.Livro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/livros")
public class LivroServlet extends HttpServlet {
  private LivroDAO livroDAO = new LivroDAO();

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String titulo = request.getParameter("titulo");
    String autor = request.getParameter("autor");
    int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
    String isbn = request.getParameter("isbn");

    Livro livro = new Livro(titulo, autor, anoPublicacao, isbn);
    livroDAO.cadastrar(livro);

    response.sendRedirect("lista-livros.xhtml");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String acao = request.getParameter("acao");

    if (acao != null && acao.equals("excluir")) {
      String idParam = request.getParameter("id");
      String isbnParam = request.getParameter("isbn");

      if (idParam != null) {
        int id = Integer.parseInt(idParam);
        livroDAO.removerPorId(id);
      } else if (isbnParam != null) {
        livroDAO.removerPorIsbn(isbnParam);
      }
    }

    request.setAttribute("livros", livroDAO.listarTodos());
    request.getRequestDispatcher("lista-livros.xhtml").forward(request, response);
  }
}
