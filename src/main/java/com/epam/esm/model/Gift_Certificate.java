
package com.epam.esm.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Gift_Certificate implements Serializable {
     private Long id;
private String name;
private Short duration;
private Date create_date;
private Date last_update_date;
private List<Tag> tagList;

    public Gift_Certificate() {
    }

    public Gift_Certificate(Long id, String name, Short duration, Date create_date, Date last_update_date, List<Tag> tagList) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.create_date = create_date;
        this.last_update_date = last_update_date;
        this.tagList = tagList;
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

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift_Certificate that = (Gift_Certificate) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(duration, that.duration) && Objects.equals(create_date, that.create_date) && Objects.equals(last_update_date, that.last_update_date) && Objects.equals(tagList, that.tagList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, create_date, last_update_date, tagList);
    }
}
