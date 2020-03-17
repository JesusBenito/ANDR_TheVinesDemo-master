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

public class TintoNegro extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    public ImageView btn_regresar;
    public SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinto_negro);
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
        final String[] wordsTintoNegro = getResources().getStringArray(R.array.robino);
        int[] tintoNegroVinos = new int[]{
                R.drawable.vtintonegromalbecmendoza2015,
                R.drawable.vtintonegromendozasangiovese2015,
                R.drawable.vtintonegroucovalleycabernetfranc2014,
                R.drawable.vtintonegroucovalleyreservemalbec2012,
                R.drawable.vfincalaescuelamalbec2011,
                R.drawable.vvineyard1955malbec2011
        };
        int[] fondos = new int[]{
                R.drawable.fv7};

        int[] banderas = new int[]{
                R.drawable.logoargentina};



        for(int i =0 ;i <1; i++){
            //tinto negro malbec mendoza 2015
            Album a = new Album(wordsTintoNegro[0], fondos[0], tintoNegroVinos[0], R.string.tintonegromalbecmendoza2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tinto negro mendoza sangiovese 2015
            a = new Album(wordsTintoNegro[1], fondos[0], tintoNegroVinos[1], R.string.tintonegromendozasangiovese2015, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tinto negro Uco Valley Cabernet Franc 2014
            a = new Album(wordsTintoNegro[2], fondos[0], tintoNegroVinos[2], R.string.tintonegroUcoValleyCabernetFranc2014, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //tinto negro uco valley reserve malbec 2012
            a = new Album(wordsTintoNegro[3], fondos[0], tintoNegroVinos[3], R.string.tintonegroucovalleyreservemalbec2012, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);

            //finca la escuela malbec 2011
            a = new Album(wordsTintoNegro[4], fondos[0], tintoNegroVinos[4], R.string.fincalaescuelamalbec2011, "Argentina|Mendoza", banderas[0]);
            albumList.add(a);
            //vineyard 1955 Malbec 2012
            a = new Album(wordsTintoNegro[5], fondos[0], tintoNegroVinos[5], R.string.vineyard1955Malbec2012, "Argentina|Mendoza", banderas[0]);
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
