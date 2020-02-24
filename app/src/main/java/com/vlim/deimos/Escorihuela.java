package com.vlim.deimos;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        final String[] words = getResources().getStringArray(R.array.words);

        int[] botellas = new int[]{
                R.drawable.thepresidentblend,
                R.drawable.miguelescorihuela,
                R.drawable.donescorihuela,
                R.drawable.pequenasproduccionescabernets2014,
                R.drawable.escorihuelagasconmalbec,
                R.drawable.pequenasprodcf2010,
                R.drawable.pequenasproduccionespinotnoir2017,
                R.drawable.escorihuelagascongranreservamalbec2016,
                R.drawable.escorihuelagascongranreserva2016chardonnay,
                R.drawable.familiagasconrose,
                R.drawable.gascondulcenatural,
                R.drawable.familiagasconmalbec2016,
                R.drawable.familiagasconsyrah2016,
                R.drawable.vacio,
                R.drawable.escorihuelagasconmalbec2015,
                R.drawable.escorihuelagasconsangiovese,
                R.drawable.escorihuelagcabernetfranc,
                R.drawable.escorihuelagasconpinotnoir,
                R.drawable.vacio,
                R.drawable.escorihuelagasconviogner,
                R.drawable.vacio,
                R.drawable.circusmalbec,
                R.drawable.circussaiuvignonblanc2017,
                R.drawable.gastonorganicvineyard,
                R.drawable.vacio,
                R.drawable.vacio,};
        int[] fondos = new int[]{
                R.drawable.escorihuelagasconfondo,
                R.drawable.familiagascon,
                R.drawable.gasconfondo};

        int[] banderas = new int[]{
                R.drawable.argentina};



        for(int i =0 ;i<1; i++){
            //The President Blend
            Album a = new Album(words[23], fondos[0], botellas[0], R.string.thepresidentblend, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Miguel Escorihuela
            a = new Album(words[24], fondos[0], botellas[1], R.string.miguelEscorihuela, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Don Miguel Escorihuela
            a = new Album(words[25], fondos[0], botellas[2], R.string.donMiguelEscorihuela, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Pequenas Producciones Cabernet Sauvignon 2014
            a = new Album(words[26], fondos[0], botellas[3], R.string.cabernetSauvignon2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //MAlbec2015
            a = new Album(words[27], fondos[0], botellas[4], R.string.MAlbec2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Cabernet Franc 2015
            a = new Album(words[28], fondos[0], botellas[5], R.string.cabernetFranc2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Pinot Noir 2017
            a = new Album(words[29], fondos[0], botellas[6], R.string.PINOTNOIR2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Reserva Malbec 2016
            a = new Album(words[30], fondos[0], botellas[7], R.string.granReservaMalbec2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gran Reserva Chardonnay 2017
            a = new Album(words[31], fondos[0], botellas[8], R.string.granReservaCHARDONNAY2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Familia Gascon Rose
            a = new Album(words[32], fondos[1], botellas[9], R.string.famGasconRose2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Familia Gascon Dulce
            a = new Album(words[33], fondos[1], botellas[10], R.string.famGasconDulce2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Familia Gascon Malbec 2016
            a = new Album(words[34], fondos[1], botellas[11], R.string.famGasconMalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Familia Gascon Syrah 2016
            a = new Album(words[35], fondos[1], botellas[12], R.string.famGasconSyrah2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Familia Gascon chardonnay
            a = new Album(words[36], fondos[1], botellas[13], R.string.famGasconChardonnay2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Escorihuela Gascon Malbec 375ml-750ml-1500ml
            a = new Album(words[37], fondos[2], botellas[14], R.string.eGasconMalbec375_750_1500, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Escorihuela Gascon Sangiovese 2017
            a = new Album(words[38], fondos[2], botellas[15], R.string.eGasconSangiovese2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Escorihuela Gascon Cabernet Franc 2017
            a = new Album(words[39], fondos[2], botellas[16], R.string.eGasconCFranc2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Escorihuela Gascon Pinot Noir 2018
            a = new Album(words[40], fondos[2], botellas[17], R.string.eGasconPinotNoir2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Escorihuela Gascon Cabernet Sauvignon 2016
            a = new Album(words[41], fondos[2], botellas[18], R.string.eGasconCSauvignon2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Escorihuela Gascon Viognier 2017
            a = new Album(words[42], fondos[2], botellas[19], R.string.eGasconViognier2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Circus Cabernet Sauvignon 2017
            a = new Album(words[43], fondos[0], botellas[20], R.string.CircusCSauvignon2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Circus Malbec 2017
            a = new Album(words[44], fondos[0], botellas[21], R.string.CircusMalbec2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Circus Sauvignon Blanc 2017
            a = new Album(words[45], fondos[0], botellas[22], R.string.CircusSauvignonBlanc2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Gascon Organic 2017
            a = new Album(words[46], fondos[0], botellas[23], R.string.GasconOrganic2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //El Conquistador 2009
            a = new Album(words[47], fondos[0], botellas[24], R.string.Elconquistador2009, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Carcassone 2015
            a = new Album(words[48], fondos[0], botellas[25], R.string.Carcassone2015, "Argentina|Mendoza", banderas[0]);
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
