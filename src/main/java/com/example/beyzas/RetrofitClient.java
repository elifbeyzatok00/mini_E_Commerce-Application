package com.example.beyzas;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //retrofit nesnesini alacak sınıf


    private static Retrofit retrofit = null;
    //retrofit kütüphanesinden bir tane retrofit nesnesi oluşturdum


    public static Retrofit getClient(String baseUrl){
        //retrofit nesnesi döndüren bir tane metod oluşturuyorum
        //string olarak baseUrl'yi alacak, baseUrl'den kasıt şudur: https://beyzas.store/    (domain imiz)

        if(retrofit == null){ //eğer retrofit nesnesi boş ise oluştur
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }
}
