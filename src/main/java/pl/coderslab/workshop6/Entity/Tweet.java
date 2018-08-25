package pl.coderslab.workshop6.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    Date created;

    @NotEmpty
    @Column(nullable = false, name = "tweet_text")
    String text;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "tweet")
    Set<Comment> commnts;

    public Tweet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getCommnts() {
        return commnts;
    }

    public void setCommnts(Set<Comment> commnts) {
        this.commnts = commnts;
    }
}
