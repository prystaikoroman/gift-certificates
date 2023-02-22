package com.epam.esm.service;

import com.epam.esm.dto.TagDto;
import com.epam.esm.dto.TagPage;

public interface TagService {
    TagPage getAllTags(int page, int size);

    TagDto getTagById(int id);

    int addTag(TagDto tagDto);

    void deleteTag(int id);
}
