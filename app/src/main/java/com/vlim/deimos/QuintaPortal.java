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
