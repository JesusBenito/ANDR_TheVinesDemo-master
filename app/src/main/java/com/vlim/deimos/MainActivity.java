package com.vlim.deimos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btn_buscar;
    private ImageView btn_ernesto, btn_escorihuela, btn_elenemigo;
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
        btn_escorihuela=findViewById(R.id.btn_escorihuela);
        btn_elenemigo=findViewById(R.id.btn_elenemigo);
        simpleSearchView = findViewById(R.id.simpleSearchView);
        imageView = findViewById(R.id.img_logo);

        btn_ernesto.setClickable(true);
        btn_ernesto.setOnClickListener(this);

        btn_escorihuela.setClickable(true);
        btn_escorihuela.setOnClickListener(this);

        btn_elenemigo.setClickable(true);
        btn_elenemigo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ernesto:
                Intent intent=new Intent(MainActivity.this, ErnestoCatena.class);
                startActivity(intent);
                break;
            case R.id.btn_escorihuela:
                Intent intent2=new Intent(MainActivity.this, Escorihuela.class);
                startActivity(intent2);
                break;
            case R.id.btn_elenemigo:
                Intent intent3=new Intent(MainActivity.this, ElEnemigo.class);
                startActivity(intent3);
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
