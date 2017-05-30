package auction.domain;

import java.io.Serializable;
import javax.persistence.*;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

@Entity
public class Bid implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private FontysTime time;
    @ManyToOne
    private User buyer;
    private Money amount;
    @OneToOne @JoinColumn(nullable = false)
    private Item madeFor;
    
    public Bid()
    {
        
    }
    
    public Bid(User buyer, Money amount, Item item) {
        this.buyer = buyer;
        this.amount = amount;
        this.time = FontysTime.now();
        this.madeFor = item;
    }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getAmount() {
        return amount;
    }
    
    public Item getMadeFor()
    {
        return madeFor;
    }
}
