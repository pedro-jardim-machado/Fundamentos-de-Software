package com.exemplo;

import java.util.List;

public interface IAcervoRepository {
    List<Livro> getAll();
    List<String> getTitulos();
    List<String> getAutores();
    List<Livro> getLivrosDoAutor(String autor);
    Livro getLivroTitulo(String titulo);
    String cadastraLivroNovo(Livro livro);
    boolean removeLivro(long codigo);
}
