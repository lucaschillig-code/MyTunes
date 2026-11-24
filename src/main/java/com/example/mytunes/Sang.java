package com.example.mytunes;

public class Sang {
    private String sangTitel;
    private String sangKunstner;
    private int sangTid;

    public Sang(String sangTitel, String sangKunstner, int sangTid) {
        this.sangTitel = sangTitel;
        this.sangKunstner = sangKunstner;
        this.sangTid = sangTid;
        //this.billedeFilSang = billedeFilSang;
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

    /*public void setBilledeFilSang(String billedeFilSang) {
        this.billedeFilSang = billedeFilSang;
    }

    public String getBilledeFilSang() {
        return billedeFilSang;
    }

     */
}
