package com.epam.esm.dao;

import com.epam.esm.dto.GiftCertificateDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface GiftCertificateDao {

    List<GiftCertificateDto> getAllGiftCertificates(int page, int size);

    GiftCertificateDto getGiftCertificateById(Long id);

    int addGiftCertificate(GiftCertificateDto giftCertificateDto);

    boolean updateGiftCertificate(GiftCertificateDto GiftCertificateDto);

    boolean deleteGiftCertificate(Long id);

    Integer getNumberOfRows() ;
}
