<?php

$response = array();

require_once __DIR__. '/db_config.php';

$baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

if(!$baglanti){
    die("Hatali baglanti : ".mysqli_connect_error());
}

$sqlsorgu = "SELECT * FROM TBL_Uyeler"; //sorgum
$result = mysqli_query($baglanti, $sqlsorgu); //sorgumu çalıştırıyorum

//result kontrolu
if(mysqli_num_rows($result) > 0){ // veri var mı?
    $response["bilgiler"] = array();
    
         while($row = mysqli_fetch_assoc($result)){
             $bilgiler = array();
             $bilgiler["id"] = $row["id"];
             $bilgiler["e_posta"] = $row["e_posta"];
             $bilgiler["sifre"] = $row["sifre"];
             $bilgiler["telefon"] = $row["telefon"];
             $bilgiler["dogum_tarihi"] = $row["dogum_tarihi"];
             $bilgiler["kayit_turu"] = $row["kayit_turu"];
             array_push($response["bilgiler"], $bilgiler);
         }
    
         $response["success"] = 1;
    
         //encoinh JSON response 
         
         echo json_encode($response); //echo diyerek ekrana yazdırdım
}else{
    //sonuc bulunamadı
    $response["success"] = 0;
    $response["message"] = "No data found";
    
    echo json_encode($response);
}

mysqli_close($baglanti);

?>