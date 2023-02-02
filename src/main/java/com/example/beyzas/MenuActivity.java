package com.example.beyzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beyzas.AnaSayfaActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        View buttonAnaSayfa = findViewById(R.id.buttonAnaSayfa);

        // Bu kodlar butona tılayıp diğer sayfayı açmayı sağlıyor.

        buttonAnaSayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, AnaSayfaActivity.class));
                finish();

            }
        });

        View buttonSepetim = findViewById(R.id.buttonSepetim);

        buttonSepetim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, com.example.beyzas.SepetimActivity.class));
                finish();

            }
        });
    }
}