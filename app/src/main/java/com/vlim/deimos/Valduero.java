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

public class Valduero extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valduero);
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
        final String[] wordsValduero = getResources().getStringArray(R.array.valduero);
        int[] valdueroVinos = new int[]{
                R.drawable.vvalduerocrianza3lt2015,
                R.drawable.vvalduerocrianza500mls,
                R.drawable.vvalduerocrianza2014,
                R.drawable.vvalduerogranreserva2007,
                R.drawable.vvaldueroreserva3lt2011,
                R.drawable.vvaldueroreserva2011,
                R.drawable.vvaldueroreservalatenada15lt2010,
                R.drawable.vvaldueroreservalatenada3lt2010,
                R.drawable.vvaldueroreservalatenada2010,
                R.drawable.vvalduerorosado,
                R.drawable.vviaderoblanco

        };
        int[] fondos = new int[]{
                R.drawable.fondoredblend};

        int[] banderas = new int[]{
                R.drawable.logoargentina};

        for(int i =0 ;i <1; i++){
            //Valduero Crianza 3LT 2015
            Album a = new Album(wordsValduero[0], fondos[0], valdueroVinos[0], R.string.elcontrabandistapetitverdot2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Crianza 500 mls
            a = new Album(wordsValduero[1], fondos[0], valdueroVinos[1], R.string.elrenegadocs2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Crianza 2014
            a = new Album(wordsValduero[2], fondos[0], valdueroVinos[2], R.string.eltramposocfranc2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Gran Reserva 2007
            a = new Album(wordsValduero[3], fondos[0], valdueroVinos[3], R.string.retoblend2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Reserva 3Lt 2011
            a = new Album(wordsValduero[4], fondos[0], valdueroVinos[4], R.string.retocabernetfranc2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //valduero Reserva 2011
            a = new Album(wordsValduero[5], fondos[0], valdueroVinos[5], R.string.retocabernetsauvignon2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Reserva la Tenada 1.5lt 2010
            a = new Album(wordsValduero[6], fondos[0], valdueroVinos[6], R.string.retochardonnay2018, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Reserva la Tenada 3lt 2010
            a = new Album(wordsValduero[7], fondos[0], valdueroVinos[7], R.string.retomalbec2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Reserva la Tenada 2010
            a = new Album(wordsValduero[8], fondos[0], valdueroVinos[8], R.string.vicentinarrogante, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valduero Rosado
            a = new Album(wordsValduero[9], fondos[0], valdueroVinos[9], R.string.vicentinbackbone, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Valdero Blanco
            a = new Album(wordsValduero[10], fondos[0], valdueroVinos[10], R.string.vicentinblancdemalbec2017, "Argentina|Mendoza", banderas[0]);
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
