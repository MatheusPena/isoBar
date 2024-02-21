package com.example.isobar.api.controller;

import com.example.isobar.api.model.Albums;
import com.example.isobar.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    final private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping("/album")
    public List<Albums> getAlbum(@RequestParam String id) throws Exception {
        return albumService.getAlbum(id);
    }
}
