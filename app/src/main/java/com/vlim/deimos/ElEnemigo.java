package com.vlim.deimos;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import org.w3c.dom.Text;

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
        final String[] words = getResources().getStringArray(R.array.words);
        int[] enemigo = new int[]{
                R.drawable.granenemigo2012,
                R.drawable.elenemigocabernet2015,
                R.drawable.elenemigomalbec,
                R.drawable.elenemigobonarda,
                R.drawable.elenemigosyrah,
                R.drawable.elenemigochardonnay,
                R.drawable.granenemigochacaves,
                R.drawable.granenemigocepillo,
                R.drawable.granenemigoagrelo,
                R.drawable.granenemigogualtallary,
                R.drawable.vacio,
                R.drawable.vacio};


        int[] fondos = new int[]{
                R.drawable.elgranenemigofondo,
        };

        int[] banderas = new int[]{
                R.drawable.argentina
        };




        for(int i =0 ;i<1; i++){
            //El Enemigo Bonarda 2016
            Album a = new Album(words[49], fondos[0], enemigo[0], R.string.granEnemigo2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Enemigo Cabernet Franc 2015
            a = new Album(words[50], fondos[0], enemigo[1], R.string.elEnemigoCabernetFranc2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Enemigo Chardonnay 2016
            a = new Album(words[51], fondos[0], enemigo[2], R.string.elEnemigoMalbec750mly3000ml2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Enemigo el Mirador Bonarda 2013
            a = new Album(words[52], fondos[0], enemigo[3], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Enemigo Malbec 1.5L 2016
            a = new Album(words[53], fondos[0], enemigo[4], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Enemigo Malbec 2016
            a = new Album(words[54], fondos[0], enemigo[5], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Enemigo Syrah Viognier 2016
            a = new Album(words[55], fondos[0], enemigo[6], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Enemigo 2010 Agrelo
            a = new Album(words[56], fondos[0], enemigo[7], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Enemigo 2012 el Cepillo
            a = new Album(words[57], fondos[0], enemigo[8], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Enemigo 2013 Gualtallary
            a = new Album(words[58], fondos[0], enemigo[9], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Enemigo Blend 2013
            a = new Album(words[59], fondos[0], enemigo[10], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Enemigo Chacayes 2012
            a = new Album(words[60], fondos[0], enemigo[11], R.string.elEnemigoBonarda2015, "Argentina|Mendoza", banderas[0]);
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
