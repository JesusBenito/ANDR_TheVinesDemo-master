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

public class Escorihuela extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escorihuela);
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
        final String[] wordsescorihuela = getResources().getStringArray(R.array.escorihuela);

        int[] escorihuelaVinos = new int[]{
                R.drawable.vmiguelescorihuelagascon2012,
                R.drawable.vdonmalbec2012,
                R.drawable.vthepresidentsblend18842015,
                R.drawable.vpequenasproduccionespinotnoir2017,
                R.drawable.vpequenasprodcfranc2015,
                R.drawable.vpequenasproduccionesmalbec2017,
                R.drawable.vpequenasproduccionescabernets2014,
                R.drawable.vfamiliagasconmalbec2016,
                R.drawable.vfamiliagasconsyrah2018,
                R.drawable.vfamiliagasconchardonnay,
                R.drawable.vfamiliagasconrose2018,
                R.drawable.vfamiliagascondulcenatural,
                R.drawable.vescorihuelagascon375mls2017,
                R.drawable.vescorihuelagasconmalbec2018,
                R.drawable.vescorihuelagasconmalbec2015,
                R.drawable.vescorihuelagasconviogner,
                R.drawable.vescorihuelagasconcabernetfranc2017,
                R.drawable.vescorihuelagasconpinotnoir2018,
                R.drawable.vescorihuelagasconsangiovese2017,
                R.drawable.vescorihuelagasconcabsauvignon2017,
                R.drawable.vescorihuelagascongranreservamalbec,
                R.drawable.vescorihuelagascongranreserva2016chardonnay,
                R.drawable.vcircusmalbec2017,
                R.drawable.vcircussaiuvignonblanc2019,
                R.drawable.vescorihuelagasconorganicvineyard2016,
                R.drawable.velconquistadorredblend,
                R.drawable.vcarcassonneclasico
        };
        int[] fondos = new int[]{
                R.drawable.fv2};

        int[] banderas = new int[]{
                R.drawable.logoargentina};



        for(int i =0 ;i<1; i++){

            //miguel escorihuela gascon 2012
            Album a = new Album(wordsescorihuela[0], fondos[0], escorihuelaVinos[0], R.string.miguelescorihuelagascon2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //don malbec 2012
            a = new Album(wordsescorihuela[1], fondos[0], escorihuelaVinos[1], R.string.donmalbec2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //the presidents blend 1884 2015
            a = new Album(wordsescorihuela[2], fondos[0], escorihuelaVinos[2], R.string.thepresidentsblend18842015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //pequenas producciones pinot noir 2017
            a = new Album(wordsescorihuela[3], fondos[0], escorihuelaVinos[3], R.string.pequenasproduccionespinotnoir2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //pequenas producciones franc 2015
            a = new Album(wordsescorihuela[4], fondos[0], escorihuelaVinos[4], R.string.pequenasproduccionesfranc2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //pequenas producciones malbec 2017
            a = new Album(wordsescorihuela[5], fondos[0], escorihuelaVinos[5], R.string.pequenasproduccionesmalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //pequeñas producciones cabernets 2014
            a = new Album(wordsescorihuela[6], fondos[0], escorihuelaVinos[6], R.string.pequenasproduccionescabernets2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //familia gascon malbec 2018
            a = new Album(wordsescorihuela[7], fondos[0], escorihuelaVinos[7], R.string.familiagasconmalbec2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //familia gascon syrah 2018
            a = new Album(wordsescorihuela[8], fondos[0], escorihuelaVinos[8], R.string.familiagasconsyrah2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //familia gascon chardonnay 2019
            a = new Album(wordsescorihuela[9], fondos[0], escorihuelaVinos[9], R.string.familiagasconchardonnay2019, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //familia gascon rose 2018
            a = new Album(wordsescorihuela[10], fondos[0], escorihuelaVinos[10], R.string.familiagasconrose2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //familia gascon dulce natural 2015
            a = new Album(wordsescorihuela[11], fondos[0], escorihuelaVinos[11], R.string.familiagascondulcenatural2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon malbec 375mls 2017
            a = new Album(wordsescorihuela[12], fondos[0], escorihuelaVinos[12], R.string.escorihuelagasconmalbec375mls2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon malbec 750L 2018
            a = new Album(wordsescorihuela[13], fondos[0], escorihuelaVinos[13], R.string.escorihuelagasconmalbec750L2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gasco nmalbec 15L 2015
            a = new Album(wordsescorihuela[14], fondos[0], escorihuelaVinos[14], R.string.escorihuelagasconmalbec15L2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon viogner
            a = new Album(wordsescorihuela[15], fondos[0], escorihuelaVinos[15], R.string.escorihuelagasconviogner, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon cabernet franc 2017
            a = new Album(wordsescorihuela[16], fondos[0], escorihuelaVinos[16], R.string.escorihuelagasconcabernetfranc2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon pinot noir 2018
            a = new Album(wordsescorihuela[17], fondos[0], escorihuelaVinos[17], R.string.escorihuelagasconpinotnoir2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon sangvionese 2017
            a = new Album(wordsescorihuela[18], fondos[0], escorihuelaVinos[18], R.string.escorihuelagasconsangvionese2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon sauvignon 2017
            a = new Album(wordsescorihuela[19], fondos[0], escorihuelaVinos[19], R.string.escorihuelagasconsauvignon2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon gran reserva malbec 2017
            a = new Album(wordsescorihuela[20], fondos[0], escorihuelaVinos[20], R.string.escorihuelagascongranreservamalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon gran reserva 2016 chardonnay
            a = new Album(wordsescorihuela[21], fondos[0], escorihuelaVinos[21], R.string.escorihuelagascongranreserva2016chardonnay, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //circus malbec 2017
            a = new Album(wordsescorihuela[22], fondos[0], escorihuelaVinos[22], R.string.circusmalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //circus saiuvignon blanc 2019
            a = new Album(wordsescorihuela[23], fondos[0], escorihuelaVinos[23], R.string.circussaiuvignonblanc2019, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //escorihuela gascon organic vineyard 2016
            a = new Album(wordsescorihuela[24], fondos[0], escorihuelaVinos[24], R.string.escorihuelagasconorganicvineyard2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //el conquistador red blend
            a = new Album(wordsescorihuela[25], fondos[0], escorihuelaVinos[25], R.string.elconquistadorredblend, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //carcassonne clasico
            a = new Album(wordsescorihuela[26], fondos[0], escorihuelaVinos[26], R.string.carcassonneclasico, "Argentina|Mendoza", banderas[0]);
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
