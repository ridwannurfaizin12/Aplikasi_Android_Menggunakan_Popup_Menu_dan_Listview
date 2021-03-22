package com.example.aplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    EditText edemail, edpassword;

    String nama, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSigin);

        edemail = findViewById(R.id.edEmail);

        edpassword = findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String email = "admin@mail.com";
                String pass = "123";

                // Mengecek apakah edittext email dan password di sisi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    // Membuat variabel toast dan menampilkan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(), "Email dan Password wajib di isi!!!", Toast.LENGTH_LONG);

                    t.show();
                } else {
                    // Mengecek apakah email dan password sudah sama dengan email dan password yang sudah di set
                    if (nama.equals(email) && password.equals(pass)) {
                        // Membuat variabel toast dan menampilkan "Login Sukses"
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);

                        // Menampilkan Toast
                        t.show();

                        // Membuat Bundle
                        Bundle b = new Bundle();

                        // Memasukkan value dari variabel nama dengan kunci "a"
                        // dan dimasukkan kedalam bundle
                        b.putString("a", nama.trim());

                        // Memasukkan value dari variabel password dengan kunci "b"
                        // dan dimasukkan kedalam bundle
                        b.putString("b", password.trim());

                        // Membuat objek intent berpindah activity satu dari mainactivity ke activityhasil
                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);

                        // Memasukkan bundle kedalam Intent untuk dikirimkan ke activityhasil
                        i.putExtras(b);

                        // Berpindah ke activityhasil
                        startActivity(i);
                    } else {
                        // Membuat variabel Toast
                        // Membuat Toast
                        // menampilkan pesan "Login Gagal"
                        Toast t = Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_LONG);

                        //Menampilkan Toast
                        t.show();
                    }
                }
            }
        });
    }
}