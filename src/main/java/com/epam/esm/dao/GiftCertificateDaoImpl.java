package com.epam.esm.dao;

import com.epam.esm.dto.GiftCertificateDto;
import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GiftCertificateDaoImpl implements GiftCertificateDao {

    private final JdbcTemplate jdbcTemplate;
    private   DataSource dataSource;
    SimpleJdbcInsert simpleJdbcInsert;

    public GiftCertificateDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("gift_certificate");

    }

//    DataSource mysqlDataSource;
//    JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate, DataSource mysqlDataSource) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.mysqlDataSource = mysqlDataSource;
//    }



    @Override
    public List<GiftCertificateDto> getAllGiftCertificates(int page, int size) {
        return jdbcTemplate.query(
                "SELECT *  FROM gift_certificate LIMIT ?, ?", new BeanPropertyRowMapper<>(GiftCertificateDto.class),  page, size);
    }

    @Override
    public GiftCertificateDto getGiftCertificateById(Long id) {
//        return (GiftCertificateDto) jdbcTemplate.queryForObject(
//                "Select *  From gift_certificate where id = ?",
//                new Object[]{id},
//                new BeanPropertyRowMapper<GiftCertificateDto>());
        return null;
    }

    @Override
    public int addGiftCertificate(GiftCertificateDto giftCertificateDto) {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", giftCertificateDto.getId());
        parameters.put("name", giftCertificateDto.getName());
        parameters.put("duration", giftCertificateDto.getDuration());
        parameters.put("create_date", giftCertificateDto.getCreate_date());
        parameters.put("last_update_date", giftCertificateDto.getLast_update_date());

        return simpleJdbcInsert.execute(parameters);
//        return 0;
    }

    @Override
    public void updateGiftCertificate(Long id, GiftCertificateDto giftCertificateDto) {
        String updateQuery = "update gift_certificate set name = ?, duration = ?, create_date = ?, last_update_date = ? where id = ?";
        jdbcTemplate.update(updateQuery,
                giftCertificateDto.getName(),
                giftCertificateDto.getDuration(),
                giftCertificateDto.getCreate_date(),
                giftCertificateDto.getLast_update_date(),
                id);
    }

    @Override
    public boolean deleteGiftCertificate(Long id) {
        String deleteQuery = "delete from gift_certificate where id = ?";
        return jdbcTemplate.update(deleteQuery, id) == 1;
    }

    @Override
    public Integer getNumberOfRows() {
        String sql = "SELECT COUNT(*) FROM gift_certificate";

            Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
            return integer;
    }
}
