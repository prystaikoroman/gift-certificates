package com.epam.esm.dto;

import java.util.List;

public class GiftCertificatePage {
    private List<GiftCertificateDto> giftCertificates;
    private long totalElements;
    private int currentPage;
    private boolean islast;

    public GiftCertificatePage() {
    }

    public GiftCertificatePage(List<GiftCertificateDto> giftCertificates, long totalElements, int currentPage, boolean islast) {
        this.giftCertificates = giftCertificates;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.islast = islast;
    }

    public List<GiftCertificateDto> getGiftCertificates() {
        return giftCertificates;
    }

    public void setGiftCertificates(List<GiftCertificateDto> giftCertificates) {
        this.giftCertificates = giftCertificates;
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
