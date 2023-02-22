package com.epam.esm.controller;

import com.epam.esm.dto.GiftCertificateDto;
import com.epam.esm.dto.GiftCertificatePage;
import com.epam.esm.exceptions.MyResourceNotFoundException;
import com.epam.esm.service.GiftCertificateService;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("/giftCertificate")
public class GiftCertificateController {

   @Autowired
   private final GiftCertificateService giftCertificateService;

    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

//    private final GiftCertificateService giftCertificateService;

//    @Autowired
//    public GiftCertificateController(GiftCertificateService giftCertificateService) {
//        this.giftCertificateService = giftCertificateService;
//    }

//    /giftCertificate/check
@GetMapping("/check")
public String helloWorld(Model model) {
    model.addAttribute("message", "Hello World!");
    return "helloWorld";
}
    @JsonCreator
@RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto){
        return giftCertificateService.addGiftCertificate(giftCertificateDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GiftCertificateDto getGiftCertificateById(@PathVariable Long id) {
        return giftCertificateService.getGiftCertificateById(id);
    }

    @GetMapping(params = { "page", "size" })
    public GiftCertificatePage findPaginated(@RequestParam("page") int page,
                                   @RequestParam("size") int size) throws MyResourceNotFoundException {
    GiftCertificatePage resultPage = giftCertificateService.getAllGiftCertificates(page, size);

//        Page<GiftCertificateDto> resultPage = (Page<GiftCertificateDto>) giftCertificateService.getAllGiftCertificates(page, size);
//        if (page > resultPage.getTotalPages()) {
//            throw new MyResourceNotFoundException();
//        }

        return resultPage;
    }
//
//    @GET
//    @Path("/search/{travelStart}/{travelEnd}/" )
//    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
//    public List<TravelDTO> search(@PathParam("travelStart") Date travelStart,
//                                  @PathParam("travelEnd") Date travelEnd )
//    {
//        return travelService.search(travelStart,travelEnd);
//    }

}
