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

public class QuintaPortal extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_portal);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btn_regresar = (ImageView) findViewById(R.id.btn_regresar);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
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
        final String[] wordsQuintaPortal = getResources().getStringArray(R.array.quintadoportal);

        int[] quintaPortalVinos = new int[]{
                R.drawable.vdouroportalmoscatelgalego2015,
                R.drawable.vmurosdevinhablanco2016,
                R.drawable.vmurosdevinharose2017,
                R.drawable.vtrevovinhoverdebranco2018,
                R.drawable.vdouromurosdevinhatinto,
                R.drawable.vportal6barrels,
                R.drawable.vportal10anos375mls,
                R.drawable.vportal10anos,
                R.drawable.vportal20anos375mls,
                R.drawable.vportal20anos750mls,
                R.drawable.vportal29grapes,
                R.drawable.vportal30anos750mls,
                R.drawable.vportal40anos750mls,
                R.drawable.vportalfineruby,
                R.drawable.vportalfinetawnyporto,
                R.drawable.vportallbv,
                R.drawable.vportalmoscatelgalego,
                R.drawable.vportalquintadosmurostintovintage2014,
                R.drawable.vportalvintage2000,
                R.drawable.vportalvintage2003375mls,
                R.drawable.vportalvintage2004,
                R.drawable.vportalvintage2007375mls,
                R.drawable.vportalvintage2011
        };
        int[] fondos = new int[]{
                R.drawable.fv9};

        int[] banderas = new int[]{
                R.drawable.logoargentina};



        for(int i =0 ;i<1; i++){

            //Douro Portal Moscatel Galego 2015
            Album a = new Album(wordsQuintaPortal[0], fondos[0], quintaPortalVinos[0], R.string.douroportalmoscatelgalego2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Muros de Vinha Blanco 2016
            a = new Album(wordsQuintaPortal[1], fondos[0], quintaPortalVinos[1], R.string.murosdevinhablanco2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Muros de Vinha Rose 2017
            a = new Album(wordsQuintaPortal[2], fondos[0], quintaPortalVinos[2], R.string.murosdevinharose2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Trevo Vinha Verde Branco 2018
            a = new Album(wordsQuintaPortal[3], fondos[0], quintaPortalVinos[3], R.string.trevovinhaverdebranco2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Douro Muros de Vinha Tinto
            a = new Album(wordsQuintaPortal[4], fondos[0], quintaPortalVinos[4], R.string.douromurosdevinhatinto, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 6 Barrels
            a = new Album(wordsQuintaPortal[5], fondos[0], quintaPortalVinos[5], R.string.portal6barrels, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 10 Años 375 mls
            a = new Album(wordsQuintaPortal[6], fondos[0], quintaPortalVinos[6], R.string.portal10años375mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 10 Años
            a = new Album(wordsQuintaPortal[7], fondos[0], quintaPortalVinos[7], R.string.portal10años, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 20 Años 375 mls
            a = new Album(wordsQuintaPortal[8], fondos[0], quintaPortalVinos[8], R.string.portal20años375mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 20 Años 750 mls
            a = new Album(wordsQuintaPortal[9], fondos[0], quintaPortalVinos[9], R.string.portal20años750mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 29 Grapes
            a = new Album(wordsQuintaPortal[10], fondos[0], quintaPortalVinos[10], R.string.portal29grapes, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 30 Años 750 mls
            a = new Album(wordsQuintaPortal[11], fondos[0], quintaPortalVinos[11], R.string.portal30años750mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal 40 Años 750 mls
            a = new Album(wordsQuintaPortal[12], fondos[0], quintaPortalVinos[12], R.string.portal40años750mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Fine Ruby
            a = new Album(wordsQuintaPortal[13], fondos[0], quintaPortalVinos[13], R.string.portalfineruby, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Fine Tawny Porto
            a = new Album(wordsQuintaPortal[14], fondos[0], quintaPortalVinos[14], R.string.portalfinetawnyporto, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal LBV
            a = new Album(wordsQuintaPortal[15], fondos[0], quintaPortalVinos[15], R.string.portallBV, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Moscatel Galego
            a = new Album(wordsQuintaPortal[16], fondos[0], quintaPortalVinos[16], R.string.portalmoscatelgalego, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Quinta Dos Muros Tinto Vintage 2014
            a = new Album(wordsQuintaPortal[17], fondos[0], quintaPortalVinos[17], R.string.portalquintasosmurostintovintage2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Vintage 2000
            a = new Album(wordsQuintaPortal[18], fondos[0], quintaPortalVinos[18], R.string.portalvintage2000, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Vintage 2003 375 mls
            a = new Album(wordsQuintaPortal[19], fondos[0], quintaPortalVinos[19], R.string.portalvintage2003375mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Vintage 2004
            a = new Album(wordsQuintaPortal[20], fondos[0], quintaPortalVinos[20], R.string.portalvintage2004, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Vintage 2007 375 mls
            a = new Album(wordsQuintaPortal[21], fondos[0], quintaPortalVinos[21], R.string.portalvintage2003375mls, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Portal Vintage 2011
            a = new Album(wordsQuintaPortal[22], fondos[0], quintaPortalVinos[22], R.string.portalvintage2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            adapter = new AlbumsAdapter(this, albumList);
            recyclerView.setAdapter(adapter);

            searchView = (SearchView) findViewById(R.id.simpleSearchView);
            searchView.setOnQueryTextListener(this);
            adapter.notifyDataSetChanged();
        }

    }


    public boolean onQueryTextSubmit(String s) {
        return false;
    }

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
