package com.example.tugas6;

public class Model {
    private String JenisSepatu, DeskSepatu, HargaSepatu;
    private int GambarSepatu;

    private int id;

    public Model(int id, String jenisSepatu, String deskSepatu, String hargaSepatu, int gambarSepatu) {
        this.id = id;
        JenisSepatu = jenisSepatu;
        DeskSepatu = deskSepatu;
        GambarSepatu = gambarSepatu;
        HargaSepatu = hargaSepatu;
    }

    public String getJenisSepatu() {
        return JenisSepatu;
    }

    public void setJenisSepatu(String jenisSepatu) {
        this.JenisSepatu = jenisSepatu;
    }

    public void setDeskSepatu(String deskSepatu) {
        this.DeskSepatu = deskSepatu;
    }

    public void setHargaSepatu(String hargaSepatu) {
        this.HargaSepatu = hargaSepatu;
    }

    public void setGambarSepatu(int gambarSepatu) {
        this.GambarSepatu = gambarSepatu;
    }

    public String getHargaSepatu() {
        return HargaSepatu;
    }



    public String getDeskSepatu() {
        return DeskSepatu;
    }



    public int getGambarSepatu() {
        return GambarSepatu;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

