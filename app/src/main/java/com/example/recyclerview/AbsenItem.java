package com.example.recyclerview;

public class AbsenItem {
    private String nama;
    private String duration;
    private String genre;
    private int imageResId;
    private String artist;
    private String deskripsi;

    public AbsenItem(String nama, String duration, String genre, int imageResId, String artist, String deskripsi) {
        this.nama = nama;
        this.duration = duration;
        this.genre = genre;
        this.imageResId = imageResId;
        this.artist = artist;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
