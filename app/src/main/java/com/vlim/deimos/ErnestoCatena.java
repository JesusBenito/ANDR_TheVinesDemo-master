package com.vlim.deimos;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
                R.drawable.valmanegrablanc,
                R.drawable.valmanegratinto2013,
                R.drawable.vgranalmanegra,
                R.drawable.vgranalmanegra15l,
                R.drawable.valmanegramblend,
                R.drawable.valmanegraespumante15l,
                R.drawable.valmanecgrabrutnature,
                R.drawable.valmanegraorange,
                R.drawable.vstellacrinitabarberavinotinto,
                R.drawable.vstellacrinitacfrancvinotinto,
                R.drawable.vstellacrinitapetitverdotvinotinto,
                R.drawable.vpadrillospinotnoir2016,
                R.drawable.vpadrillosmalbec375ml,
                R.drawable.vpadrillosmalbec2017,
                R.drawable.vpadrillosblend,
                R.drawable.vpadrillostorrontes,
                R.drawable.vgransiesta2011,
                R.drawable.vsiestapinotnoir2011,
                R.drawable.vsiestacs2010,
                R.drawable.vsiestamalbec2013,
                R.drawable.vsiestamalbecbiodinamico2014,
                R.drawable.vsiestacsbiodinamico2014,
                R.drawable.vsiestacsbiodinamicoedmexico,
                R.drawable.vanimalmalbecorganico,
                R.drawable.vanimalcsorganico,
                R.drawable.vanimalchorganico,
                R.drawable.vtahuanmalbec2011,
                R.drawable.vtahuanchardonnay,
                R.drawable.vtahuanbonarda2011,
                R.drawable.vtikaljubilocsmalbec2006,
                R.drawable.vtikalamoriomalbec15lt,
                R.drawable.vtikalamoriomalbeccfranc2013,
                R.drawable.vtikalpatriotamalbecbonarda
        };
        int[] fondos = new int[]{
                R.drawable.fv1};

        int[] banderas = new int[]{
                R.drawable.logoargentina};


        for (int i = 0; i < 1; i++) {
            //Alma Negra Blanco 2015
            Album a = new Album(wordsernestoCatena[0], fondos[0], ernestoCatenaVinos[0], R.string.almanegrablanc, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Alma Negra Tinto 2013
            a = new Album(wordsernestoCatena[1], fondos[0], ernestoCatenaVinos[1], R.string.almanegratinto2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Gran Alma Negra 2011 1500ML
            a = new Album(wordsernestoCatena[2], fondos[0], ernestoCatenaVinos[2], R.string.granalmanegra15l, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Gran Alma Negra 2011 750ML
            a = new Album(wordsernestoCatena[3], fondos[0], ernestoCatenaVinos[3], R.string.granalmanegra, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Alma Negra Mblend 2013
            a = new Album(wordsernestoCatena[4], fondos[0], ernestoCatenaVinos[4], R.string.almanegramblend, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Alma Negra Blanc de Blancs
            a = new Album(wordsernestoCatena[5], fondos[0], ernestoCatenaVinos[5], R.string.almanegraespumante15l, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Alma Negra Brut Nature
            a = new Album(wordsernestoCatena[6], fondos[0], ernestoCatenaVinos[6], R.string.almanegrabrutnature, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Alma Negra Orange
            a = new Album(wordsernestoCatena[7], fondos[0], ernestoCatenaVinos[7], R.string.almanegraorange, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Stella Crinita Barbera Vino Tinto
            a = new Album(wordsernestoCatena[8], fondos[0], ernestoCatenaVinos[8], R.string.stellacrinitabarberavt, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Stella Crinita C.Franc Vino Tinto
            a = new Album(wordsernestoCatena[9], fondos[0], ernestoCatenaVinos[9], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Stella Crinita Petit Verdot Vino Tinto
            a = new Album(wordsernestoCatena[10], fondos[0], ernestoCatenaVinos[10], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Padrillos Pinot Noir 2016
            a = new Album(wordsernestoCatena[11], fondos[0], ernestoCatenaVinos[11], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Padrillos Malbec 2009
            a = new Album(wordsernestoCatena[12], fondos[0], ernestoCatenaVinos[12], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Padrillos Malbec 2017
            a = new Album(wordsernestoCatena[13], fondos[0], ernestoCatenaVinos[13], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Padrillos Blend 2005
            a = new Album(wordsernestoCatena[14], fondos[0], ernestoCatenaVinos[14], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Padrillos Torrontes
            a = new Album(wordsernestoCatena[15], fondos[0], ernestoCatenaVinos[15], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Gran Siesta Malbec 3000ML
            a = new Album(wordsernestoCatena[16], fondos[0], ernestoCatenaVinos[16], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Siesta Pinot Noir 2011</item>
            a = new Album(wordsernestoCatena[17], fondos[0], ernestoCatenaVinos[17], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Siesta C.S 2010</item>
            a = new Album(wordsernestoCatena[18], fondos[0], ernestoCatenaVinos[18], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Siesta Malbec 2013</item>
            a = new Album(wordsernestoCatena[19], fondos[0], ernestoCatenaVinos[19], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Siesta Malbec Biodinamico 2014
            a = new Album(wordsernestoCatena[20], fondos[0], ernestoCatenaVinos[20], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //>Siesta Single Vineyard Malbec
            a = new Album(wordsernestoCatena[21], fondos[0], ernestoCatenaVinos[21], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Siesta C.S Biodinamico ED.Mexico
            a = new Album(wordsernestoCatena[22], fondos[0], ernestoCatenaVinos[22], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Animal Malbec Organico 2018
            a = new Album(wordsernestoCatena[23], fondos[0], ernestoCatenaVinos[23], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Animal C.S Organico 2018
            a = new Album(wordsernestoCatena[24], fondos[0], ernestoCatenaVinos[24], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Animal C.H Organico 2018
            a = new Album(wordsernestoCatena[25], fondos[0], ernestoCatenaVinos[25], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tahuan Malbec 2016
            a = new Album(wordsernestoCatena[26], fondos[0], ernestoCatenaVinos[26], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tahuan Chardonnay
            a = new Album(wordsernestoCatena[27], fondos[0], ernestoCatenaVinos[27], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tahuan Bonarda 2011
            a = new Album(wordsernestoCatena[28], fondos[0], ernestoCatenaVinos[28], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tikal Jubilo C.S Malbec 2006
            a = new Album(wordsernestoCatena[29], fondos[0], ernestoCatenaVinos[29], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tikal Amorio Malbec 1.5 lts
            a = new Album(wordsernestoCatena[30], fondos[0], ernestoCatenaVinos[30], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tikal Amorio Malbec, C.Franc 2013
            a = new Album(wordsernestoCatena[31], fondos[0], ernestoCatenaVinos[31], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Tikal Patriota Malbec Bonarda
            a = new Album(wordsernestoCatena[32], fondos[0], ernestoCatenaVinos[32], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
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
