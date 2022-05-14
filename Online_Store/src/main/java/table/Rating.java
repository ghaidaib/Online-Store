package table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "Rating")
public class Rating {
    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Rating",nullable = false)
    private int rating;
    @Column(name="Store_id",nullable=false)
    private long store_id;
    @Column(name="User_id",nullable=false)
    private long user_id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="store_id",referencedColumnName = "id")
    private Stores store;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;
}
