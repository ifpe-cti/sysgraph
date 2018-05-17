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
package com.github.viniciussoaresti.infraestrutura.repositorios.implementacoes;

import com.github.viniciussoaresti.negocio.Funcionario;
import com.github.viniciussoaresti.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Barros
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