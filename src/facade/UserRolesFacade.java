/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Role;
import entity.User;
import entity.UserRoles;
import java.util.List;
import javax.persistence.EntityManager;
import tools.Singleton;

/**
 *
 * @author Melnikov
 */
public class UserRolesFacade extends AbstractFacade<UserRoles>{
    private EntityManager em;
    public UserRolesFacade() {
        super(UserRoles.class);
        Singleton singleton = Singleton.getInstance();
        em = singleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

  public String getTopRole(User user) {
    try {
      List<String> userRoles = em.createQuery("SELECT ur.role.roleName FROM UserRoles ur WHERE ur.user = :user")
              .setParameter("user", user)
              .getResultList();
        if(userRoles.contains("ADMINISTRATOR")){
          return "ADMINISTRATOR";
        }else
        if(userRoles.contains("MANAGER")){
          return "MANAGER";
        }else
        if(userRoles.contains("READER")){
          return "READER";
        }else
          return null;
    } catch (Exception e) {
      return null;
    }
  }
    
}
