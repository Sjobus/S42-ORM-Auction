package auction.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Bid implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private FontysTime time;
    @ManyToOne
    private User buyer;
    private Money amount;


    public Bid()
    {
        this.time = FontysTime.now();
    }
    
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
    
    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
