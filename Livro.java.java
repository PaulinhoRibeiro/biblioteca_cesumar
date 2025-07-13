package model;

public class Livro {
  private int id;
  private String titulo;
  private String autor;
  private int anoPublicacao;
  private String isbn;

  // Construtor
  public Livro(String titulo, String autor, int anoPublicacao, String isbn) {
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
    this.isbn = isbn;
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getAnoPublicacao() {
    return anoPublicacao;
  }

  public void setAnoPublicacao(int anoPublicacao) {
    this.anoPublicacao = anoPublicacao;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
