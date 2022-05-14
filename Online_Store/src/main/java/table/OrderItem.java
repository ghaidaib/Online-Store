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
@Table(name = "Order_Item")
public class OrderItem {
    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Product_Id",nullable = false)
    private long productId;
    @Column(name = "Order_Id",nullable = false)
    private long orderId;
    @Column(name = "Price",nullable = false)
    private float price;
    @Column(name = "Discount")
    private float discount;
    @Column(name = "Content")
    private String content;
    @Column(name="Created_at")
    private Date createdat;
    @Column(name="Updated_at")
    private Date updatedat;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="orders_id",referencedColumnName = "id")
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }
}
