package com.exemplo;


public class Livro {

    private int id; 
    private String titulo; 
    private int ano;
    private String autor;

     public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }
     
    public Livro() {
    
    }

    // Métodos Getters para cada atributo
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }
}

