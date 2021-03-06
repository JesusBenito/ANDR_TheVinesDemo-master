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

public class ManosNegras extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manos_negras);
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
        final String[] wordsManosNegras = getResources().getStringArray(R.array.manosnegras);
        int[] manosNegrasVinos = new int[]{
                R.drawable.vtehotomalvineyardmalbec2011,
                R.drawable.vtehotomalvineyardelcorte2012,
                R.drawable.vzahamalbec2014,
                R.drawable.vzahaelcorte2016,
                R.drawable.vzahacabernetfranc2012,
                R.drawable.vmanosnegraspinotnoir2013,
                R.drawable.vmanosnegrasmalbec2015,
                R.drawable.vmanosnegraspinornoirredsoil,
                R.drawable.vmanosnegrasatrevidablend,
                R.drawable.vmanosnegrasquimayblend,
                R.drawable.vmanosnegrasmalbecstonesoil
        };

        int[] fondos = new int[]{
                R.drawable.fv10};

        int[] banderas = new int[]{
                R.drawable.logoargentina
        };



        for(int i =0 ;i <1; i++){
            //tehomalbec2014
            Album a = new Album(wordsManosNegras[0], fondos[0], manosNegrasVinos[0], R.string.tehomalbec2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tehoelcorte2014
            a = new Album(wordsManosNegras[1], fondos[0], manosNegrasVinos[1], R.string.tehoelcorte2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //zahamalbec2014
            a = new Album(wordsManosNegras[2], fondos[0], manosNegrasVinos[2], R.string.zahamalbec2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //zahaelcorte2016
            a = new Album(wordsManosNegras[3], fondos[0], manosNegrasVinos[3], R.string.zahaelcorte2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //zahacabernetfranc2016
            a = new Album(wordsManosNegras[4], fondos[0], manosNegrasVinos[4], R.string.zahacabernetfranc2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //manosnegraspinotnoir
            a = new Album(wordsManosNegras[5], fondos[0], manosNegrasVinos[5], R.string.manosnegraspinotnoir, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //manosnegrasmalbec
            a = new Album(wordsManosNegras[6], fondos[0], manosNegrasVinos[6], R.string.manosnegrasmalbec, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //manosnegrassoilselectpinotnoir2013
            a = new Album(wordsManosNegras[7], fondos[0], manosNegrasVinos[7], R.string.manosnegrassoilselectpinotnoir2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //manosnegrasatrevidaredblend2011
            a = new Album(wordsManosNegras[8], fondos[0], manosNegrasVinos[8], R.string.manosnegrasatrevidaredblend2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //manosnegrasquimayredblend2013
            a = new Album(wordsManosNegras[9], fondos[0], manosNegrasVinos[9], R.string.manosnegrasquimayredblend2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //manosnegrasstonesoilmalbec2013
            a = new Album(wordsManosNegras[10], fondos[0], manosNegrasVinos[10], R.string.manosnegrasstonesoilmalbec2013, "Argentina|Mendoza", banderas[0]);
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
