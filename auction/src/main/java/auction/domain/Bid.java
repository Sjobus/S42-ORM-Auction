package auction.domain;

import java.io.Serializable;
import javax.persistence.*;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

@Entity
public class Bid implements Serializable{

    @Id
    private int id;
    private FontysTime time;
    @ManyToOne
    private User buyer;
    private Money amount;

    public Bid(User buyer, Money amount) {
        this.buyer = buyer;
        this.amount = amount;
        this.time = FontysTime.now();
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
}
