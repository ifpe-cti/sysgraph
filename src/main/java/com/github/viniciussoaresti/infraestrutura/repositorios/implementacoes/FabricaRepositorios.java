/*MIT License

Copyright (c) 2018 - SysGraph - Vinícius H., Matheus Dionísio, Pedro Barros and Tiago Eduardo
Permission is hereby granted, free of charge, to any person obtaining a copy of this software
and associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.viniciussoaresti.infraestrutura.repositorios.implementacoes;
import com.github.viniciussoaresti.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
/**
 *
 * @author Vinícius Soares
 */
public class FabricaRepositorios {
    public static final int CLIENTE = 1;
    public static final int SERVICO = 2;
    public static final int PRODUTO= 3;
    public static final int FUNCIONARIO = 4;
    public static final int ADMINISTRADOR = 5;
    public static final int ESTOQUE = 6;
    public static final int MÉTODO = 7;
    
     public static final int MEMORIA= 1;
      public static final int BANCODADOS= 2;
       public static final int ARQUIVO= 3;
      
    public static RepositorioGenerico manufactor (int tipoNegocio, int tipoPersistencia){
        if(tipoPersistencia== MEMORIA){
            if(tipoNegocio==CLIENTE){
            //    return new RepositorioCliente();
            }
            if(tipoNegocio== SERVICO){
            //   return new RepositorioServico();           
            }
            if(tipoNegocio== PRODUTO){
            //    return RepositorioProduto();
            }
            if(tipoNegocio == FUNCIONARIO){
            //    return new RepositorioFuncionario();
            }
            if(tipoNegocio == ADMINISTRADOR){
            //    return new RepositorioAdministrador();
            }
            if(tipoNegocio == ESTOQUE){
            //    return new RepositorioEstoque();
            }
            if(tipoNegocio == MÉTODO){
            //    return new RepositorioMetodo();
            }
        }
        if(tipoPersistencia == BANCODADOS){
            return null;
        }    
          if(tipoPersistencia == ARQUIVO){
            return null;
    }
          return null;
    
}
}
