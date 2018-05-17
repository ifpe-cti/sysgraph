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
package com.github.viniciussoaresti.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author Vinícius Soares
 */
@Entity
public class Cliente {

    @Column(length = 50)
    private String nome;
    @Id
    @Column(length = 30)
    private String CPFCNPJ;
    @Column(length = 3)
    private int idade;
    @Column(length = 15)
    private String telefone;
    @Column(length = 35)
    private String email;

    public Cliente(String nome, String CPFCNPJ, int idade, String telefone, String email) {
        this.nome = nome;
        this.CPFCNPJ = CPFCNPJ;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente() {

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return CPFCNPJ == ((Cliente) obj).getCPFCNPJ();
    }

}
