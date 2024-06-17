
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.biblioteca;

/**
 *
 * @author barba
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal que representa o sistema de biblioteca ABLIZ - Acervo Bibliográfico.
 * Responsável por gerenciar interações com o usuário e funcionalidades do sistema.
 */
public class Biblioteca {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static Bibliotecario bibliotecarioLogado;

    /**
     * Método principal que inicia o sistema da biblioteca.
     * @param args Argumentos da linha de comando (não utilizados neste sistema).
     */
    public static void main(String[] args) {
        inicializarFuncionariosPadrao();

        boolean sair = false;
        while (!sair) {
            exibirMenuPrincipal();
            int opcao = obterOpcaoMenu();
            executarOpcao(opcao);
        }

        System.out.println("Saindo do sistema...");
        scanner.close();
    }

    /**
     * Inicializa os funcionários padrão da biblioteca.
     */
    private static void inicializarFuncionariosPadrao() {
        Funcionario bibliotecario = new Bibliotecario("Nome Bibliotecario", "nome.sobrenome@abliz.com", "ABLIZ");
        funcionarios.add(bibliotecario);
    }

    /**
     * Exibe o menu principal do sistema.
     */
    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Acessar como Bibliotecario");
        System.out.println("2. Criar conta");
        System.out.println("3. Listar Livros");
        System.out.println("4. Sair");

        if (bibliotecarioLogado != null) {
            System.out.println("5. Inserir Livro");
            System.out.println("6. Alterar Livro");
            System.out.println("7. Remover Livro");
        }

        System.out.print("Escolha uma opcao:");
    }

    /**
     * Obtém a opção escolhida pelo usuário no menu.
     * @return Opção escolhida pelo usuário.
     */
    private static int obterOpcaoMenu() {
        return scanner.nextInt();
    }

    /**
     * Executa a opção escolhida pelo usuário.
     * @param opcao Opção escolhida.
     */
    private static void executarOpcao(int opcao) {
        scanner.nextLine(); // limpar o buffer do scanner

        switch (opcao) {
            case 1 -> loginBibliotecario();
            case 2 -> criarConta();
            case 3 -> listarLivros();
            case 4 -> sair();
            case 5 -> {
                if (bibliotecarioLogado != null) {
                    inserirLivro();
                } else {
                    System.out.println("Opcao invalida. Tente novamente.");
                }
            }
            case 6 -> {
                if (bibliotecarioLogado != null) {
                    alterarLivro();
                } else {
                    System.out.println("Opcao invalida. Tente novamente.");
                }
            }
            case 7 -> {
                if (bibliotecarioLogado != null) {
                    removerLivro();
                } else {
                    System.out.println("Opcao invalida. Tente novamente.");
                }
            }
            default -> System.out.println("Opcao invalida. Tente novamente.");
        }
    }

    /**
     * Realiza o login do bibliotecario no sistema.
     */
    private static void loginBibliotecario() {
        System.out.print("Informe seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Informe o ID de bibliotecario:");
        String id = scanner.nextLine();

        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Bibliotecario bibliotecario) {
                if (bibliotecario.getEmail().equals(email) && bibliotecario.getId().equals(id)) {
                    System.out.println("Login realizado com sucesso!");
                    bibliotecarioLogado = bibliotecario;
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Dados incorretos. Nao foi possivel realizar o login.");
        }
    }

    /**
     * Cria uma nova conta de bibliotecário no sistema.
     */
    private static void criarConta() {
        System.out.print("Informe seu nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("Informe seu e-mail: ");
        String email = scanner.nextLine();

        if (email.matches("(?i)^[a-z]+\\.[a-z]+@abliz\\.com$")) {
            System.out.print("Informe seu ID: "); /*ABLIZ para Bibliotecário, 4 números para Professor*/
            String id = scanner.nextLine();
            if (id.equals("ABLIZ")) {
                Funcionario novoFuncionario = new Bibliotecario(nome, email, id);
                funcionarios.add(novoFuncionario);
                System.out.println("Conta de bibliotecario criada com sucesso.");
            } else {
                System.out.println("ID invalido. Nao foi possivel criar conta.");
            }
        } else {
            System.out.println("Email invalido. Nao foi possivel criar conta.");
        }
    }

    /**
     * Lista todos os livros disponíveis no sistema.
     */
    private static void listarLivros() {
        if (bibliotecarioLogado != null) {
            bibliotecarioLogado.listarLivros();
        } else {
            System.out.println("Voce precisa estar logado como Bibliotecario para acessar essa opcao.");
        }
    }

    /**
     * Insere um novo livro no acervo da biblioteca.
     */
    private static void inserirLivro() {
        if (bibliotecarioLogado != null) {
            bibliotecarioLogado.inserirLivro();
        } else {
            System.out.println("Voce precisa estar logado como Bibliotecario para acessar essa opcao.");
        }
    }

    /**
     * Altera informações de um livro no acervo da biblioteca.
     */
    private static void alterarLivro() {
        if (bibliotecarioLogado != null) {
            bibliotecarioLogado.listarLivros();
            bibliotecarioLogado.alterarLivro();
        } else {
            System.out.println("Voce precisa estar logado como Bibliotecario para acessar essa opcao.");
        }
    }

    /**
     * Remove um livro do acervo da biblioteca.
     */
    private static void removerLivro() {
        if (bibliotecarioLogado != null) {
            bibliotecarioLogado.listarLivros();
            bibliotecarioLogado.removerLivro();
        } else {
            System.out.println("Voce precisa estar logado como Bibliotecario para acessar essa opcao.");
        }
    }

    /**
     * Encerra a execução do sistema.
     */
    private static void sair() {
        scanner.close();
        System.exit(0);
    }
}
