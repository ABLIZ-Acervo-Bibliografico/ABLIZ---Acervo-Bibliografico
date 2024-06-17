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
 * Classe abstrata que representa um funcionário genérico da biblioteca.
 * Define atributos básicos e métodos acessores para nome e email.
 */
public abstract class Funcionario {
    private String nome;
    private String email;

    /**
     * Construtor da classe Funcionario.
     * @param nome Nome do funcionário.
     * @param email Email do funcionário.
     */
    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Obtém o nome do funcionário.
     * @return Nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     * @param nome Novo nome do funcionário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o email do funcionário.
     * @return Email do funcionário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do funcionário.
     * @param email Novo email do funcionário.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
