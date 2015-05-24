package org.esn.geekteam.npnancy15.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.models.Tips;

/**
 * Created by Spider on 16/05/15.
 */
public class DetailFragment extends Fragment{
    private Tips tip;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tip = (Tips) getArguments().getSerializable("tip");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, null);

        TextView title = (TextView) view.findViewById(R.id.detail_title);
        TextView desc = (TextView) view.findViewById(R.id.detail_description);
        TextView sign = (TextView) view.findViewById(R.id.detail_signature);

        title.setText("Comment utiliser un #hashtag ?");
        String styledText = "Quand vous postez un statut, une image ou une vidéo sur un réseau social (facebook, twitter, instagram...) accompagné d'un hashtag cela lui donne plus de visibilité.<br><br>" +
                "En utilisant <strong>#NPnancy2015</strong>, le reste de votre section et du réseau pourra retrouver tout ce qui a été posté pendant la NP et voir ce qu'ils ont manqué !<br><br>" +
                "En utilisant <strong>#ESNfrenchtouch</strong>, les contenus seront visibles sur <a href='http://ixesn.fr'>le site d'ESN France</a> : n'hésitez pas à postez un maximum de photos et vidéos (sobres et responsables bien évidemment) qui montreront aux visiteurs que notre réseau est le plus cool de France.";
        desc.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        desc.setMovementMethod(LinkMovementMethod.getInstance());
        sign.setText("#Palloconnecté");

        return view;
    }
}
