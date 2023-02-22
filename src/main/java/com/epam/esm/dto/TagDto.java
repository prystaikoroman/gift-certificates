package com.epam.esm.dto;

import com.epam.esm.model.Gift_Certificate;

import java.util.List;
import java.util.Objects;

public class TagDto {
    private Long id;
    private String name;
    List<Gift_Certificate> gift_certificateList;

    public TagDto() {
    }

    public TagDto(Long id, String name, List<Gift_Certificate> gift_certificateList) {
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
        TagDto tagDto = (TagDto) o;
        return Objects.equals(id, tagDto.id) && Objects.equals(name, tagDto.name) && Objects.equals(gift_certificateList, tagDto.gift_certificateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gift_certificateList);
    }

    @Override
    public String toString() {
        return "TagDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gift_certificateList=" + gift_certificateList +
                '}';
    }
}
