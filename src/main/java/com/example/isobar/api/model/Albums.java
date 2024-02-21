package com.example.isobar.api.model;

import java.util.Date;
import java.util.List;

public class Albums {
    private String name;
    private String image;
    private Date releaseDate;
    private String band;
    private List<Tracks> tracks;
    private String id;

    public Albums(String name, String image, Date releaseDate, String band, List<Tracks> tracks, String id) {
        this.name = name;
        this.image = image;
        this.releaseDate = releaseDate;
        this.band = band;
        this.tracks = tracks;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", releaseDate=" + releaseDate +
                ", band='" + band + '\'' +
                ", tracks=" + tracks +
                ", id='" + id + '\'' +
                '}';
    }
}
