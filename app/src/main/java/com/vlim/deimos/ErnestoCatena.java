package com.vlim.deimos;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ErnestoCatena extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ernesto_catena);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btn_regresar = (ImageView) findViewById(R.id.btn_regresar);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }





    private void prepareAlbums() {
        final String[] wordsernestoCatena = getResources().getStringArray(R.array.ernestoCatena);
        int[] ernestoCatenaVinos = new int[]{
                R.drawable.valmanecgrabrutnature,
                R.drawable.valmanegrablanc,
                R.drawable.valmanegraespumante15l,
                R.drawable.valmanegramblend,
                R.drawable.valmanegramblend500ml,
                R.drawable.valmanegramisterio500ml,
                R.drawable.valmanegramisterio,
                R.drawable.valmanegravblend,
                R.drawable.vanimalcsorganico,
                R.drawable.vanimalchorganico,
                R.drawable.vanimalmalbecorganico,
                R.drawable.vgranalmanegra15l,
                R.drawable.vgranalmanegra,
                R.drawable.vpadrillosblend,
                R.drawable.vpadrillosmalbec375ml,
                R.drawable.vpadrillosmalbec2017,
                R.drawable.vpadrillospinotnoir2016,
                R.drawable.vpadrillostorrontes,
                R.drawable.vsiesta2014malbec,
                R.drawable.vsiestacsbiodinamico2014,
                R.drawable.vsiestacsbiodinamicoedmexico,
                R.drawable.vsiestacs2010,
                R.drawable.vsiestamalbec2013,
                R.drawable.vsiestamalbecbiodinamico2014,
                R.drawable.vsiestapinotnoir2011,
                R.drawable.vtahuanbonarda2011,
                R.drawable.vtahuanchardonnay,
                R.drawable.vtahuanmalbec2011,
                R.drawable.vtikalamoriomalbec15lt,
                R.drawable.vtikalamoriomalbeccfranc2013,
                R.drawable.vtikaljubilocsmalbec2006,
                R.drawable.vtikalpatriotamalbecbonarda};

        int[] fondos = new int[]{
                R.drawable.fondoalmanegra,
                R.drawable.fondoanimal,
                R.drawable.fondopadrillos,
                R.drawable.fondosiesta,
                R.drawable.fondotahuan,
                R.drawable.fondotikal};

        int[] banderas = new int[]{
                R.drawable.logoargentina
        };



        for(int i =0 ;i <1; i++){
            //Alma Negra Brut Nature
            Album a = new Album(wordsernestoCatena[0], fondos[0], ernestoCatenaVinos[0], R.string.almanegra_blanc, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Alma Negra Blanc
            a = new Album(wordsernestoCatena[1], fondos[0], ernestoCatenaVinos[1], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Alma Negra Espumante 1.5L
            a = new Album(wordsernestoCatena[2], fondos[0], ernestoCatenaVinos[2], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Alma Negra M Blend
            a = new Album(wordsernestoCatena[3], fondos[0], ernestoCatenaVinos[3], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Alma Negra Mblend 500ml
            a = new Album(wordsernestoCatena[4], fondos[0], ernestoCatenaVinos[4], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Alma Negra Misterio 500ml
            a = new Album(wordsernestoCatena[5], fondos[0], ernestoCatenaVinos[5], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Alma Negra Misterio
            a = new Album(wordsernestoCatena[6], fondos[0], ernestoCatenaVinos[6], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Alma Negra Vblend
            a = new Album(wordsernestoCatena[7], fondos[0], ernestoCatenaVinos[7], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Animal C.S Organico
            a = new Album(wordsernestoCatena[8], fondos[1], ernestoCatenaVinos[8], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Animal C.H Organico
            a = new Album(wordsernestoCatena[9], fondos[1], ernestoCatenaVinos[9], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Animal Malbec Organico
            a = new Album(wordsernestoCatena[10], fondos[1], ernestoCatenaVinos[10], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Alma Negra 1.5L
            a = new Album(wordsernestoCatena[11], fondos[0], ernestoCatenaVinos[11], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Alma Negra
            a = new Album(wordsernestoCatena[12], fondos[0], ernestoCatenaVinos[12], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Padrillos Blend
            a = new Album(wordsernestoCatena[13], fondos[2], ernestoCatenaVinos[13], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Padrillos Malbec 375ml
            a = new Album(wordsernestoCatena[14], fondos[2], ernestoCatenaVinos[14], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Padrillos Malbec 2017
            a = new Album(wordsernestoCatena[15], fondos[2], ernestoCatenaVinos[15], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Padrillos Pinot Noir 2016
            a = new Album(wordsernestoCatena[16], fondos[2], ernestoCatenaVinos[16], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Padrillos Torrontes
            a = new Album(wordsernestoCatena[17], fondos[2], ernestoCatenaVinos[17], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta 2014 Malbec
            a = new Album(wordsernestoCatena[18], fondos[3], ernestoCatenaVinos[18], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta C.S Biodinamico 2014
            a = new Album(wordsernestoCatena[19], fondos[3], ernestoCatenaVinos[19], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta C.S Biodinamico ED.Mexico
            a = new Album(wordsernestoCatena[20], fondos[3], ernestoCatenaVinos[20], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta C.S 2010
            a = new Album(wordsernestoCatena[21], fondos[3], ernestoCatenaVinos[21], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta Malbec 2013
            a = new Album(wordsernestoCatena[22], fondos[3], ernestoCatenaVinos[22], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta Malbec Biodinamico 2014
            a = new Album(wordsernestoCatena[23], fondos[3], ernestoCatenaVinos[23], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Siesta Pinot Noir 2011
            a = new Album(wordsernestoCatena[24], fondos[3], ernestoCatenaVinos[24], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tahuan Bonarda 2011
            a = new Album(wordsernestoCatena[25], fondos[4], ernestoCatenaVinos[25], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tahuan Chardonnay
            a = new Album(wordsernestoCatena[26], fondos[4], ernestoCatenaVinos[26], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tahuan Malbec 2011
            a = new Album(wordsernestoCatena[27], fondos[4], ernestoCatenaVinos[27], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tikal Amorio Malbec 1.5 lts
            a = new Album(wordsernestoCatena[28], fondos[5], ernestoCatenaVinos[28], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tikal Amorio Malbec, C.Franc 2013
            a = new Album(wordsernestoCatena[29], fondos[5], ernestoCatenaVinos[29], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tikal Jubilo C.S Malbec 2006
            a = new Album(wordsernestoCatena[30], fondos[5], ernestoCatenaVinos[30], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tikal Patriota Malbec Bonarda
            a = new Album(wordsernestoCatena[31], fondos[5], ernestoCatenaVinos[31], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);


            adapter = new AlbumsAdapter(this, albumList);
            recyclerView.setAdapter(adapter);

            searchView = (SearchView) findViewById(R.id.simpleSearchView);
            searchView.setOnQueryTextListener(this);

            adapter.notifyDataSetChanged();

        }



    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String text = s;
        adapter.filter(text);
        return false;
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
