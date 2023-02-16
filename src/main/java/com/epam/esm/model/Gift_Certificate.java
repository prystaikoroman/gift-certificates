
package com.epam.esm.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Gift_Certificate implements Serializable {
     private Long id;
private String name;
private Short duration;
private Date create_date;
private Date last_update_date;

    public Gift_Certificate() {
    }

    public Gift_Certificate(Long id, String name, Short duration, Date create_date, Date last_update_date) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.create_date = create_date;
        this.last_update_date = last_update_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    @Override
    public String toString() {
        return "Gift_Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", create_date=" + create_date +
                ", last_update_date=" + last_update_date +
                '}';
    }
}
