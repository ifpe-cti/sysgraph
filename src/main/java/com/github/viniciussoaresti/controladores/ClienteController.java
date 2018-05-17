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
import com.github.viniciussoaresti.infraestrutura.repositorios.implementacoes.RepositorioClienteImplBD;
import com.github.viniciussoaresti.negocio.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Vinícius Soares
 */
@ManagedBean
@SessionScoped
public class ClienteController {
    
    private RepositorioGenerico<Cliente,String> repositorioCliente = null;
    private Cliente clienteCadastro;
    private Cliente selectedCliente;
    
    public ClienteController(){
        this.repositorioCliente = new RepositorioClienteImplBD();
        this.clienteCadastro = new Cliente();
    }
    
    public void inserir(){
        
        this.repositorioCliente.inserir(this.clienteCadastro);
        this.clienteCadastro = new Cliente();
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O cliente foi cadastrado com sucesso!"));
    }
    
    public void alterar(Cliente c){
        this.repositorioCliente.alterar(c);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O cliente foi alterado com sucesso!"));
    }
    
    public Cliente recuperarCliente(String CPFCNPJ){
        return this.repositorioCliente.recuperar(CPFCNPJ);
    }
    
    public void deletar(Cliente c){
        this.repositorioCliente.deletar(c);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O cliente foi deletado com sucesso!"));
    }
    
    public List<Cliente> recuperarTodosClientes(){
        return this.repositorioCliente.recuperarTodos();
    }

    public Cliente getClienteCadastro() {
        return clienteCadastro;
    }

    public void setClienteCadastro(Cliente clienteCadastro) {
        this.clienteCadastro = clienteCadastro;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public RepositorioGenerico<Cliente, String> getRepositorioCliente() {
        return repositorioCliente;
    }

    public void setRepositorioCliente(RepositorioGenerico<Cliente, String> repositorioCliente) {
        this.repositorioCliente= repositorioCliente;
    }
}
