/*MIT License

Copyright (c) 2018 - SysGraph - Vinícius H., Matheus Dionísio, Pedro Barros e Tiago Eduardo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/
package com.github.viniciussoaresti.controladores;

import com.github.viniciussoaresti.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import com.github.viniciussoaresti.infraestrutura.repositorios.implementacoes.RepositorioFuncionarioImplDB;
import com.github.viniciussoaresti.negocio.Funcionario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro Barros
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
