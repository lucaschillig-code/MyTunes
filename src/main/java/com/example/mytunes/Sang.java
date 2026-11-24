package com.example.mytunes;

public class Sang {
    private String sangTitel;
    private String sangKunstner;
    private int sangTid;
    private String mp3fil;

    public Sang(String sangTitel, String sangKunstner, int sangTid, String mp3fil) {
        this.sangTitel = sangTitel;
        this.sangKunstner = sangKunstner;
        this.sangTid = sangTid;
        this.mp3fil = mp3fil;
    }



    public void setMp3fil(String mp3fil) {
        this.mp3fil = mp3fil;
    }

    public String getMp3fil() {
        return mp3fil;
    }

    public void setSangTitel(String sangTitel) {
        this.sangTitel = sangTitel;
    }

    public String getSangTitel() {
        return sangTitel;
    }

    public void setSangKunstner(String sangKunstner) {
        this.sangKunstner = sangKunstner;
    }

    public String getSangKunstner() {
        return sangKunstner;
    }

    public void setSangTid(int sangTid) {
        this.sangTid = sangTid;
    }

    public int getSangTid() {
        return sangTid;
    }

}
