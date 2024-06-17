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
 * Classe que representa um bibliotecário na biblioteca.
 * Extende Funcionario e inclui métodos específicos para gerenciar livros.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecario extends Funcionario {
    private String id;
    private List<Livro> livrosCadastrados;

    /**
     * Construtor da classe Bibliotecario.
     * @param nome Nome do bibliotecário.
     * @param email Email do bibliotecário.
     * @param id ID do bibliotecário.
     */
    public Bibliotecario(String nome, String email, String id) {
        super(nome, email);
        this.id = id;
        this.livrosCadastrados = new ArrayList<>();
    }

    /**
     * Obtém o ID do bibliotecário.
     * @return ID do bibliotecário.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID do bibliotecário.
     * @param id Novo ID do bibliotecário.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém a lista de livros cadastrados pelo bibliotecário.
     * @return Lista de livros cadastrados.
     */
    public List<Livro> getLivrosCadastrados() {
        return livrosCadastrados;
    }

    /**
     * Adiciona um novo livro à lista de livros cadastrados pelo bibliotecário.
     * @param livro Livro a ser adicionado.
     */
    public void adicionarLivro(Livro livro) {
        livrosCadastrados.add(livro);
    }

    /**
     * Remove um livro da lista de livros cadastrados pelo bibliotecário.
     * @param livro Livro a ser removido.
     */
    public void removerLivro(Livro livro) {
        livrosCadastrados.remove(livro);
    }

    /**
     * Lista todos os livros cadastrados pelo bibliotecário.
     * Se não houver livros cadastrados, exibe uma mensagem informando isso.
     */
    public void listarLivros() {
        if (livrosCadastrados.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Livros cadastrados:");
            for (Livro livro : livrosCadastrados) {
                System.out.println(livro);
            }
        }
    }

    /**
     * Permite ao bibliotecário inserir um novo livro no sistema.
     * Solicita título, autor e gênero do novo livro.
     */
    public void inserirLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o titulo do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Informe o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Informe o genero do livro: ");
        String genero = scanner.nextLine();

        Livro novoLivro = new Livro(titulo, autor, genero);
        livrosCadastrados.add(novoLivro);
        System.out.println("Livro adicionado com sucesso.");
    }

    /**
     * Permite ao bibliotecário alterar informações de um livro cadastrado.
     * Solicita o título do livro a ser alterado e os novos dados (título, autor e gênero).
     */
    public void alterarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o titulo do livro que deseja alterar: ");
        String tituloAntigo = scanner.nextLine();
        System.out.print("Informe o novo titulo do livro: ");
        String tituloNovo = scanner.nextLine();
        System.out.print("Informe o novo autor do livro: ");
        String autorNovo = scanner.nextLine();
        System.out.print("Informe o novo genero do livro: ");
        String generoNovo = scanner.nextLine();

        Livro livroAntigo = buscarLivro(tituloAntigo);
        if (livroAntigo != null) {
            Livro livroNovo = new Livro(tituloNovo, autorNovo, generoNovo);
            livrosCadastrados.remove(livroAntigo);
            livrosCadastrados.add(livroNovo);
            System.out.println("Livro alterado com sucesso.");
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    /**
     * Permite ao bibliotecário remover um livro cadastrado.
     * Solicita o título do livro a ser removido.
     */
    public void removerLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o titulo do livro que deseja remover: ");
        String titulo = scanner.nextLine();

        Livro livro = buscarLivro(titulo);
        if (livro != null) {
            livrosCadastrados.remove(livro);
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    /**
     * Busca um livro na lista de livros cadastrados pelo título.
     * @param titulo Título do livro a ser buscado.
     * @return O livro encontrado ou null se não encontrado.
     */
    private Livro buscarLivro(String titulo) {
        for (Livro livro : livrosCadastrados) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
}
