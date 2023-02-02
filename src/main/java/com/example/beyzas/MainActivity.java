package com.example.beyzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;  //Button sınıfından bir buton nesnesi ürettim

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main.xml buraya bağlanmış

        //bağlama işlemlerini gerçekleştirelim: private olarak oluşturduğumuz nesneyi tasarımdaki ilgili tasarım nesnesine bağlayalım
        btnLogin = findViewById(R.id.btnLogin); //butonumuzu bağladık

        //eğer butona tıklandıysa burası çalışacak ve giriş yap ekranına gidecek
        //activityler arası geçiş yöntemini burada kullandık
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                //MainActivity.this'ten LoginActivity.class'a gideceğim diyorum
                finish(); //MainActivity'de işim bitti kapatabilirsin demek için finish metodunu kullanıyorum


            }
        });


    }
}