package com.example.beyzas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UyeOlActivity extends AppCompatActivity {

    //farklı sınıflardan o sınıflara ait nesneleri üretelim
    private EditText editTextEposta2, editTextTelefon, editTextSifre2;
    private Spinner spinnerKayitTuru;
    private Button buttonDogumTarihi, buttonUyeOl;

    //25-26 hazır aldım
    private ArrayList<String> kayit_turleri = new ArrayList<>(); //kayit_turleri adlı liste oluşturduk
    private ArrayAdapter<String> kayit_turleri_adapter ;         //oluşturduğumuz liste için adapter oluşturduk


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol);

        //bağlama işlemlerini gerçekleştirelim: private olarak oluşturduğumuz nesneleri tasarımdaki tasarım nesnelerine bağlayalım
        editTextEposta2 = findViewById(R.id.editTextEposta2);
        editTextTelefon = findViewById(R.id.editTextTelefon);
        editTextSifre2 = findViewById(R.id.editTextSifre2);
        spinnerKayitTuru = findViewById(R.id.spinnerKayitTuru);
        buttonDogumTarihi = findViewById(R.id.buttonDogumTarihi);
        buttonUyeOl = findViewById(R.id.buttonUyeOl);

        //Üye ol ekranındaki alanların, veri tabanında karakter sınırları vardı
        //bu sınırlara göre filtreler koyalım ve kullanıcıları yönlendirelim
        //3 elemanlı bir filtre dizisi oluşturdum
        InputFilter[] FilterArray = new InputFilter[3];

        FilterArray[0] = new InputFilter.LengthFilter(10); //Telefon no
        FilterArray[1] = new InputFilter.LengthFilter(16); //Şifre
        FilterArray[2] = new InputFilter.LengthFilter(50); //e posta

        editTextTelefon.setFilters(new InputFilter[] {FilterArray[0]});
        editTextSifre2.setFilters(new InputFilter[] {FilterArray[1]});
        editTextEposta2.setFilters(new InputFilter[] {FilterArray[2]});


        //kayit_turleri adlı listeye eklemeler yaptık
        kayit_turleri.add("   Kayıt Türü Seçiniz");
        kayit_turleri.add("Esnaf ");
        kayit_turleri.add("Tedarikçi ");

        //adapter ın içini doldurduk:
        //kayit_turleri_adapter adında nesne oluşturduk
        kayit_turleri_adapter = new ArrayAdapter<String>(this, //context olarak nerede bulunduğumuzu belirttik. this(burada)
                android.R.layout.simple_dropdown_item_1line, // spinner ın tasarımını seçtik
                android.R.id.text1,  // spinner ın yazı türünü seçtik
                kayit_turleri);      // kayıt türleri adındaki listeyi adapterın içine attık

        //nesnemizin adapterını ayarlayalım
        spinnerKayitTuru.setAdapter(kayit_turleri_adapter);  //Adapter ı spinner a yerleştirdim


        buttonDogumTarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //39-61 hazır aldım
                final Calendar takvim = Calendar.getInstance();
                int yil = takvim.get(Calendar.YEAR);
                int ay = takvim.get(Calendar.MONTH);
                int gun = takvim.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(UyeOlActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // ay değeri 0 dan başladığı için (Ocak=0, Şubat=1,..,Aralık=11)
                        // değeri 1 artırarak gösteriyoruz.
                        month += 1;
                        // year, month ve dayOfMonth değerleri seçilen tarihin değerleridir.
                        // Edittextte bu değerleri gösteriyoruz.
                        buttonDogumTarihi.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, yil, ay, gun);
                // datepicker açıldığında set edilecek değerleri buraya yazıyoruz.
                // şimdiki zamanı göstermesi için yukarıda tanımladığımız değişkenleri kullanıyoruz.

                // dialog penceresinin button bilgilerini ayarlıyoruz ve ekranda gösteriyoruz.
                dpd.setTitle("Tarih Seçin");
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
            }
        });

        //BeyzasDaoInterface interface inden nesne üretelim
        BeyzasDaoInterface BDI = ApiUtils.getBeyzasDaoInterface();

        //buttonUyeOl butonuna basınca burası çalışacak
        buttonUyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //üye ol ekranında alanların boş bırakılmaması için aşağıdaki döngüyü yazdık
                if(editTextEposta2.getText().toString().equals("") ||
                   editTextSifre2.getText().toString().equals("") ||
                   editTextTelefon.getText().toString().equals("") ||
                   buttonDogumTarihi.getText().toString().equals("Doğum Tarihiniz") ||
                   spinnerKayitTuru.getSelectedItemPosition() == 0
                  ){
                    //üye ol ekranında alanlar boşsa burası çalışır
                    Toast.makeText(getApplicationContext(),"Boş alanları doldurun.", Toast.LENGTH_SHORT).show();

                }else{
                    //üye ol ekranında alanlar boş değilse burası çalışır



                        //telefon hanesi kısmı en az 10 haneli olmalı uyarı verir
                        if(editTextTelefon.getText().length() < 10){
                            Toast.makeText(getApplicationContext(),"Telefon No 10 Haneli Olmalıdır ", Toast.LENGTH_SHORT).show();

                        }else{






                                //dogum tarihini alabilmek için ayrı bir nesne türetmem gerekiyor
                                java.sql.Date dgm = new java.sql.Date(java.util.Date.parse(buttonDogumTarihi.getText().toString()));
                                //doğum tarihi verisini dgm değişkenine atadık

                                //kayıt türünü alabilmek için kayit_turu adında bir değişken üretelim
                                boolean kayit_turu;

                                if(spinnerKayitTuru.getSelectedItemPosition() == 1){ //1-esnaf, 2-tedarikçi
                                    //kayıt türü esnaf ise:
                                    kayit_turu = false;
                                }else{ //kayıt türü esnaf değilse(1 seçili değilse):
                                    kayit_turu = true;
                                }

                                BDI.UyeEkle(editTextEposta2.getText().toString(),
                                        editTextSifre2.getText().toString(),
                                        editTextTelefon.getText().toString(),
                                        dgm,
                                        kayit_turu
                                ).enqueue(new Callback<DIUCevap>() {
                                    /*.enqueue(object: Callback <JSONModel>{...});
                                    bu bir retrofit2 kütüphanesi çağrısıdır. android platformundan verileri sunucuya aktarmamızı sağlar
                                     */
                                    @Override
                                    public void onResponse(Call<DIUCevap> call, Response<DIUCevap> response) {

                                                    /* uye_ekle.php'de $response["success"]=1; demiştik
                                                    eğer sorgu başarıyla kayıt edildiyse 1 veriyordu
                                                    $response["success"]=1  Bu kodu,
                                                     response.body().getSuccess().toString().equals("1") bu kod ile sağladık
                                                     toString() ile string e çevirdik
                                                     */
                                        //yani $response["success"]=1 ise burası çalışacak
                                        if(response.body().getSuccess().toString().equals("1")){
                                            Toast.makeText(getApplicationContext(), "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                            //1 e eşitse Kayıt Başarılı mesajı verir

                                            //Kayıt Başarılı ise UyeOlActivity'den  LoginActivity.class'ye gideceğiz
                                            startActivity(new Intent(UyeOlActivity.this, LoginActivity.class));

                                        }else{
                                            Toast.makeText(getApplicationContext(), "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
                                            //1 e eşit değilse Kayıt Başarısız mesajı verir
                                        }


                                    }

                                    @Override
                                    public void onFailure(Call<DIUCevap> call, Throwable t) {
                                        //burada t adlı nesne ile hata fırlatıyor

                                    }
                                });
                        }


                }
            }
        });




    }
}