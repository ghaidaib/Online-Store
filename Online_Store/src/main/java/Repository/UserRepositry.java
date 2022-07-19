package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.Entity.User;
import java.security.PublicKey;

@Repository
public class UserRepositry {

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(int id){
     return  entityManager.find(User.class,id);
    }
   public User update(User user){
       return entityManager.merge(user);
   }

    public User insert(User user){
       return entityManager.merge(user);
    }
    public void deleteById(int id){
        User user=findById(id);
       entityManager.remove(user);

    }
    public List<User> findAll(){
        TypedQuery<User> namedQuery=entityManager.createNamedQuery("find all users",User.class);
      return  namedQuery.getResultList();
    }

}
