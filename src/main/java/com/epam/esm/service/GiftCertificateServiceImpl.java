package com.epam.esm.service;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.GiftCertificatePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {
    @Autowired
//    GiftCertificateDao giftCertificateDao;
private final GiftCertificateDao giftCertificateDao;

    @Autowired
//    GiftCertificateDao giftCertificateDao;
    private final TagService tagService;


    //    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao, TagService tagService) {
        this.giftCertificateDao = giftCertificateDao;
        this.tagService = tagService;
    }

    @Override
    public GiftCertificatePage getAllGiftCertificates(int page, int size) {
        List<GiftCertificateDto> allGiftCertificates = giftCertificateDao.getAllGiftCertificates(page, size);

        allGiftCertificates.forEach(giftCertificateDto -> {
            giftCertificateDto.setCreate_date(dateParseAndFormat(giftCertificateDto));
                });
        return new GiftCertificatePage(allGiftCertificates, size, page, isLastPage(size,page));
    }

    private boolean isLastPage(int size, int page) {
        return (giftCertificateDao.getNumberOfRows()/size)<=page;
    }

    private String dateParseAndFormat(GiftCertificateDto dto) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        df.setTimeZone(tz);

        Date parse = null;
        try {
            parse = df.parse(dto.getCreate_date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        return df.format(parse);
    }

    @Override
    public GiftCertificateDto getGiftCertificateById(Long id) {
        GiftCertificateDto giftCertificateById = giftCertificateDao.getGiftCertificateById(id);
        giftCertificateById.setTags(tagService.getTagsByGiftCertificateId(id));
        return giftCertificateById;
    }


    @Override
    public int addGiftCertificate(GiftCertificateDto giftCertificateDto) {
        return giftCertificateDao.addGiftCertificate(giftCertificateDto);
    }

    @Override
    public boolean updateGiftCertificate(GiftCertificateDto giftCertificateDto) {
        return giftCertificateDao.updateGiftCertificate(giftCertificateDto);
    }

    @Override
    public boolean deleteGiftCertificate(Long id) {
        return giftCertificateDao.deleteGiftCertificate(id);
    }

}
