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
package com.github.viniciussoaresti.infraestrutura.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Pedro Barros
 */
public class PersistenceDao {
    
    private static PersistenceDao instance = null;
    private EntityManagerFactory emf = null;
    
    private PersistenceDao(){
    
        this.emf = Persistence.createEntityManagerFactory("SysGraphPU");
    
    }
    
    public static PersistenceDao getInstance(){
        if(instance==null)
            instance = new PersistenceDao();
        return instance;
    }
    
    public void persist(Object o){
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(o);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void update(Object o){
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(o);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public List read(String sql){
        EntityManager em = emf.createEntityManager();
        
        List result = em.createQuery(sql).getResultList();
        
        em.close();
        
        return result;
    }
    
    
    public void delete(Object o){
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        em.remove(o);

        
        em.getTransaction().commit();
        em.close();
    }
}