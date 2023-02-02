<?php

$response = array(); //bir cevap döneceğimiz için bir değişken oluşturduk

if( isset($_POST['e_posta']) && isset($_POST['sifre']) && isset($_POST['telefon']) && isset($_POST['dogum_tarihi']) && isset($_POST['kayit_turu']) ){
    
    
    $e_posta = $_POST['e_posta'];
    $sifre = $_POST['sifre'];
    $telefon = $_POST['telefon'];
    $dogum_tarihi = $_POST['dogum_tarihi'];
    $kayit_turu = $_POST['kayit_turu'];
    
    
    require_once __DIR__. '/db_config.php';
    
    //Bağlantı oluşturuluyor
    $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);
    //db_config dosyası içerisindeki veriler bağlantı adlı değişkene atandı
    
    
    //bağlantı kontrolü yapılıyor...
    
    if(!$baglanti){ //bağlantı hatalıysa burası çalışır
        die("Hatali baglanti : ".mysqli_connect_error());
    }
    
    
    $sqlsorgu = "INSERT INTO TBL_Uyeler (e_posta, sifre, telefon, dogum_tarihi, kayit_turu) values ('$e_posta', '$sifre', '$telefon', '$dogum_tarihi', $kayit_turu)";
    
        
    if(mysqli_query($baglanti, $sqlsorgu)){ //sorgu başarılıysa burası çalışır
        
        $response["success"]=1;
        $response["message"]="succesfully"; //sorgu başarılıysa true
        
        echo json_encode($response); //JSON veri tipinde oluşturduğumuz listeyi döndürür
    }else{  //sorgu başarısızsa burası çalışır
        $response["success"]=0;
        $response["message"]="no product found"; //sorgu başarılıysa false dönecek
        
        echo json_encode($responce);
    }    
        
    //baglanti koparilir
    mysqli_close($baglanti);
        
        
}else{ //bağlantı hatalı değilse burası çalışır
     $response["success"]=0;
     $response["message"]="Required field(s) is missing"; 
        
     echo json_encode($response);
}

?>