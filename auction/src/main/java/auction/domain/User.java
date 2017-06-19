package auction.domain;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "UserDAO.findByEmail", query = "select a from User as a where a.email = :email"),
    @NamedQuery(name = "UserDAO.count", query = "select count(a) from User as a")
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

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof User)
        {
            if(this.getEmail() == ((User) o).getEmail())
            {
                return true;
            }
        }
        return false;
    }
   
    
}
