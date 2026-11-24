package com.example.mytunes;

public class Playliste {

    private String playlisteNavn;
    private int antalSange;
    private int samlagtTid;

    public Playliste(String playlisteNavn, int antalSange, int samlagtTid) {
        this.playlisteNavn = playlisteNavn;
        this.antalSange = antalSange;
        this.samlagtTid = samlagtTid;
    }

    public int getAntalSange() {
        return antalSange;
    }

    public void setAntalSange(int antalSange) {
        this.antalSange = antalSange;
    }

    public int getSamlagtTid() {
        return samlagtTid;
    }

    public void setSamlagtTid(int samlagtTid) {
        this.samlagtTid = samlagtTid;
    }

    public String getPlaylisteNavn() {
        return playlisteNavn;
    }

    public void setPlaylisteNavn(String playlisteNavn) {
        this.playlisteNavn = playlisteNavn;
    }
}