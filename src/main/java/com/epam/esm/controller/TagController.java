package com.epam.esm.controller;

import com.epam.esm.dto.TagDto;
import com.epam.esm.dto.TagPage;
import com.epam.esm.exceptions.MyResourceNotFoundException;
import com.epam.esm.service.TagService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @JsonCreator
    @RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addTag(@RequestBody TagDto tagDto){
        return tagService.addTag(tagDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto getTagById(@PathVariable int id) {
        return tagService.getTagById(id);
    }

    @GetMapping(params = { "page", "size" })
    public TagPage findPaginated(@RequestParam("page") int page,
                                             @RequestParam("size") int size) throws MyResourceNotFoundException {
        TagPage resultPage = tagService.getAllTags(page, size);

//        Page<GiftCertificateDto> resultPage = (Page<GiftCertificateDto>) giftCertificateService.getAllGiftCertificates(page, size);
//        if (page > resultPage.getTotalPages()) {
//            throw new MyResourceNotFoundException();
//        }

        return resultPage;
    }

}
