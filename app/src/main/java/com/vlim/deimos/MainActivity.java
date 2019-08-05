package com.vlim.deimos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ImageView btn_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        QR();
        btn_account=(ImageView)findViewById(R.id.btn_account);



    }

    public void QR() {
        String token = getIntent().getStringExtra("token");
        int datos = getIntent().getIntExtra("valida",0);
        if (datos==1) {
            Toast.makeText(MainActivity.this, "QR no valido" + ": " + token, Toast.LENGTH_SHORT).show();
        }
    }

    public void ShowPopup(View v){
        PopupMenu popupMenu =new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Item 1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"Item 2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this,"Item 3",Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return false;
        }
    }
}
