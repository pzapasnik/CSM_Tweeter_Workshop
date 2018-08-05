package pl.coderslab.workshop6.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.UniqueElements;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Column
    private String hash;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private boolean enable = true;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passworld) {
        this.password = BCrypt.hashpw(passworld, this.getHash());
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = BCrypt.gensalt();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.getHash());
    }
}
