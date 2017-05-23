package auction.domain;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "UserDAO.findByEmail", query = "select a from User as a where a.email = :email"),
    @NamedQuery(name = "UserDAO.count", query = "select count(a) from User as a")
})
public class User implements Serializable {

    @Id
    private String email;
    @OneToMany (mappedBy = "seller")
    private Set<Item> offeredItems;
    
    public User ()
    {}
    public User(String email) {
        this.email = email;

    }
        
    public String getEmail() {
        return email;
    }
    
    public Iterator getOfferedItems()
    {
        return offeredItems.iterator();
    }
    
    void addItem(Item item)
    {
        offeredItems.add(item);
    }
    
    public int numberOfOfferedItems()
    {
        return offeredItems.size();
    }
}
