package com.epam.esm.dao;

import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.TagDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagDao {

    List<TagDto> getAllTags(int page, int size);

    TagDto getTagById(Long id);

    List<TagDto> getTagsByGiftCertificateId(Long id);

    int addTag(TagDto tagDto);

    boolean deleteTag(Long id);

    Integer getNumberOfRows() ;
}
