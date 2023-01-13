package ca.letkeman.gymMan.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="user")
@Table(name = "\"user\"")

final public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="creatorId")
    private User creator;
    @Column(name="isActive")
    private Boolean active;
    @Column(name="isDeleted")
    private Boolean deleted;
    private LocalDateTime createDateTime;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    /* */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Boolean isActive() {
        return active;
    }

    public void isActive(Boolean active) {
        this.active = active;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void isDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    /* */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive().equals(user.isActive()) && isDeleted().equals(user.isDeleted()) && getCreateDateTime().equals(user.getCreateDateTime()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive(), isDeleted(), getCreateDateTime(), getEmail(), getPassword(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("creator=" + getCreator())
                .add("active=" + isActive())
                .add("deleted=" + isDeleted())
                .add("createDateTime=" + getCreateDateTime())
                .add("email='" + getEmail() + "'")
                .add("password='" + getPassword() + "'")
                .add("firstName='" + getFirstName() + "'")
                .add("lastName='" + getLastName() + "'")
                .toString();
    }

    public User(Long id, User creator, Boolean active, Boolean deleted, LocalDateTime createDateTime, String email, String password, String firstName, String lastName) {
        this.setId(id);
        this.setCreator(creator);
        this.isActive(active);
        this.isDeleted(deleted);
        this.setCreateDateTime(createDateTime);
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public User() {
    }



    /* */

}
