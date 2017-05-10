package auction.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private String email;

    public User(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }
}
