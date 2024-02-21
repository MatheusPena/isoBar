package com.example.isobar.api.controller;

import com.example.isobar.api.model.Artists;
import com.example.isobar.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

    final private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping("/artist")
    public List<Artists> getArtist(@RequestParam String id) throws Exception {
        return artistService.getArtists(id);
    }
}
