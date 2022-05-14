package table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;
import java.util.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name="Orders")
public class Orders {
    @Id
    @Column(name="Id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="User_id",nullable=false)
    private long user_id;
    @Column(name="Cart_id",nullable=false)
    private long cart_id;
    @Column(name="Token", length=100)
    private String token;
    @Column(name="Status")
    private int status;
    @Column(name="SubTotal")
    private float subTotal;
    @Column(name="Item_discount")
   private float item_discount;
    @Column(name="Tax")
    private float tax;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }
    @OneToMany(mappedBy="orders")
    private Set<OrderItem>OrderItem=new HashSet<>();

    public Set<OrderItem> getOrderItem() {
        return OrderItem;
    }


    @OneToMany(mappedBy="orders")
    private Set<Transaction>transaction=new HashSet<>();

    public Set<Transaction> getTransaction() {
        return transaction;
    }
}
