package com.epam.esm.service;

import com.epam.esm.dao.TagDao;
import com.epam.esm.dto.TagDto;
import com.epam.esm.dto.TagPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
private final TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public TagPage getAllTags(int page, int size) {
        List<TagDto> allTags = tagDao.getAllTags(page, size);
        return new TagPage(allTags, size, page, isLastPage(size,page));
    }

    private boolean isLastPage(int size, int page) {
        return (tagDao.getNumberOfRows()/size)<=page;
    }

    @Override
    public TagDto getTagById(int id) {
        return null;
    }

    @Override
    public int addTag(TagDto tagDto) {
        return tagDao.addTag(tagDto);
    }

    @Override
    public void deleteTag(int id) {

    }

}
