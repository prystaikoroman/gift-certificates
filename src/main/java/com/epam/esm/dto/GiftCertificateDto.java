package com.epam.esm.dto;


import java.util.Date;

public class GiftCertificateDto {
    private Long id;
    private String name;
    private Short duration;
    private String create_date;
    private String last_update_date;

    public GiftCertificateDto() {
    }

    public GiftCertificateDto(Long id, String name, Short duration, String create_date, String last_update_date) {
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


}
