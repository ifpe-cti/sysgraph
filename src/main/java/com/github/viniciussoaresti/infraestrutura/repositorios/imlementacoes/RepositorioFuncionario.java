/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viniciussoaresti.infraestrutura.repositorios.imlementacoes;

import com.github.viniciussoaresti.negocio.Funcionario;
import com.github.viniciussoaresti.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author corona
 */
public class RepositorioFuncionario implements RepositorioGenerico<Funcionario, String> {

    private List<Funcionario> funcionarios = null;

    public RepositorioFuncionario() {
        this.funcionarios = new ArrayList<>();
    }
    @Override
    public void inserir(Funcionario t){
        this.funcionarios.add(t);
    }
    
    @Override
    public void alterar (Funcionario t){
        for (Funcionario e : this.funcionarios){
            if (e.getNome().equals( t.getNome())){
                e.setCodigo(t.getCodigo());
                e.setCPFCNPJ(t.getCPFCNPJ());
                e.setEndereço(t.getEndereço());
                e.setTelefone(t.getTelefone());
                e.setSenha(t.getSenha());
                return;
             }
        }
    }
    
    @Override
    public Funcionario recuperar(String codigo){
        for (Funcionario e : this.funcionarios){
            if(e.getNome().equals(codigo) ){
                return e;
            }
        }
        return null;
    }
    
    @Override
    public void deletar(Funcionario t){
        this.funcionarios.remove(t);
    }
    
    @Override
    public List<Funcionario> recuperarTodos(){
        return this.funcionarios;
    }

    

}