package com.epam.esm.model;

import java.util.List;
import java.util.Objects;

public class Tag {
    private Long id;
    private String name;
    List<Gift_Certificate> gift_certificateList;

    public Tag() {
    }

    public Tag(Long id, String name, List<Gift_Certificate> gift_certificateList) {
        this.id = id;
        this.name = name;
        this.gift_certificateList = gift_certificateList;
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

    public List<Gift_Certificate> getGift_certificateList() {
        return gift_certificateList;
    }

    public void setGift_certificateList(List<Gift_Certificate> gift_certificateList) {
        this.gift_certificateList = gift_certificateList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(name, tag.name) && Objects.equals(gift_certificateList, tag.gift_certificateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gift_certificateList);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gift_certificateList=" + gift_certificateList +
                '}';
    }
}
