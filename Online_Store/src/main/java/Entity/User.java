package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "users")
public class User {
    @Id
    @Column(name="Id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="First Name", length=50, nullable=false, unique=false)
    private String firstname;
    @Column(name="Last Name", length=50, nullable=false, unique=false)
    private String lastname;
    @Column(name="Mobile", length=15, nullable=false, unique=true)
    private String mobile;
    @Column(name="Email", length=50, nullable=false, unique=true)
    private String email;
    @Column(name="Password", length=32, nullable=false, unique=false)
    private String password;
    @Column(name="Registeredat")
    private Date registeredat;
    @Column(name="Lastlogin")
    private Date lastlogin;


    @OneToMany(mappedBy="user")
    private Set<Cart>carts=new HashSet<>();

    public Set<Cart> getCarts() {
        return carts;
    }

    @OneToMany(mappedBy="user")
    private Set<Orders>orders=new HashSet<>();

    public Set<Orders> getOrders() {
        return orders;
    }

    @OneToMany(mappedBy="user")
    private Set<Transaction>transaction=new HashSet<>();

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    @OneToMany(mappedBy="rating")
    private Set<Rating>rating=new HashSet<>();
}
