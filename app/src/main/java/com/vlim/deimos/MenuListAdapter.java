package com.vlim.deimos;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Anthony on 16-01-25.
 */
public class MenuListAdapter extends ArrayAdapter<MasterFragment.MenuActionItem> {

    int resource;
    Activity activity;


    public MenuListAdapter(int resource, Activity activity, MasterFragment.MenuActionItem[] items) {
        super(activity, resource, items);

        this.resource = resource;
        this.activity = activity;
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        Typeface tf = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/Berthold-akzidenz-grotesk-be-bold.ttf");

        if(rowView == null) {
            rowView = activity.getLayoutInflater().inflate(resource, null);

            MenuItemViewHolder viewHolder = new MenuItemViewHolder();

            viewHolder.menuItemImageView = rowView.findViewById(R.id.menu_item_image_view);
            viewHolder.menuItemTextView = rowView.findViewById(R.id.menu_item_text_view);

            viewHolder.menuItemTextView.setTypeface(tf);

            rowView.setTag(viewHolder);
        }

        MenuItemViewHolder holder = (MenuItemViewHolder)rowView.getTag();

        if(position == MasterFragment.MenuActionItem.ITEM1.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.qr));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.lector_qr));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM2.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.ar));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.lector_ar));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM3.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.elapsed_time));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.historico));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM4.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.pdf));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.revista));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM5.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.facebook));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.facebook));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM6.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.twitter));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.twitter));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM7.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.instagram));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.instagram));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM8.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.youtube));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.youtube));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM9.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.globe));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.sitioweb));
        }
        else if(position == MasterFragment.MenuActionItem.ITEM10.ordinal()) {
            holder.menuItemImageView.setImageDrawable(activity.getDrawable(R.drawable.document));
            holder.menuItemTextView.setText(activity.getResources().getString(R.string.suscripcion));
        }

        return rowView;
    }

    private static class MenuItemViewHolder {
        public ImageView menuItemImageView;
        public TextView menuItemTextView;
    }
}