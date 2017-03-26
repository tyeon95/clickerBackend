package io.muic.webapp.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tyeon on 3/26/17.
 */
@Entity
public class Achievement {
    @Transient
    public static final String SINGULAR = "achievement";
    @Transient
    public static final String PLURAL = SINGULAR + "s";

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade= CascadeType.ALL, mappedBy="achievements")
    @OrderBy(value="created")
    private Set<User> users = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
