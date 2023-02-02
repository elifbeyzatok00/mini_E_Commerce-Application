package com.example.beyzas;

import java.sql.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface BeyzasDaoInterface {
    @POST("BEYZAS/uye_ekle.php")
    @FormUrlEncoded  //TÜRKÇE KARAKTER SORUN ÇIKARMAMASI İÇİN EKLEDİM
    Call<DIUCevap> UyeEkle(@Field("e_posta") String Eposta,
                           @Field("sifre") String Sifre,
                           @Field("telefon") String Telefon,
                           @Field("dogum_tarihi") Date DogumTarihi,
                           @Field("kayit_turu") boolean KayitTuru
    );


    @POST("BEYZAS/giris_yap.php")
    @FormUrlEncoded  //TÜRKÇE KARAKTER SORUN ÇIKARMAMASI İÇİN EKLEDİM
    Call<BilgilerCevap> GirisYap(@Field("e_posta") String Eposta,
                                 @Field("sifre") String Sifre
    );
}
