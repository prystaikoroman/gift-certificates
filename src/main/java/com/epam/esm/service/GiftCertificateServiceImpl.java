package com.epam.esm.service;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.GiftCertificatePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {
    @Autowired
//    GiftCertificateDao giftCertificateDao;
private final GiftCertificateDao giftCertificateDao;

//    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Override
    public GiftCertificatePage getAllGiftCertificates(int page, int size) {
        List<GiftCertificateDto> allGiftCertificates = giftCertificateDao.getAllGiftCertificates(page, size);


        allGiftCertificates.forEach(giftCertificateDto -> {
            giftCertificateDto.setCreate_date(dateParseAndFormat(giftCertificateDto));
//                    TimeZone tz = TimeZone.getTimeZone("UTC");
//                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
//                    df.setTimeZone(tz);
//                    String nowAsISO = df.format(giftCertificateDto.getCreate_date());
//                    giftCertificateDto.setCreate_date(nowAsISO);
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
        return giftCertificateDao.getGiftCertificateById(id);
    }

    @Override
    public int addGiftCertificate(GiftCertificateDto giftCertificateDto) {

        return giftCertificateDao.addGiftCertificate(giftCertificateDto);
    }

    @Override
    public GiftCertificateDto updateGiftCertificate(int id, GiftCertificateDto giftCertificateDto) {
        return null;
    }

    @Override
    public void deleteGiftCertificate(int id) {

    }

}
