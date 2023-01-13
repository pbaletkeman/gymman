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
@Table(name="exercise")
final public class Exercise {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="creatorid")
    private User creator;
    
    private LocalDateTime createDateTime;
    @Column(name="isActive")
    private Boolean active;
    @Column(name="isDeleted")
    private Boolean deleted;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return getCreator().equals(exercise.getCreator()) && getCreateDateTime().equals(exercise.getCreateDateTime()) && isActive().equals(exercise.isActive()) && isDeleted().equals(exercise.isDeleted()) && getName().equals(exercise.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreator(), getCreateDateTime(), isActive(), isDeleted(), getName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Exercise.class.getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("creator=" + getCreator())
                .add("createDateTime=" + getCreateDateTime())
                .add("active=" + isActive())
                .add("deleted=" + isDeleted())
                .add("name='" + getName() + "'")
                .toString();
    }

    public Exercise(Integer id, User creator, LocalDateTime createDateTime, Boolean active, Boolean deleted, String name) {
        this.setId(id);
        this.setCreator(creator);
        this.setCreateDateTime(createDateTime);
        this.isActive(active);
        this.isDeleted(deleted);
        this.setName(name);
    }

    public Exercise() {
    }
}
