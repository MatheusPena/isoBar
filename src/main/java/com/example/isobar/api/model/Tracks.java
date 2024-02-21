package com.example.isobar.api.model;

public class Tracks {

    private String name;
    private int duration;
    private String id;

    public Tracks(String name, int duration, String id) {
        this.name = name;
        this.duration = duration;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", id='" + id + '\'' +
                '}';
    }
}
