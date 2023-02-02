<?php

$response = array(); //bir cevap döneceğimiz için bir değişken oluşturduk

if( isset($_POST['e_posta']) && isset($_POST['sifre']) ){ 
    //e_posta ve sifre bilgisi gelirse bu burası çalışır
    $e_posta = $_POST['e_posta'];
    $sifre = $_POST['sifre'];
    
    require_once __DIR__.'/db_config.php'; //db_config.php dosyasına bağlandık
    
        $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

        if(!baglanti){ //bağlantı yoksa burası çalışır
            die("Hatali baglanti : ".mysqli_connect_error());
        }
    
         //bağlantı varsa burası çalışır
        $sqlsorgu = "SELECT id FROM TBL_Uyeler WHERE TBL_Uyeler.e_posta='$e_posta' and TBL_Uyeler.sifre='$sifre'";
        //e_posta ve sifre ye göre üyenin id sini verir

        $result = mysqli_query($baglanti, $sqlsorgu);
        //sorgumuzun cevabını $result değişkenine attık
    
    
            //aranan bilgilerde bir kullanıcı varsa burası çalışır
            if(mysqli_num_rows($result) > 0 ){

                $response["bilgiler"] = array(); //bilgiler dizisi oluşturduk

                while($row = mysqli_fetch_assoc($result)){ //bilgiler dizisinin içine while döngüsü ile kullanıcının id bilgisini atıyoruz

                    $bilgiler = array();
                    $bilgiler["id"] = $row["id"];
                    $bilgiler["kayit_turu"] = $row["kayit_turu"];

                    array_push($response["bilgiler"], $bilgiler); //diziyi gönderiyoruz

                }

                $response["success"] = 1; //1 mesajını veriyoruz

                echo json_encode($response);
                
            //aranan bilgilerde bir kullanıcı yoksa burası çalışır
            }else{ 
                $response["success"] = 0;
            }
    
    
    mysqli_close($baglanti);
    
}else{
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    
    echo json_encode($response);
}


?>