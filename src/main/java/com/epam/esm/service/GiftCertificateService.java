package com.epam.esm.service;

import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.GiftCertificatePage;
import org.springframework.stereotype.Service;


public interface GiftCertificateService {
    GiftCertificatePage getAllGiftCertificates(int page, int size);

    GiftCertificateDto getGiftCertificateById(Long id);

    int addGiftCertificate(GiftCertificateDto giftCertificateDto);

    GiftCertificateDto updateGiftCertificate(int id, GiftCertificateDto giftCertificateDto);

    void deleteGiftCertificate(int id);
}
