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
    private ImageView btn_ernesto, btn_escorihuela, btn_elenemigo,
            btn_vistalba, btn_patritti, btn_vicentin, btn_robino,btn_yacochuya,btn_portal, btn_manosnegras,btn_maal,btn_colome,btn_valduero,
            btn_durigutti,btn_canale,btn_kopke,btn_luca,btn_riglos,btn_pampamaya,btn_laguarda,btn_vivoomuerto,btn_mapema,btn_tintonegro;
    private SearchView simpleSearchView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        btn_ernesto = findViewById(R.id.btn_ernesto);
        btn_escorihuela = findViewById(R.id.btn_escorihuela);
        btn_elenemigo = findViewById(R.id.btn_elenemigo);
        btn_vistalba = findViewById(R.id.btn_vistalba);
        btn_patritti = findViewById(R.id.btn_patriti);
        btn_vicentin = findViewById(R.id.btn_vicentin);
        btn_robino = findViewById(R.id.btn_robino);
        btn_yacochuya= findViewById(R.id.btn_yacochuya);
        btn_portal=findViewById(R.id.btn_quintadoportal);
        btn_manosnegras = findViewById(R.id.btn_manosnegras);
        btn_maal = findViewById(R.id.btn_maal);
        btn_colome = findViewById(R.id.btn_colome);
        btn_valduero = findViewById(R.id.btn_valduero);
        btn_durigutti =findViewById(R.id.btn_durigutti);
        btn_canale = findViewById(R.id.btn_canale);
        btn_kopke =findViewById(R.id.btn_kopke);
        btn_luca = findViewById(R.id.btn_luca);
        btn_riglos = findViewById(R.id.btn_riglos);
        btn_pampamaya = findViewById(R.id.btn_pampamaya);
        btn_laguarda = findViewById(R.id.btn_laguarda);
        btn_vivoomuerto = findViewById(R.id.btn_viviomuerto);
        btn_tintonegro = findViewById(R.id.btn_tintonegro);
        btn_mapema = findViewById(R.id.btn_mapema);

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

        btn_vicentin.setClickable(true);
        btn_vicentin.setOnClickListener(this);

        btn_robino.setClickable(true);
        btn_robino.setOnClickListener(this);

        btn_yacochuya.setClickable(true);
        btn_yacochuya.setOnClickListener(this);

        btn_portal.setClickable(true);
        btn_portal.setOnClickListener(this);


        btn_manosnegras.setClickable(true);
        btn_manosnegras.setOnClickListener(this);

        btn_maal.setClickable(true);
        btn_maal.setOnClickListener(this);

        btn_valduero.setClickable(true);
        btn_valduero.setOnClickListener(this);

        btn_durigutti.setClickable(true);
        btn_durigutti.setOnClickListener(this);

        btn_canale.setClickable(true);
        btn_canale.setOnClickListener(this);

        btn_kopke.setClickable(true);
        btn_kopke.setOnClickListener(this);

        btn_luca.setClickable(true);
        btn_luca.setOnClickListener(this);

        btn_riglos.setClickable(true);
        btn_riglos.setOnClickListener(this);

        btn_pampamaya.setClickable(true);
        btn_pampamaya.setOnClickListener(this);

        btn_laguarda.setClickable(true);
        btn_laguarda.setOnClickListener(this);

        btn_colome.setClickable(true);
        btn_colome.setOnClickListener(this);

        btn_vivoomuerto.setClickable(true);
        btn_vivoomuerto.setOnClickListener(this);

        btn_tintonegro.setClickable(true);
        btn_tintonegro.setOnClickListener(this);

        btn_mapema.setClickable(true);
        btn_mapema.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ernesto:
                Intent intent = new Intent(MainActivity.this, ErnestoCatena.class);
                startActivity(intent);
                break;
            case R.id.btn_escorihuela:
                Intent intent2 = new Intent(MainActivity.this, Escorihuela.class);
                startActivity(intent2);
                break;
            case R.id.btn_elenemigo:
                Intent intent3 = new Intent(MainActivity.this, ElEnemigo.class);
                startActivity(intent3);
                break;
            case R.id.simpleSearchView:
                if (simpleSearchView.isClickable()) {
                    imageView.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_vistalba:
                Intent intent4 = new Intent(MainActivity.this, Vistalba.class);
                startActivity(intent4);
                break;

            case R.id.btn_patriti:
                Intent intent5 = new Intent(MainActivity.this, Patritti.class);
                startActivity(intent5);
                break;

            case R.id.btn_vicentin:
                Intent intent6 = new Intent(MainActivity.this, Vicentin.class);
                startActivity(intent6);
                break;

            case R.id.btn_robino:
                Intent intent7 = new Intent(MainActivity.this, Robino.class);
                startActivity(intent7);
                break;

            case R.id.btn_yacochuya:
                Intent intent18 = new Intent(MainActivity.this, Yacochuya.class);
                startActivity(intent18);
                break;

            case R.id.btn_quintadoportal:
                Intent intent19 = new Intent(MainActivity.this, QuintaPortal.class);
                startActivity(intent19);
                break;

            case R.id.btn_manosnegras:
                Intent intent8 = new Intent(MainActivity.this, ManosNegras.class);
                startActivity(intent8);
                break;

            case R.id.btn_maal:
                Intent intent9 = new Intent(MainActivity.this, Maal.class);
                startActivity(intent9);
                break;

            case R.id.btn_valduero:
                Intent intent10 = new Intent(MainActivity.this, Valduero.class);
                startActivity(intent10);
                break;

            case R.id.btn_durigutti:
                Intent intent11 = new Intent(MainActivity.this, Durigutti.class);
                startActivity(intent11);
                break;

            case R.id.btn_canale:
                Intent intent12 = new Intent(MainActivity.this, Canale.class);
                startActivity(intent12);
                break;

            case R.id.btn_kopke:
                Intent intent13 = new Intent(MainActivity.this, Kopke.class);
                startActivity(intent13);
                break;

            case R.id.btn_luca:
                Intent intent14 = new Intent(MainActivity.this, Luca.class);
                startActivity(intent14);
                break;
            case R.id.btn_riglos:
                Intent intent15 = new Intent(MainActivity.this, Riglos.class);
                startActivity(intent15);
                break;

            case R.id.btn_pampamaya:
                Intent intent16 = new Intent(MainActivity.this, PampaMaya.class);
                startActivity(intent16);
                break;
            case R.id.btn_laguarda:
                Intent intent17 = new Intent(MainActivity.this, LaGuarda.class);
                startActivity(intent17);
                break;

            case R.id.btn_colome:
                Intent intentc = new Intent(MainActivity.this, Colome.class);
                startActivity(intentc);
                break;

            case R.id.btn_viviomuerto:
                Intent intent20 = new Intent(MainActivity.this, VivooMuerto.class);
                startActivity(intent20);
                break;

            case R.id.btn_tintonegro:
                Intent intent22 = new Intent(MainActivity.this, TintoNegro.class);
                startActivity(intent22);
                break;

            case R.id.btn_mapema:
                Intent intent21 = new Intent(MainActivity.this, Mapema.class);
                startActivity(intent21);
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
                break;
        }
    }
}
