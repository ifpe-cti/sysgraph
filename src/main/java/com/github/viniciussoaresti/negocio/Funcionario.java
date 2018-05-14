/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viniciussoaresti.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author corona
 */
@Entity
public class Funcionario {

    @Id
    @GeneratedValue
    private int codigo;
    @Column(length = 50)
    private String nome;
    @Column(length = 15)
    private String CPFCNPJ;
    @Column(length = 50)
    private String endereço;
    @Column(length = 9)
    private String telefone;
    @Column(length = 15)
    private String login;
    @Column(length = 15)
    private String senha;
    @Column(length = 15)
    private String cargo;
   

    public Funcionario(int codigo, String nome, String CPFCNPJ, String endereço, String telefone, String login, String senha, String cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPFCNPJ = CPFCNPJ;
        this.endereço = endereço;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;


    }

    public Funcionario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPFCNPJ() {
        return CPFCNPJ;
    }

    public void setCPFCNPJ(String CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

        public boolean equals (Object obj){
        if(obj == null){
            return false;
        }
        return codigo == ((Funcionario)obj).getCodigo();
    }
    
}

