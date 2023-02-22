package com.epam.esm.dto;

import java.util.List;

public class TagPage {
    private List<TagDto> tagDtos;
    private long totalElements;
    private int currentPage;
    private boolean islast;

    public TagPage() {
    }

    public TagPage(List<TagDto> tagDtos, long totalElements, int currentPage, boolean islast) {
        this.tagDtos = tagDtos;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.islast = islast;
    }

    public List<TagDto> getTags() {
        return tagDtos;
    }

    public void setTags(List<TagDto> tags) {
        this.tagDtos = tags;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isIslast() {
        return islast;
    }

    public void setIslast(boolean islast) {
        this.islast = islast;
    }
}
