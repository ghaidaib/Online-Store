package table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name ="Cart")
public class Cart {
    @Id
    @Column(name="Id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="User_id",nullable=false)
    private long user_id;
    @Column(name="Token", length=100)
    private String token;
    @Column(name="Status")
    private int status;
    @Column(name = "Content")
    private String content;
    @Column(name = "Order_type")
    private int order_type;
    @Column(name="Created_at")
    private Date createdat;
    @Column(name="Updated_at")
    private Date updatedat;
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="user_id",referencedColumnName = "id")
     private User user;

    public User getUser() {
        return user;
    }


    @OneToMany(mappedBy="cart")
    private Set<CartItem>cartItems=new HashSet<>();
    public Set<CartItem> getCartItems() {
        return cartItems;
    }
}
