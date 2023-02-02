package com.example.beyzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AnaSayfaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);


        View buttonMenuKisayol = findViewById(R.id.buttonMenuKisayol);

        buttonMenuKisayol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaSayfaActivity.this,MenuActivity.class));
                finish();


            }
        });

        View buttonSepetimKisayol = findViewById(R.id.buttonSepetimKisayol);

        buttonSepetimKisayol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaSayfaActivity.this,SepetimActivity.class));
                finish();


            }
        });


        View buttonSepeteEkle = findViewById(R.id.buttonSepeteEkle);

        //bu butona basıldığında  ürünler sepetim kısmına eklenecek ... henüz tam anlamıyla kodlanmadı
        buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AnaSayfaActivity.this, "Ürün Sepetinize Eklendi", Toast.LENGTH_SHORT).show();
/*
                startActivity(new Intent(AnaSayfaActivity.this,SepetimActivity.class));
                finish();


 */

            }
        });



    }

}