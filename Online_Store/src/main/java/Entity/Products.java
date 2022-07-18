package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "Products")
public class Products {
    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Store_id",nullable=false)
    private long store_id;
    @Column(name = "Title",length = 75,nullable = false)
    private String title;
    @Column(name="Type")
    private int type;
    @Column(name = "Product_rating")
    private int product_rating;
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
    private Date createdat;
    @Column(name="Updated_at")
    private Date updatedat;
    @ManyToMany(mappedBy="product_category")
    private  Set<Category> categorys=new HashSet<>();

    public Set<Category> getCategorys() {
        return categorys;
    }

    @ManyToOne
    @JoinColumn(name="store_id",referencedColumnName = "id")
    private Stores store;

    public Stores getStore() {
        return store;
    }

    @OneToMany(mappedBy="promotion")
    private Set<Promotion>promotions=new HashSet<>();

    public Set<Promotion> getPromotions() {
        return promotions;
    }
}
