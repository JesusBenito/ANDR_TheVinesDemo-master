package com.vlim.deimos;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btn_buscar;
    private ImageView btn_ernesto, btn_escorihuela, btn_elenemigo,btn_vistalba,btn_patritti;
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
        btn_vistalba = findViewById(R.id.btn_vistalba);
        btn_patritti = findViewById(R.id.btn_patriti);
        simpleSearchView = findViewById(R.id.simpleSearchView);
        imageView = findViewById(R.id.img_logo);

        btn_ernesto.setClickable(true);
        btn_ernesto.setOnClickListener(this);

        btn_escorihuela.setClickable(true);
        btn_escorihuela.setOnClickListener(this);

        btn_elenemigo.setClickable(true);
        btn_elenemigo.setOnClickListener(this);

        btn_vistalba.setClickable(true);
        btn_vistalba.setOnClickListener(this);

        btn_patritti.setClickable(true);
        btn_patritti.setOnClickListener(this);


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
                break;
            case R.id.btn_vistalba:
                Intent intent4 = new Intent(MainActivity.this,BodegaVistalba.class);
                startActivity(intent4);
                break;

            case R.id.btn_patriti:
                Intent intent5 = new Intent(MainActivity.this,Patritti.class);
                startActivity(intent5);
                break;

            default:
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT);
                break;
        }
    }
}
