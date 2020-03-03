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

public class ElEnemigo extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_enemigo);
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
        final String[] wordsEnemigo = getResources().getStringArray(R.array.enemigo);
        int[] enemigoVinos = new int[]{
                R.drawable.velenemigobonarda2016,
                R.drawable.velenemigocabernetfranc2015,
                R.drawable.velenemigochardonnay2016,
                R.drawable.elenemigoelmiradorbonarda2013,
                R.drawable.velenemigomalbec15l2016,
                R.drawable.velenemigomalbec2016,
                R.drawable.velenemigosyrahviognier2016,
                R.drawable.vgranenemigo2010agrelo,
                R.drawable.vgranenemigo2012elcepillo,
                R.drawable.vgranenemigo2013gualtallary,
                R.drawable.vgranenemigoblend2013,
                R.drawable.vgranenemigochacayes2012
        };


        int[] fondos = new int[]{
                R.drawable.fondoredblend
        };

        int[] banderas = new int[]{
                R.drawable.logoargentina
        };




        for(int i =0 ;i<1; i++){
            //0 El Enemigo Bonarda 2016
            Album a = new Album(wordsEnemigo[0], fondos[0], enemigoVinos[0], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //1 El Enemigo cabernet Franc 2015
            a = new Album(wordsEnemigo[1], fondos[0], enemigoVinos[1], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //2 El Enemigo cabernet Franc 2015
            a = new Album(wordsEnemigo[2], fondos[0], enemigoVinos[2], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //3 El Enemigo el Mirador Bonarda 2013
            a = new Album(wordsEnemigo[3], fondos[0], enemigoVinos[3], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //4 El Enemigo Malbec 1.5L 2016
            a = new Album(wordsEnemigo[4], fondos[0], enemigoVinos[4], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //5 El Enemigo Malbec 2016
            a = new Album(wordsEnemigo[5], fondos[0], enemigoVinos[5], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //6 El Enemigo Syrah Viognier 2016
            a = new Album(wordsEnemigo[6], fondos[0], enemigoVinos[6], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //7 Gran Enemigo 2010 Agrelo
            a = new Album(wordsEnemigo[7], fondos[0], enemigoVinos[7], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //8 Gran Enemigo 2012 el Cepillo
            a = new Album(wordsEnemigo[8], fondos[0], enemigoVinos[8], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //9 Gran Enemigo 2013 Gualtallary
            a = new Album(wordsEnemigo[9], fondos[0], enemigoVinos[9], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //10 Gran Enemigo Blend 2013
            a = new Album(wordsEnemigo[10], fondos[0], enemigoVinos[10], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //11 Gran Enemigo Chacayes 2012
            a = new Album(wordsEnemigo[11], fondos[0], enemigoVinos[11], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
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
