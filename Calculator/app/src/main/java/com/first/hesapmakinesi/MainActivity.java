package com.first.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtBirinciSayi, editTxtIkinciSayi;
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTxtBirinciSayi = (EditText) findViewById(R.id.editTxtBirinciSayi);
        editTxtIkinciSayi = (EditText) findViewById(R.id.editTxtIkinciSayi);
        txtSonuc = (TextView) findViewById(R.id.viewSonuc);
    }

    public void btnHesapla(View v){
        birinciSayi = editTxtBirinciSayi.getText().toString();
        ikinciSayi = editTxtIkinciSayi.getText().toString();

        if (!TextUtils.isEmpty(birinciSayi) && !TextUtils.isEmpty(ikinciSayi)) {
            s1 = Integer.valueOf(birinciSayi);
            s2 = Integer.valueOf(ikinciSayi);
            hesapla = new Hesapla(s1, s2);


            switch (v.getId()) {
                case R.id.btnTopla:
                    sonuc = hesapla.toplam();
                    break;

                case R.id.btnCikar:
                    sonuc = hesapla.fark();
                    break;

                case R.id.btnBol:
                    sonuc = hesapla.bolum();
                    break;

                case R.id.btnCarp:
                    sonuc = hesapla.carpim();
                    break;
            }

            txtSonuc.setText("Sonuc:" + sonuc);
        } else
            txtSonuc.setText("Sayı değerleri boş bırakılamaz.");
    }
}