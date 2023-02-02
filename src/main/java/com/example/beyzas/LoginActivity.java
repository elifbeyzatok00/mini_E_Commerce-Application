package com.example.beyzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnGirisYap;                     //Button sınıfından bir buton nesnesi ürettim
    private EditText editTextEposta, editTextSifre; //EditText sınıfından iki tane EditText nesnesi ürettim
    private ImageView imageViewKayitOl;             //ImageView sınıfından bir ImageView nesnesi ürettim

    private BeyzasDaoInterface BDI = ApiUtils.getBeyzasDaoInterface(); //interfaceten nesne oluşturduk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  //activity_login.xml buraya bağlanmış



        //bağlama işlemlerini gerçekleştirelim: private olarak oluşturduğumuz nesneleri tasarımdaki tasarım nesnelerine bağlayalım
        btnGirisYap = findViewById(R.id.btnGirisYap);           //butonumuzu bağladık
        editTextEposta = findViewById(R.id.editTextEposta);     //diğer ürettiğimiz nesneleri de bağladık
        editTextSifre = findViewById(R.id.editTextSifre);
        imageViewKayitOl = findViewById(R.id.imageViewKayitOl);

        //ilk olarak kayıt ol ile ilgilenelim
        //Kayıt ol a tıklandığında burası çalışacak
        imageViewKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, UyeOlActivity.class));
                //LoginActivity.this'den UyeOlActivity.class'a gideceğim diyorum


            }
        });


        View btnGirisYap = findViewById(R.id.btnGirisYap);

        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MenuActivity.class));
                finish();

                Toast.makeText(LoginActivity.this, "Hoş geldiniz", Toast.LENGTH_SHORT).show();

            }
        });




    }
}