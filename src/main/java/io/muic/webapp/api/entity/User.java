package io.muic.webapp.api.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tyeon on 3/26/17.
 */
@Entity
public class User {
    @Transient
    public static final String SINGULAR = "user";
    @Transient
    public static final String PLURAL = SINGULAR + "s";

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String email;

    private String password;

    private Long highscore = 0L;

    @ManyToMany
    @JoinTable(name="join_user_achievement",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="achievement_id", referencedColumnName="id"))
    private Set<Achievement> achievements = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "games")
    private Set<Game> games = new HashSet<>();

    public long getId() {
        return id;
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

    public Long getHighscore() {
        return highscore;
    }

    public void setHighscore(Long highscore) {
        this.highscore = highscore;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
