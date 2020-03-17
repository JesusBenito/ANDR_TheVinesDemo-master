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

public class Luca extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ancona_luca);
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
        final String[] wordsLuca = getResources().getStringArray(R.array.ernestoCatena);
        int[] lucaVinos = new int[]{
                R.drawable.vnicobyluca2014,
                R.drawable.vlucamalbec15l,
                R.drawable.vlucamalbec2014750ml,
                R.drawable.vlucabesodedante2016,
                R.drawable.vlucachardonnay2016,
                R.drawable.vlucasyrah2016,
                R.drawable.vlucapinotnoir2015,
                R.drawable.vlapostapinotnoir2015,
                R.drawable.vlapostamalbec2016,
                R.drawable.vlapostacocinablanco2014,
                R.drawable.vlapostaarmandobonarda2017,
                R.drawable.vlapostatintoredblend2016,
                R.drawable.vlapostapizzellamalbec2012
        };
        int[] fondos = new int[]{
                R.drawable.fv1};

        int[] banderas = new int[]{
                R.drawable.logoargentina};


        for (int i = 0; i < 1; i++) {
            //Nico By Luca 2014
            Album a = new Album(wordsLuca[0], fondos[0], lucaVinos[0], R.string.nicobyluca2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //luca malbec 2015 1500ml
            a = new Album(wordsLuca[1], fondos[0], lucaVinos[1], R.string.lucamalbec20151500ml, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //luca malbec 2015 750ml
            albumList.add(a);
            //luca beso de dante 2016
            a = new Album(wordsLuca[3], fondos[0], lucaVinos[3], R.string.lucabesodedante2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //luca chardonnay 2016
            a = new Album(wordsLuca[4], fondos[0], lucaVinos[4], R.string.lucachardonnay2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //luca syrah 2016
            a = new Album(wordsLuca[5], fondos[0], lucaVinos[5], R.string.lucasyrah2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //luca pinot noir 2015
            a = new Album(wordsLuca[6], fondos[0], lucaVinos[6], R.string.lucapinotnoir2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //la posta pinot noir 2015
            a = new Album(wordsLuca[7], fondos[0], lucaVinos[7], R.string.lapostapinotnoir2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //la posta malbec 2016
            a = new Album(wordsLuca[8], fondos[0], lucaVinos[8], R.string.lapostamalbec2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //la posta cocina blanco 2014
            a = new Album(wordsLuca[9], fondos[0], lucaVinos[9], R.string.lapostacocinablanco2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //la posta armando bonarda 2017
            a = new Album(wordsLuca[10], fondos[0], lucaVinos[10], R.string.lapostaarmandobonarda2017, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //la posta tintored blend 2016
            a = new Album(wordsLuca[11], fondos[0], lucaVinos[11], R.string.lapostatintoredblend2016, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //la posta pizzella malbec 2012
            a = new Album(wordsLuca[12], fondos[0], lucaVinos[12], R.string.lapostapizzellamalbec2012, "Argentina|Mendoza", banderas[0]);
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
