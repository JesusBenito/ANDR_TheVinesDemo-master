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

public class Canale extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canale);
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
        final String[] wordsCanale = getResources().getStringArray(R.array.canale);
        int[] canaleVinos = new int[]{
                R.drawable.vblackrivercabernetsauvignon2016,
                R.drawable.vblackrivermalbec2016,
                R.drawable.vblackrivermerlot2018,
                R.drawable.vblackriversblanc2017,
                R.drawable.vhcoldvineyardpinotnoirrose2017,
                R.drawable.vhcintimoblend2017,
                R.drawable.vhcintimocs2013,
                R.drawable.vhcintimomalbec2014,
                R.drawable.vhcgranreevamerlot,
                R.drawable.vhcgranrvacabernetfranc,
                R.drawable.vhcgranrvamalbec,
                R.drawable.vhumbertocanalecentenium,
                R.drawable.vhumbertocanaleestatecf2015,
                R.drawable.vhumbertocanaleestatecs2011,
                R.drawable.vhumbertocanaleestatepn2018,
                R.drawable.vdiegomurillomalbecmagnun
        };

        int[] fondos = new int[]{
                R.drawable.fv11};

        int[] banderas = new int[]{
                R.drawable.logoargentina
        };



        for(int i =0 ;i <1; i++){
            //Black River Cabernet Sauvignon 2016
            Album a = new Album(wordsCanale[0], fondos[0], canaleVinos[0], R.string.blackrivercabernetsauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Black River Malbec 2016
            a = new Album(wordsCanale[1], fondos[0], canaleVinos[1], R.string.blackrivermalbec2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Black River Merlot 2018
            a = new Album(wordsCanale[2], fondos[0], canaleVinos[2], R.string.blackrivermerlot2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Black River S Blanc 2017
            a = new Album(wordsCanale[3], fondos[0], canaleVinos[3], R.string.blackriversblanc2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Old Vineyard Pinot Noir Rose 2017
            a = new Album(wordsCanale[4], fondos[0], canaleVinos[4], R.string.hcoldvineyardpinotnoirrose2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Intimo Blend 2017
            a = new Album(wordsCanale[5], fondos[0], canaleVinos[5], R.string.hcintimoblend2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Intimo C.S 2013
            a = new Album(wordsCanale[6], fondos[0], canaleVinos[6], R.string.hcintimocs2013, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Intimo Malbec 2014
            a = new Album(wordsCanale[7], fondos[0], canaleVinos[7], R.string.hcintimomalbec2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Gran Reserva Merlot
            a = new Album(wordsCanale[8], fondos[0], canaleVinos[8], R.string.hcgranreevamerlot, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Gran Rva Cabernet Franc
            a = new Album(wordsCanale[9], fondos[0], canaleVinos[9], R.string.hcgranrvacabernetfran, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //H.C. Gran Rva Malbec
            a = new Album(wordsCanale[10], fondos[0], canaleVinos[10], R.string.hcgranrvamalbec, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Humberto Canale Centenium
            a = new Album(wordsCanale[11], fondos[0], canaleVinos[11], R.string.humbertocanalecentenium, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Humberto Canale Estate C.F. 2015
            a = new Album(wordsCanale[12], fondos[0], canaleVinos[12], R.string.humbertocanaleestatecf2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Humberto Canale Estate C.S 2011
            a = new Album(wordsCanale[13], fondos[0], canaleVinos[13], R.string.humbertocanaleestatecs2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Humberto Canale Estate P.N 2018
            a = new Album(wordsCanale[14], fondos[0], canaleVinos[14], R.string.humbertocanaleestatepn2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Diego Murillo Malbec Magnun
            a = new Album(wordsCanale[15], fondos[0], canaleVinos[15], R.string.diegomurillomalbecmagnun, "Argentina|Mendoza", banderas[0]);
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
