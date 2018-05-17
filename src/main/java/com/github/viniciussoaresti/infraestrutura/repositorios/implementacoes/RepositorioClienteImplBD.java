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
import com.github.viniciussoaresti.infraestrutura.dao.PersistenceDao;
import com.github.viniciussoaresti.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import com.github.viniciussoaresti.negocio.Cliente;
import java.util.List;
import javax.persistence.Persistence;
/**
 *
 * @author Vinícius Soares
 */
public class RepositorioClienteImplBD implements RepositorioGenerico<Cliente, String>{
     @Override
    public void inserir(Cliente t) {
        PersistenceDao.getInstance().persist(t);
    }

    @Override
    public void alterar(Cliente t) {
        PersistenceDao.getInstance().update(t);
    }

    @Override
    public Cliente recuperar(String CPFCNPJ) {
       try{
           return (Cliente)PersistenceDao.getInstance().read("select a from Cliente a where a.CPFCNPJ="+CPFCNPJ).get(0);
       }catch(IndexOutOfBoundsException index){
           return null;
       }
    }

    @Override
    public void deletar(Cliente t) {
    PersistenceDao.getInstance().delete(t);
    
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return PersistenceDao.getInstance().read("select a from Cliente a");

    }
    public Cliente recuperaLogin(String CPFCNPJ){
        try{
            return(Cliente)(PersistenceDao.getInstance().read("select a from Cliente a where a.CPFCNPJ='"+CPFCNPJ+"'").get(0));
                    }catch(IndexOutOfBoundsException index){
                        return null;
               }
        }
    
}
