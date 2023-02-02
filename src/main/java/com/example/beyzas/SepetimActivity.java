package com.example.beyzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SepetimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepetim);

        View buttonMenuKisayol = findViewById(R.id.buttonMenuKisayol2);

        buttonMenuKisayol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SepetimActivity.this,MenuActivity.class));
                finish();

            }
        });

        View btnSiparisiTamamla = findViewById(R.id.buttonSiparisiTamamla);

        //bu butona basıldığında  ürünler sepetim kısmına eklenecek ... henüz tam anlamıyla kodlanmadı
        btnSiparisiTamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SepetimActivity.this, "Siparişiniz Tamamlandı. Ödeme Ekranına Aktarılıyorsunuz", Toast.LENGTH_LONG).show();


            }
        });



    }
}