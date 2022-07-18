package Entity;

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
@Table(name = "Cart_Item")
public class CartItem {
    @Id
    @Column(name="Id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Product_Id",nullable = false)
    private long productId;
    @Column(name = "Cart_Id",nullable = false)
    private long cartId;
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

    @ManyToOne
    @JoinColumn(name="cart_id",referencedColumnName = "id")
    private Cart cart;

    public Cart getCart() {
        return cart;
    }
}
