
package com.example.beyzas;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Bilgiler {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("e_posta")
    @Expose
    private String ePosta;
    @SerializedName("sifre")
    @Expose
    private String sifre;
    @SerializedName("telefon")
    @Expose
    private String telefon;
    @SerializedName("dogum_tarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("kayit_turu")
    @Expose
    private String kayitTuru;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getKayitTuru() {
        return kayitTuru;
    }

    public void setKayitTuru(String kayitTuru) {
        this.kayitTuru = kayitTuru;
    }

}
