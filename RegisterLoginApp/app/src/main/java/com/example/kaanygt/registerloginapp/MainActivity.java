package com.example.kaanygt.registerloginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Adi,Sifre,Mail;
    Button button;
    DatabaseHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adi = (EditText)(findViewById(R.id.edtAdi));
        Sifre = (EditText)findViewById(R.id.edtsifre);
        Mail = (EditText)findViewById(R.id.edtmail);
        button = (Button)findViewById(R.id.button);
        db = new DatabaseHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String GelenAd = Adi.getText().toString();
                String GelenSifre = Sifre.getText().toString();
                String GelenMail = Mail.getText().toString();
                if (GelenAd.equals("") || GelenMail.equals("") || GelenSifre.equals("")) {
                    Toast.makeText(getApplicationContext(), "Boş Değer Girmeyiniz..", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean chckmail =db.chckEmail(GelenMail);
                    if (chckmail==true) {
                        Boolean insert = db.insert(GelenMail,GelenSifre);
                        if (insert==true)
                        {
                            Toast.makeText(getApplicationContext(),"Kayıt Başarılı",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Bu eposta Kayıtlıdır..",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    };
}
