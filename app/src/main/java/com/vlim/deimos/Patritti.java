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

public class Patritti extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patritti);
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
        final String[] wordsPatritti = getResources().getStringArray(R.array.patritti);
        int[] patrittiVinos = new int[]{
                R.drawable.vprimogenitosangreazulmerlot2016,
                R.drawable.vprimogenitosommelier2012,
                R.drawable.vprimogenitopinotnoir2014,
                R.drawable.vprimogenitoblend2013,
                R.drawable.vprimogenitomerlot2011,
                R.drawable.vprimogenitomalbec2008,
                R.drawable.vprimogenitosangreazulpinotnoir,
                R.drawable.vprimogenitocabernetsauvignon,
                R.drawable.vprimogenitosangreazulblend,
                R.drawable.vprimogenitosangreazulchardonnay,
        };

        int[] fondos = new int[]{
                R.drawable.fondoredblend};

        int[] banderas = new int[]{
                R.drawable.logoargentina
        };



        for(int i =0 ;i <1; i++){
            //Primogenito Sangre Azul Merlot 2016
            Album a = new Album(wordsPatritti[0], fondos[0], patrittiVinos[0], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Primogenito Sommelier 2012
            a = new Album(wordsPatritti[1], fondos[0], patrittiVinos[1], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Primogenito Pinot Noir 2014
            a = new Album(wordsPatritti[2], fondos[0], patrittiVinos[2], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Primogenito Blend 2013
            a = new Album(wordsPatritti[3], fondos[0], patrittiVinos[3], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Primogenito Merlot 2011
            a = new Album(wordsPatritti[4], fondos[0], patrittiVinos[4], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Primogenito Malbec 2008
            a = new Album(wordsPatritti[5], fondos[0], patrittiVinos[5], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Primogenito Sangre Azul Pinot Noir
            a = new Album(wordsPatritti[6], fondos[0], patrittiVinos[6], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //Primogenito Cabernet Sauvignon
            a = new Album(wordsPatritti[7], fondos[0], patrittiVinos[7], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Primogenito Sangre Azul Blend
            a = new Album(wordsPatritti[8], fondos[0], patrittiVinos[8], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //Primogenito Sangre Azul Chardonnay
            a = new Album(wordsPatritti[9], fondos[0], patrittiVinos[9], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
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
