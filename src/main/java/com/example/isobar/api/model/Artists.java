package com.example.isobar.api.model;

import java.util.List;

public class Artists {
    private String name;
    private String image;
    private String genre;
    private String biography;
    private String numPlays;
    private String id;
    private List<Albums> albums;

    public Artists(String name, String image, String genre, String biography, String numPlays, String id, List<Albums> albums, List<Tracks> tracks) {
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.biography = biography;
        this.numPlays = numPlays;
        this.id = id;
        this.albums = albums;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getNumPlays() {
        return numPlays;
    }

    public void setNumPlays(String numPlays) {
        this.numPlays = numPlays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Albums> albums) {
        this.albums = albums;
    }


    @Override
    public String toString() {
        return "Artists{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", genre='" + genre + '\'' +
                ", biography='" + biography + '\'' +
                ", numPlays='" + numPlays + '\'' +
                ", id='" + id + '\'' +
                ", albums=" + albums +
                '}';
    }
}
