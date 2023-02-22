package com.epam.esm.dto;


import com.epam.esm.model.Tag;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GiftCertificateDto {
    private Long id;
    private String name;
    private Short duration;
    private String create_date;
    private String last_update_date;
    private List<TagDto> tags;

    public GiftCertificateDto() {
    }

    public GiftCertificateDto(Long id, String name, Short duration, String create_date, String last_update_date, List<TagDto> tags) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.create_date = create_date;
        this.last_update_date = last_update_date;
        this.tags = tags;
    }


    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
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

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    @Override
    public String toString() {
        return "GiftCertificateDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", create_date='" + create_date + '\'' +
                ", last_update_date='" + last_update_date + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCertificateDto that = (GiftCertificateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(duration, that.duration) && Objects.equals(create_date, that.create_date) && Objects.equals(last_update_date, that.last_update_date) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, create_date, last_update_date, tags);
    }
}
