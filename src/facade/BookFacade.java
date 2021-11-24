/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;
import javax.persistence.EntityManager;

/**
 *
 * @author Melnikov
 */
public class BookFacade extends AbstractFacade<Book>{
    
    public BookFacade(Class<Book> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
