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

import java.util.ArrayList;
import java.util.List;

public class ErnestoCatena extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ernesto_catena);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

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
    }



    private void prepareAlbums() {
        final String[] words = getResources().getStringArray(R.array.words);
        int[] almanegra = new int[]{
                R.drawable.almanegrablancsb,
                R.drawable.almanegrablancsb,
                R.drawable.almanegratinto2013,
                R.drawable.almanegramblend,
                R.drawable.granalmanegra};

        int[] padrillos = new int[]{
                R.drawable.padrillospn2016,
                R.drawable.padrillosblend2008,
                R.drawable.padrillosmalbec};
        int[] siesta = new int[]{
                R.drawable.siestamalbec2014,
                R.drawable.siestapn2011,
                R.drawable.siestacabernet2014
        };

        int[] animal = new int[]{
                R.drawable.animalmalbec2017,
                R.drawable.animalcabernetsauvig,
                R.drawable.animalchorg
        };

        int[] tahuan = new int[]{
                R.drawable.tahuanmalbec2011,
                R.drawable.tahuanbonarda2011,
                R.drawable.tahuanchar2011
        };

        int[] tikaljubilo= new int[]{
                R.drawable.tikaljubilo,
                R.drawable.tikalamorio2013
        };

        int[] fondos = new int[]{
                R.drawable.almanegrafondo,
                R.drawable.padrillosfondoo,
                R.drawable.siesta,
                R.drawable.animalfondo};

        int[] banderas = new int[]{
                R.drawable.bargentina
        };

        //Alma Negra Blanc
        Album a = new Album(words[0], fondos[0], almanegra[0], R.string.almanegra_blanc, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Alma Negra Brut
        a = new Album(words[1], fondos[0], almanegra[1], R.string.almanegra_brut, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Alma Negra Tinto 2013
        a = new Album(words[2], fondos[0], almanegra[2], R.string.almanegra_2013, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Alma Negra MBlend
        a = new Album(words[3], fondos[0], almanegra[3], R.string.almanegra_mblend_2013, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Gran Alma Negra
        a = new Album(words[4], fondos[0], almanegra[4], R.string.granalmanegra_2012_2011, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Padrillos Pinot Noir 2016
        a = new Album(words[5], fondos[1], padrillos[0], R.string.padrillospinotnoir2016, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Padrillos Blend 2008
        a = new Album(words[6], fondos[1], padrillos[1], R.string.padrillosblend2008, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);


        //Padrillos Malbec 2017
        a = new Album(words[7], fondos[1], padrillos[2], R.string.padrillosmalbec20092017, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Siesta Malbec 2014
        a = new Album(words[8], fondos[2], siesta[0], R.string.siestamalbec2014, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Siesta Pinot Noir 2011
        a = new Album(words[9], fondos[2], siesta[1], R.string.siestapinotnoir2011, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Siesta Cabernet Sauvignon 2014
        a = new Album(words[10], fondos[2], siesta[2], R.string.siestaCabernrtSauvignon2011, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Siesta Biodinamico Malbec 2014
        a = new Album(words[11], fondos[2], R.drawable.vacio, R.string.SiestaBiodinamicoMalbec2014, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Siesta Biodinamico Cabernet 2014
        a = new Album(words[12], fondos[2], R.drawable.vacio, R.string.SiestaBiodinamicoCabernet2014, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //SiestacBiodinamico Auvignon 2013
        a = new Album(words[13], fondos[2], R.drawable.vacio, R.string.SiestaBiodinamicoAuvignon2013, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Gran Sienta Gift Box
        a = new Album(words[14], fondos[2], R.drawable.vacio, R.string.gransientagiftBox, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Animal Malbec 2017
        a = new Album(words[15], fondos[3], animal[0], R.string.animalMalbec2017, "Argentina|Mendoza", banderas[0]);
        albumList.add(a);

        //Animal Cabernet Sauvignon 2017
        a = new Album(words[16],fondos[3],animal[1],R.string.animalCabernetSauvignon2017,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        //Animal Chardonnay 2018
        a = new Album(words[17],fondos[3],animal[2],R.string.animalChardonnay2018,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        //Tahuan Malbec 2016
        a = new Album(words[18],fondos[3],tahuan[0],R.string.tahuanMalbec2011,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        //Tahuan Bonarda 2011
        a = new Album(words[19],fondos[3],tahuan[1],R.string.tahuanBonarda2011,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        //Tahuan Chardonnay 2011
        a = new Album(words[20],fondos[3],tahuan[2],R.string.tahuanChardonnay2011,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        //Tikal Jubilo
        a = new Album(words[21],fondos[3],tikaljubilo[0],R.string.tikaljubilo,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        //Tikal Amorio 2013
        a = new Album(words[22],fondos[3],tikaljubilo[1],R.string.tikalamorio20082013,"Argentina|Mendoza",banderas[0]);
        albumList.add(a);

        adapter.notifyDataSetChanged();

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
