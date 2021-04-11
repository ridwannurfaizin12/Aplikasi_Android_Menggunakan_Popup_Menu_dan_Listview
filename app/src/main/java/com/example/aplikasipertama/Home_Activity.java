package com.example.aplikasipertama;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    // Deklarasikan variabel dengan jenis data listview
    private ListView list;

    //Memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    // Deklarasikan array untuk menyimpan nama
    String[] listnama;

    //Memnggil class nama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek bundle
    Bundle bundle = new Bundle();

    //Membuat objek intent
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        //Menyimpan nama didalam array Listnama
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina", "Gita", "Vian", "Lutfi"};

        list = findViewById(R.id.listKontak);

        //Membuat objek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada array listNama
        for (int i=0; i < listnama.length; i++) {
            //Membuat objek class nama
            ClassNama classNama = new ClassNama(listnama[i]);
            //bind strings ke array
            classNamaArrayList.add(classNama);

            //Membuat objek dari listviesadapter
            adapter = new ListViewAdapter(this);

            //Binds adapter ke ListView
            list.setAdapter(adapter);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variabel nama yg berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //Memasukan value dari variabel nama dengan kunci "a"
                // dan dimasukan kedlm bundle
                bundle.putString("a", nama.trim());

                //Membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //Membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //Menampilkan popup menu ketika dipilih
                pm.inflate(R.menu.popup_menu);

                //Menampilkan popup menu
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.mnview:
                    intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.mnedit:
                    Toast.makeText(getApplicationContext(), "ini untuk edit kontak", Toast.LENGTH_LONG).show();
                    break;
            }
            return false;
        }
    }