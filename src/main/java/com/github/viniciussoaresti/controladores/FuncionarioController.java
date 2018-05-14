
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viniciussoaresti.controladores;

import com.github.viniciussoaresti.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import com.github.viniciussoaresti.infraestrutura.repositorios.imlementacoes.RepositorioFuncionarioImplDB;
import com.github.viniciussoaresti.negocio.Funcionario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1860915
 */

@ManagedBean
@SessionScoped
public class FuncionarioController {
    
    private RepositorioGenerico<Funcionario,Integer> repositorioFuncionario = null;
    private Funcionario funcionarioCadastro;
    private Funcionario selectedFuncionario;
    private String login;
    private String senha;
    public FuncionarioController(){
        this.repositorioFuncionario = new RepositorioFuncionarioImplDB();
        this.funcionarioCadastro = new Funcionario();
        
    }
    
    public void inserir(){
        
        //String nome =((String)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("advogadoController"));
        
        if(this.funcionarioCadastro.getNome().toLowerCase().contains("aralho")){
        FacesContext.getCurrentInstance().addMessage("formDialCadFuncionario:txtNome", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro",
                            "Voce digitou um nome inválido"));
            
            return;
        }
        
        this.repositorioFuncionario.inserir(this.funcionarioCadastro);
        this.funcionarioCadastro = new Funcionario();
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O funcionário foi cadastrado com sucesso!"));
    }
    
    public void alterar(Funcionario f){
        this.repositorioFuncionario.alterar(f);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O funcionário foi alterado com sucesso!"));
    }
    
    public Funcionario recuperarFuncionario(Integer codigo){
        return this.repositorioFuncionario.recuperar(codigo);
    }
    
    public void deletar(Funcionario f){
        this.repositorioFuncionario.deletar(f);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O funcionário foi deletado com sucesso!"));
    }
    
    public List<Funcionario> recuperarTodosFuncionarios(){
        return this.repositorioFuncionario.recuperarTodos();
    }

    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
        this.funcionarioCadastro = funcionarioCadastro;
    }

    public Funcionario getSelectedFuncionario() {
        return selectedFuncionario;
    }

    public void setSelectedFuncionario(Funcionario selectedFuncionario) {
        this.selectedFuncionario = selectedFuncionario;
    }
     public String logar(){
       Funcionario f= ((RepositorioFuncionarioImplDB)this.repositorioFuncionario).recuperaLogin(login);   
    if(f!=null && f.getSenha().equals(senha)){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionarioConectado", f);
        return "menuFuncionario.xhtml?faces-redirect=true";
    }
       return null;
}

    public RepositorioGenerico<Funcionario, Integer> getRepositorioFuncionario() {
        return repositorioFuncionario;
    }

    public void setRepositorioFuncionario(RepositorioGenerico<Funcionario, Integer> repositorioFuncionario) {
        this.repositorioFuncionario= repositorioFuncionario;
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
    
    
    
}
