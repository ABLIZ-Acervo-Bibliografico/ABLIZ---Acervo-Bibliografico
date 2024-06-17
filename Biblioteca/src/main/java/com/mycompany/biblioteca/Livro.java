/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author barba
 */
/**
 * Classe que representa um livro na biblioteca.
 * Define título, autor e gênero do livro.
 */
public class Livro {
    private String titulo;
    private String autor;
    private String genero;

    /**
     * Construtor que inicializa um livro com título, autor e gênero.
     * @param titulo Título do livro.
     * @param autor Autor do livro.
     * @param genero Gênero do livro.
     */
    public Livro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    /**
     * Obtém o título do livro.
     * @return Título do livro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do livro.
     * @param titulo Novo título do livro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém o autor do livro.
     * @return Autor do livro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Define o autor do livro.
     * @param autor Novo autor do livro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtém o gênero do livro.
     * @return Gênero do livro.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define o gênero do livro.
     * @param genero Novo gênero do livro.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Representação em string do livro.
     * @return String com título, autor e gênero do livro.
     */
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
