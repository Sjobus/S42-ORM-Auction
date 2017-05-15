package auction.domain;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "User.findByEmail", query = "select a from User as a"),
    @NamedQuery(name = "User.Count", query = "select count(a) from User as a")
})
public class User implements Serializable {

    @Id
    private String email;
    public User ()
    {}
    public User(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }
}
