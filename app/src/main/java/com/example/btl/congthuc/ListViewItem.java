package com.example.btl.congthuc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btl.R;

public class ListViewItem extends AppCompatActivity {
    TextView txtItemCongThuc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cursor cursor;
        setContentView(R.layout.item_list_congthuc);
        txtItemCongThuc = findViewById(R.id.txtIteamCongThuc);
    }
}
