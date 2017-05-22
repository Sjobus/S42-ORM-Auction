package auction.domain;

import javax.persistence.*;
import nl.fontys.util.Money;
@Entity
@NamedQueries({
    @NamedQuery(name = "ItemDAO.findByDescription", query = "select a from Item as a where a.description = :description"),
    @NamedQuery(name = "ItemDAO.findById", query = "select a from Item as a where a.id = :id"),
    @NamedQuery(name = "ItemDAO.count", query = "select count(a) from Item as a")
})
public class Item implements Comparable {
    @Id
    private Long id;
    private Category category;
    private String description;
    
    @ManyToOne
    private User seller;
    @OneToOne
    private Bid highest;

    public Item(User seller, Category category, String description) {
        this.seller = seller;
        this.category = category;
        this.description = description;
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

    public boolean equals(Object o) {
        //TODO
        return false;
    }

    public int hashCode() {
        //TODO
        return 0;
    }
}
