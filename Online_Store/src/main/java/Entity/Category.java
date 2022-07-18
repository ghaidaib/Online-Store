package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Title",length = 75,nullable = false)
    private String title;
    @Column(name = "Image_PathLocation")
    private String image_path;
    @Column(name = "Content")
    private String content;
    @ManyToMany
    @JoinTable(
            name="product_category",
            joinColumns=@JoinColumn(name="category_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
    )
   private  Set<Products> product_category=new HashSet<>();

    public Set<Products> getProduct_category() {
        return product_category;
    }
}
