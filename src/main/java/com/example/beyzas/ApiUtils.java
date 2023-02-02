package com.example.beyzas;

public class ApiUtils {
    /*
    Bu bizim önemli yapılarımızı tutacak
    */

    public static  final String BASE_URL = "https://beyzas.store/"; //Base url'yi verdim

    public static BeyzasDaoInterface getBeyzasDaoInterface(){
        //BeyzasDaoInterface türünde getBeyzasDaoInterface diye bir metod oluşturdum
        /*
         Bu metodu çok kullanıcam çünkü bu metod sayesinde veri tabanından veri çekmek için
         oluşturacağım çatı yapıyı kullancağım
        */

        return RetrofitClient.getClient(BASE_URL).create(BeyzasDaoInterface.class);
    }
    /*
    Kurulumumuz hazır bundan sonra tek yapmamız gereken verileri çekmek
    */
}
