package com.vlim.deimos;

import android.content.Context;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    public Context mContext;
    private List<Album> albumList;
    private ArrayList<Album> arraytitles;
    LayoutInflater inflater;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, contenido, ubicacion;
        public ImageView fondo, botella, bandera;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_title);
            contenido = (TextView) view.findViewById(R.id.txt_contenido);
            fondo = (ImageView) view.findViewById(R.id.iv_fondo);
            botella = (ImageView) view.findViewById(R.id.iv_botella);
            ubicacion =(TextView) view.findViewById(R.id.txt_ubicacion);
            bandera = (ImageView) view.findViewById(R.id.iv_bandera);
        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        inflater = LayoutInflater.from(mContext);
        this.arraytitles = new ArrayList<Album>();
        this.arraytitles.addAll(albumList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Album album = albumList.get(position);
        holder.title.setText(album.getTitle());
        holder.contenido.setText(album.getContenido());
        holder.ubicacion.setText(album.getUbicacion());


        // loading album cover using Glide library

        Glide.with(mContext).load(album.getBotella()).into(holder.botella);

        holder.botella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.botella);
            }
        });


        Glide.with(mContext).load(album.getFondo()).into(holder.fondo);

        holder.fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.fondo);
            }
        });


        Glide.with(mContext).load(album.getBandera()).into(holder.bandera);

        holder.bandera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.bandera);
            }
        });


    }


    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }


    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder {
        TextView nombre;
    }


    public int getCount() {
        return albumList.size();
    }


    public Album getItem(int position) {
        return albumList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_ernesto_catena, null);
            // Buscar los datos y presentarlos en el listview_item.xml
            holder.nombre = (TextView) view.findViewById(R.id.txt_title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Establecer resultados en el TextView
        holder.nombre.setText(albumList.get(position).getTitle());
        return view;
    }

    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        albumList.clear();
        if (charText.length() == 0) {
            albumList.addAll(arraytitles);
        } else {
            for (Album wp : arraytitles) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    albumList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}


