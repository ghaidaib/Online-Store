package table;

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
@Table(name = "Stores")
public class Stores {
    @Id
    @Column(name="Id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="User_id",nullable=false)
    private long user_id;
    @Column(name = "Kind",length = 50,nullable = false)
    private String kind;
    @Column(name = "Store_rating")
    private int store_rating;
    @Column(name = "Store_Name",length = 50,nullable = false)
    private String storeName;
    @Column(name = "Image_PathLocation")
    private String image_path;
    @Column(name = "Address",length = 50,nullable = false)
    private String address;
    @Column(name="Open_at")
    private Date openat;
    @Column(name="Close_at")
    private Date updatedat;

    @OneToMany(mappedBy="product")
    private Set<Products>products=new HashSet<>();

    public Set<Products> getProducts() {
        return products;
    }

    @OneToMany(mappedBy="rating")
    private Set<Rating>rating=new HashSet<>();

}
