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

public class Vicentin extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vicentin);
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
        final String[] wordsVicentin = getResources().getStringArray(R.array.vicentin);
        int[] vicentinVinos = new int[]{
                R.drawable.vvicentinblenddemalbec2015,
                R.drawable.vvicentinbackbone,
                R.drawable.vvicentingen,
                R.drawable.vvicentinrobusto,
                R.drawable.vvicentinvoraz,
                R.drawable.velrenegadocs2016,
                R.drawable.veltramposocfranc2016,
                R.drawable.velcontrabandistapetitverdot2016,
                R.drawable.vretochardonnay2018,
                R.drawable.vretocabernetfranc2017,
                R.drawable.vretoblend2016,
                R.drawable.vretocabernetsauvignon2014,
                R.drawable.vretomalbec2016,
                R.drawable.vmaldito,
                R.drawable.vvicentinblancdemalbec2017,
                R.drawable.varrogante2014,
                R.drawable.vcolossomalbec2015,
                R.drawable.vlegitimochampangefrances
        };
        int[] fondos = new int[]{
                R.drawable.fv6};

        int[] banderas = new int[]{
                R.drawable.logoargentina};



        for(int i =0 ;i <1; i++){
            //vicentin blend de malbec 2015
            Album a = new Album(wordsVicentin[0], fondos[0], vicentinVinos[0], R.string.vicentinblenddemalbec2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //vicentin back bone 2012
            a = new Album(wordsVicentin[1], fondos[0], vicentinVinos[1], R.string.vicentinbackbone2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //vicentin gen 2012
            a = new Album(wordsVicentin[2], fondos[0], vicentinVinos[2], R.string.vicentingen2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //vicentin robusto 2012
            a = new Album(wordsVicentin[3], fondos[0], vicentinVinos[3], R.string.vicentinrobusto2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //vicentin voraz 2012
            a = new Album(wordsVicentin[4], fondos[0], vicentinVinos[4], R.string.vicentinvoraz2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //el renegado cs 2016
            a = new Album(wordsVicentin[5], fondos[0], vicentinVinos[5], R.string.elrenegadocs2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //el tramposo c franc 2016
            a = new Album(wordsVicentin[6], fondos[0], vicentinVinos[6], R.string.eltramposocfranc2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //el contrabandista petit verdot 2016
            a = new Album(wordsVicentin[7], fondos[0], vicentinVinos[7], R.string.elcontrabandistapetitverdot2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //reto chardonnay 2018
            a = new Album(wordsVicentin[8], fondos[0], vicentinVinos[8], R.string.retochardonnay2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //reto cabernet franc 2017
            a = new Album(wordsVicentin[9], fondos[0], vicentinVinos[9], R.string.retocabernetfranc2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //reto blend 2016
            a = new Album(wordsVicentin[10], fondos[0], vicentinVinos[10], R.string.retoblend2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //reto cabernet sauvignon 2014
            a = new Album(wordsVicentin[11], fondos[0], vicentinVinos[11], R.string.retocabernetsauvignon2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //reto malbec 2016
            a = new Album(wordsVicentin[12], fondos[0], vicentinVinos[12], R.string.retomalbec2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Maldito
            a = new Album(wordsVicentin[13], fondos[0], vicentinVinos[13], R.string.Maldito, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //vicentin blanc de malbec 2017
            a = new Album(wordsVicentin[14], fondos[0], vicentinVinos[14], R.string.vicentinblancdemalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //arrogante 2014
            a = new Album(wordsVicentin[15], fondos[0], vicentinVinos[15], R.string.arrogante2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //colosso malbec 2015
            a = new Album(wordsVicentin[16], fondos[0], vicentinVinos[16], R.string.colossomalbec2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //legitimochampangefrances
            a = new Album(wordsVicentin[16], fondos[0], vicentinVinos[16], R.string.legitimochampangefrances, "Argentina|Mendoza", banderas[0]);
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
