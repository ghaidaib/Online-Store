package Repository;

import Entity.User;
import org.springframework.stereotype.Repository;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void insertWithQuery(User user) {
        entityManager.createNativeQuery("INSERT INTO User (id, firstname, lastname,mobile,email,password,registeredat,lastlogin) " +
                        "VALUES (?,?,?,?,?,?,?,?)")
                .setParameter(1, User.getid())
                .setParameter(2, User.getfirstName())
                .setParameter(3, User.getlastName())
                .setParameter(4, User.getmobile())
                .setParameter(5, User.getemail())
                .setParameter(6, User.getpassword())
                .setParameter(7, User.getregisterdat())
                .setParameter(8, User.getlastLogin())
                .executeUpdate();

    }
    @Test
    public void userQuery() {
        User user = new User(1, "ghaida", "ibraheem", "096757567", "19ghgh19@gmail.com", "1233", "12/2/2022", "20/6/2022");

        assertThatExceptionOfType(PersistenceException.class).isThrownBy(() -> {
            userInsertRepository.insertWithQuery(USER);
            userInsertRepository.insertWithQuery(USER);
        });
    }


}