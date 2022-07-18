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
@Table(name = "Promotion")
public class Promotion {
    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Product_Id",nullable = false)
    private long productId;
    @Column(name = "Price",nullable = false)
    private float price;
    @Column(name = "Discount")
    private float discount;
    @Column(name = "Quntity")
    private int quntity;
    @Column(name = "Content")
    private String content;
    @Column(name = "Image_PathLocation")
    private String image_path;
    @Column(name="Created_at")
    private Date createdat;
    @Column(name="Updated_at")
    private Date updatedat;

    @ManyToOne
    @JoinColumn(name="products_id",referencedColumnName = "id")
    private Products products;

    public Products getProducts() {
        return products;
    }
}
