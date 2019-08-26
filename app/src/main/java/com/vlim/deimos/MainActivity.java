package com.vlim.deimos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btn_buscar;
    private ImageView btn_ernesto;
    private SearchView simpleSearchView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        btn_ernesto=findViewById(R.id.btn_ernesto);
        simpleSearchView = findViewById(R.id.simpleSearchView);
        imageView = findViewById(R.id.img_logo);
        btn_ernesto.setClickable(true);
        btn_ernesto.setOnClickListener(this);
        simpleSearchView.setOnSearchClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ernesto:
                Intent intent=new Intent(MainActivity.this, CavasActivity.class);
                startActivity(intent);
                break;
            case R.id.simpleSearchView:
                if(simpleSearchView.isClickable()) {
                    imageView.setVisibility(View.GONE);
                }else{
                    imageView.setVisibility(View.VISIBLE);
                }
        }
    }
}
