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

public class Vistalba extends AppCompatActivity implements SearchView.OnQueryTextListener {

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
                R.drawable.vvistalbacortea2012,
                R.drawable.vvistalbacorteb2011,
                R.drawable.vvistalbacortec2015,
                R.drawable.vtomerogranreservamalbec2011,
                R.drawable.vtomeroclassicmalbecrose2016,
                R.drawable.vtomerochardonnay2016,
                R.drawable.vtomeroclassiccs2012,
                R.drawable.vtomerocabernetfranc2016,
                R.drawable.vtomeroclassicmalbec375ml2012,
                R.drawable.vtomeroclassicmalbec2018,
                R.drawable.vtomeroreservamalbec2011,
                R.drawable.vtomeroreservapetitverdot2015,
                R.drawable.vtomeroreservasyrah2011,
                R.drawable.varidomoscato2015,
                R.drawable.varidosblanc2018

        };

        int[] fondos = new int[]{
                R.drawable.fv4};

        int[] banderas = new int[]{
                R.drawable.fv4
        };



        for(int i =0 ;i <1; i++){


            //Vistalba Corte A 2012
            Album a = new Album(wordsVistalba[0], fondos[0], vistalbaVinos[0], R.string.vistalbacortea2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Vistalba Corte B 2011
            a = new Album(wordsVistalba[1], fondos[0], vistalbaVinos[1], R.string.vistalbacorteb2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Vistalba Corte C 2015
            a = new Album(wordsVistalba[2], fondos[0], vistalbaVinos[2], R.string.vistalbacortec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomerogranreservamalbec2011
             a = new Album(wordsVistalba[3], fondos[0], vistalbaVinos[3], R.string.tomerogranreservamalbec2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeromalbecrose2018
            a = new Album(wordsVistalba[4], fondos[0], vistalbaVinos[4], R.string.tomeromalbecrose2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomerochardonnay2016
            a = new Album(wordsVistalba[4], fondos[0], vistalbaVinos[5], R.string.tomerochardonnay2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroclassiccs2014
            a = new Album(wordsVistalba[6], fondos[0], vistalbaVinos[6], R.string.tomeroclassiccs2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroclassiccabernetfranc2016
            a = new Album(wordsVistalba[7], fondos[0], vistalbaVinos[47], R.string.tomeroclassiccabernetfranc2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroclassicmalbec375ml2017
            a = new Album(wordsVistalba[8], fondos[0], vistalbaVinos[8], R.string.tomeroclassicmalbec375ml2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroclassicmalbec2017
            a = new Album(wordsVistalba[9], fondos[0], vistalbaVinos[9], R.string.tomeroclassicmalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroreservamalbec2011
            a = new Album(wordsVistalba[10], fondos[0], vistalbaVinos[10], R.string.tomeroreservamalbec2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroreservapetitverdot2015
            a = new Album(wordsVistalba[11], fondos[0], vistalbaVinos[11], R.string.tomeroreservapetitverdot2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tomeroreservasyrah2011
            a = new Album(wordsVistalba[12], fondos[0], vistalbaVinos[12], R.string.tomeroreservasyrah2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //aridomoscato2015
            a = new Album(wordsVistalba[13], fondos[0], vistalbaVinos[13], R.string.aridomoscato2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //aridosauvignonblanc2019
            a = new Album(wordsVistalba[14], fondos[0], vistalbaVinos[14], R.string.aridosauvignonblanc2019, "Argentina|Mendoza", banderas[0]);
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
