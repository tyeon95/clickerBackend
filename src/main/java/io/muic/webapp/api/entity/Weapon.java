package io.muic.webapp.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by tyeon on 3/26/17.
 */
@Entity
public class Weapon extends Item {
    @Transient
    public static final String SINGULAR = "weapon";
    @Transient
    public static final String PLURAL = SINGULAR + "s";

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }
}
