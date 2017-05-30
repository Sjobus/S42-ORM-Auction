package auction.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import nl.fontys.util.Money;
@Entity
@NamedQueries({
    @NamedQuery(name = "ItemDAO.findByDescription", query = "select a from Item as a where a.description = :description"),
    @NamedQuery(name = "ItemDAO.findById", query = "select a from Item as a where a.id = :id"),
    @NamedQuery(name = "ItemDAO.count", query = "select count(a) from Item as a")
})
public class Item implements Serializable, Comparable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Category category;
    private String description;
    
    @ManyToOne
    private User seller;
    @OneToOne
    private Bid highest;
    public Item()
    {
        
    }
    public Item(User seller, Category category, String description) {
        this.seller = seller;
        this.category = category;
        this.description = description;
        seller.addItem(this);
    }

    public Long getId() {
        return id;
    }

    public User getSeller() {
        return seller;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highest;
    }

    public Bid newBid(User buyer, Money amount) {
        if (highest != null && highest.getAmount().compareTo(amount) >= 0) {
            return null;
        }
        highest = new Bid(buyer, amount);
        return highest;
    }

    public int compareTo(Object arg0) {
        //TODO
        return -1;
    }

    @Override
    public boolean equals(Object o) 
    {                           
        if(o instanceof Item)
        {
           if(this == o)
               return true;
           else
               return false;
        }           
        return false;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result +((description == null) ? 0 : description.hashCode());
        //result = prime * result + id.intValue();
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((seller == null) ? 0 : seller.hashCode());
        result = prime * result + ((highest == null) ? 0 : highest.hashCode());
        return result;
    }
}
