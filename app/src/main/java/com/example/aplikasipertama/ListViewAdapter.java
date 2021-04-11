package com.example.aplikasipertama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    // Deklarasikan variabel dengan jenis data context
    Context mContext;

    // Deklarasikan variabel dg jenis data layout inflater
    LayoutInflater inflater;

    // Deklarasikan variabel dengan jenis data arraylist
    private ArrayList<ClassNama>arrayList;

    // membuat konstruktor ListViewadapter
    public ListViewAdapter (Context context) {
        // memebri ilai mContext dengan context
        mContext = context;

        //Mengatur layoutinflater dengan context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arraylist dari class classNama
        this.arrayList = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arraylist
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    public class ViewHolder {
        TextView name;
    }
    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Deklarasikan variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //Membuat kondisi apakah view null atau tidak
        if (view == null) {
            //Membuat objek view holder
            holder = new ViewHolder();

            //Mengatur layout untuk menampilka item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //Menyimpan data dalam tampilan tangpa menggunakan struktur lain
            view.setTag(holder);
        } else {
            //Mengatir holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }

        //Set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //Mengembalikan nilai ke variabel View
        return view;
    }
}
