package com.example.zhang.uoe_qr;

public class Location {

    private String Name;
    private int Thumbnail;

    public Location() {

    }

    public Location (String name, int thumbnail){
        Name = name;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
