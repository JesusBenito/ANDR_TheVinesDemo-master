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

public class BodegaVistalba extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodega_vistalba);
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
        final String[] wordsVistalba = getResources().getStringArray(R.array.vistalba);
        int[] vistalbaVinos = new int[]{
                R.drawable.varidomoscato2015,
                R.drawable.varidosblanc2018,
                R.drawable.vtomerocs2012,
                R.drawable.vtomerocabernetfranc2016,
                R.drawable.vtomeroclassiccs2012,
                R.drawable.vtomeroclassicmalbec375ml2012,
                R.drawable.vtomeroclassicmalbec2018,
                R.drawable.vtomeroclassicmalbecrose2016,
                R.drawable.vtomerogranreservamalbec2011,
                R.drawable.vtomeroreservamalbec2011,
                R.drawable.vtomeroreservapetitverdot2015,
                R.drawable.vtomeroreservasyrah2011,
                R.drawable.vvistalbacortea2012,
                R.drawable.vvistalbacorteb2011,
                R.drawable.vvistalbacortec2015
        };

        int[] fondos = new int[]{
                R.drawable.fondoredblend};

        int[] banderas = new int[]{
                R.drawable.logoargentina
        };



        for(int i =0 ;i <1; i++){
            //Arido Moscato 2015
            Album a = new Album(wordsVistalba[0], fondos[0], vistalbaVinos[0], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Arido S Blanc 2018
            a = new Album(wordsVistalba[1], fondos[0], vistalbaVinos[1], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero C.S. 2012
            a = new Album(wordsVistalba[2], fondos[0], vistalbaVinos[2], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Cabernet Franc 2016
            a = new Album(wordsVistalba[3], fondos[0], vistalbaVinos[3], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Classic C.S 2012
            a = new Album(wordsVistalba[4], fondos[0], vistalbaVinos[4], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Classic Malbec 375ml 2012
            a = new Album(wordsVistalba[5], fondos[0], vistalbaVinos[5], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Classic Malbec 2018
            a = new Album(wordsVistalba[6], fondos[0], vistalbaVinos[6], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Classic Malbec Rose 2016
            a = new Album(wordsVistalba[7], fondos[0], vistalbaVinos[7], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Gran Reserva Malbec 2011
            a = new Album(wordsVistalba[8], fondos[0], vistalbaVinos[8], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Reserva Malbec 2011
            a = new Album(wordsVistalba[9], fondos[0], vistalbaVinos[9], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Reserva Petit Verdot 2015
            a = new Album(wordsVistalba[10], fondos[0], vistalbaVinos[10], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Tomero Reserva Syrah 2011
            a = new Album(wordsVistalba[11], fondos[0], vistalbaVinos[11], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Vistalba Corte A 2012
            a = new Album(wordsVistalba[12], fondos[0], vistalbaVinos[12], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Vistalba Corte B 2011
            a = new Album(wordsVistalba[13], fondos[0], vistalbaVinos[13], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Vistalba Corte C 2015
            a = new Album(wordsVistalba[14], fondos[0], vistalbaVinos[14], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
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
