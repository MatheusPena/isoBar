package com.example.isobar.api.controller;

import com.example.isobar.api.model.Tracks;
import com.example.isobar.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackController {

    final private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @GetMapping("/track")
    public List<Tracks> getTracks(@RequestParam String id) throws Exception {
        return trackService.getTracks(id);
    }
}
