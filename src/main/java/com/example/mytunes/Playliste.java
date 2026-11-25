package com.example.mytunes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Playliste {

    private String playlisteNavn;
    private int samlagtTid = 0;
    private int rækkefølge = 1;
    private int tid;

    public ObservableList<PlaylisteSange> sange = FXCollections.observableArrayList();
    private int antalSange = 0;


    public Playliste(String playlisteNavn, int antalSange, int tid) {
        this.playlisteNavn = playlisteNavn;
        this.antalSange = antalSange;
        this.samlagtTid = tid;
    }

    public int getAntalSange() {
        return sange.size();
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTid() {
        return tid;
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

    public int antalSangePlus() {
        antalSange++;
        return antalSange;
    }

    public int TidPlus() {
        samlagtTid += tid;
        return samlagtTid;
    }

    public void tilføjSang(Sang nysang) {
        sange.add(new PlaylisteSange(rækkefølge + ". " + nysang.getSangTitel() + " - " + nysang.getSangKunstner()));
        rækkefølge++;
    }

    @Override
    public String toString() {
        return playlisteNavn;
    }
}