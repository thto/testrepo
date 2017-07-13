package com.t_systems_mms.basics;

import javax.persistence.*;
import java.io.Serializable;

//@NamedQuery(name="findAllLaender", query="select l from laender l")
@Entity
@Table(name = "laender")
public class LandSpracheBean implements Serializable{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "land", nullable = true)
    private String land;

    @Column(name = "sprache", nullable = true)
    private String sprache;

    @Column(name = "additional", nullable = true)
    private String additional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    @Override public String toString() {
        return "id=" + id +
                ", land='" + land + '\'' +
                ", sprache='" + sprache + '\'';
    }
}
