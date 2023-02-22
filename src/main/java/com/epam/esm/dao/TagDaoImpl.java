package com.epam.esm.dao;

import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.TagDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TagDaoImpl implements TagDao {

    private final JdbcTemplate jdbcTemplate;
    private   DataSource dataSource;
    SimpleJdbcInsert simpleJdbcInsert;

    public TagDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tag");

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
    public List<TagDto> getAllTags(int page, int size) {
        return jdbcTemplate.query(
                "SELECT *  FROM tag LIMIT ?, ?", new BeanPropertyRowMapper<>(TagDto.class),  page, size);
    }

    @Override
    public TagDto getTagById(Long id) {
        return jdbcTemplate.queryForObject(
                "Select *  From tag where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<TagDto>());
    }

    @Override
    public int addTag(TagDto tagDto) {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", tagDto.getId());
        parameters.put("name", tagDto.getName());

        return simpleJdbcInsert.execute(parameters);
//        return 0;
    }

    @Override
    public boolean deleteTag(Long id) {
        String deleteQuery = "delete from tag where id = ?";
        return jdbcTemplate.update(deleteQuery, id) == 1;
    }

    @Override
    public Integer getNumberOfRows() {
        String sql = "SELECT COUNT(*) FROM tag";

            Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
            return integer;
    }
}
