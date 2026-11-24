package com.example.mytunes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Playliste {

    private String playlisteNavn;
    private int antalSange;
    private int samlagtTid;
    private int rækkefølge = 1;

    private ObservableList<PlaylisteSange> sange = FXCollections.observableArrayList();

    public Playliste(String playlisteNavn, int antalSange, int samlagtTid) {
        this.playlisteNavn = playlisteNavn;
        this.antalSange = antalSange;
        this.samlagtTid = samlagtTid;
    }

    public int getAntalSange() {
        return sange.toArray().length;
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

    public ObservableList<PlaylisteSange> getSange() {
        return sange;
    }

    public void tilføjSang(Sang nysang) {
        sange.add(new PlaylisteSange(rækkefølge + ". " + nysang.getSangTitel() + " - " + nysang.getSangKunstner()));
        samlagtTid += nysang.getSangTid();
        rækkefølge++;
    }

    @Override
    public String toString() {
        return playlisteNavn;
    }
}