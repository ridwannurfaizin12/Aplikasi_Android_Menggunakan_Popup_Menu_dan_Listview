package com.example.aplikasipertama;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityKedua extends AppCompatActivity {

    TextView txEmail, txPassword;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        // Menghubungkan variabel txEmail dengan komponen text view pada layout
        txEmail = findViewById(R.id.tvEmail);

        // Menghubungkan variabel txpassword dengan komponen text view pada layout
        txPassword = findViewById(R.id.tvPassword);

        // Mendeklarasikan bundle yang akan digunakan untuk mengambil
        // pesan yang dikirimkan melalui method intent
        Bundle bundle = getIntent().getExtras();

        // Membuat veriabel string yang digunakan untuk menyimpan data
        // yang dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        // Membuat veriabel string yang digunakan untuk menyimpan data
        // yang dikirimkan dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");

        // Menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);

        // Menampilkan value dari variabel pass kedalam txPassword
        txPassword.setText(pass);
    }
}
