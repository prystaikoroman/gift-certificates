package com.epam.esm.service;

import com.epam.esm.dto.TagDto;
import com.epam.esm.dto.TagPage;

import java.util.List;

public interface TagService {
    TagPage getAllTags(int page, int size);

    TagDto getTagById(Long id);

    List<TagDto> getTagsByGiftCertificateId(Long id);

    int addTag(TagDto tagDto);

    void deleteTag(Long id);
}
