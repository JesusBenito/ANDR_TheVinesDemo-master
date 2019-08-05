package com.vlim.deimos;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Anthony on 16-01-25.
 */
public class MasterFragment extends ListFragment {

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container);

        setListAdapter(new MenuListAdapter(R.layout.row_menu_action_item, getActivity(), MenuActionItem.values()));
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        MenuActionItem item = (MenuActionItem)getListAdapter().getItem(position);

        Log.d(Config.TAG, "click en " + item.name());

        switch(item.toString()){
            case "ITEM1":    // LECTOR QR

                Intent lectorQR = new Intent(getContext(), QRActivity.class);
                startActivity(lectorQR);

                break;
            case "ITEM2":    // LECTOR AR

                break;
            case "ITEM3":   // HISTORICO
                Intent historico = new Intent(getContext(), HistoricosActivity.class);
                startActivity(historico);
                break;
            case "ITEM4":   // REVISTA
                break;
            case "ITEM5":   // FACEBOOK

                final String urlFb = "fb://page/764465430388446";
                Intent intentFacebook = new Intent(Intent.ACTION_VIEW);
                intentFacebook.setData(Uri.parse(urlFb));

                // If a Facebook app is installed, use it. Otherwise, launch
                // a browser
                final PackageManager packageManager = getActivity().getPackageManager();
                List<ResolveInfo> list =
                        packageManager.queryIntentActivities(intentFacebook,
                                PackageManager.MATCH_DEFAULT_ONLY);
                if (list.size() == 0) {
                    final String urlBrowser = "https://www.facebook.com/pages/764465430388446";
                    intentFacebook.setData(Uri.parse(urlBrowser));
                }
                startActivity(intentFacebook);
                break;

            case "ITEM6":   //TWITTER
                Intent intentTwitter = null;
                try {
                    // get the Twitter app if possible
                    getActivity().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=882870702831022080"));
                    intentTwitter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/deimosstudio"));
                }
                startActivity(intentTwitter);
                break;

            case "ITEM7":   // INSTAGRAM
                Uri uri = Uri.parse("https://www.instagram.com/volkswagen/?hl=es-la");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/volkswagen/?hl=es-la")));
                }

                break;

            case "ITEM8":   // YOUTUBE
                Intent intentYoutube = null;
                try {
                    intentYoutube = new Intent(Intent.ACTION_VIEW);
                    intentYoutube.setPackage("com.google.android.youtube");
                    intentYoutube.setData(Uri.parse("https://www.youtube.com/channel/UCZOWzC1SZPiIRRr52fdabvw"));
                    startActivity(intentYoutube);
                } catch (ActivityNotFoundException e) {
                    intentYoutube = new Intent(Intent.ACTION_VIEW);
                    intentYoutube.setData(Uri.parse("https://www.youtube.com/channel/UCZOWzC1SZPiIRRr52fdabvw"));
                    startActivity(intentYoutube);
                }
                break;

            case "ITEM9":   // SITIO WEB
                String url = "http://www.deimosmediagroup.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case "ITEM10":  // SUSCRIPCION
                break;
        }
    }


    public enum MenuActionItem {
        ITEM1,
        ITEM2,
        ITEM3,
        ITEM4,
        ITEM5,
        ITEM6,
        ITEM7,
        ITEM8,
        ITEM9,
        ITEM10

    }
}