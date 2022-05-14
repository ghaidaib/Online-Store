package table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "Transaction")
public class Transaction {
    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="User_id",nullable=false)
    private long user_id;
    @Column(name = "Order_Id",nullable = false)
    private long orderId;
    @Column(name = "Code",length = 100)
    private String code;
    @Column(name="Type")
    private int type;
    @Column(name="Mode")
    private int mode;
    @Column(name="Status")
    private int status;
    @Column(name="Created_at")
    private Date createdat;
    @Column(name="Updated_at")
    private Date updatedat;
    @Column(name = "Content")
    private String content;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="orders_id",referencedColumnName = "id")
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }
}
