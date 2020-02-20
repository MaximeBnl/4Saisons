package com.example.a4saisons.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.a4saisons.MainActivity;
import com.example.a4saisons.R;

public class NatureFragment extends Fragment {

    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        switch (page) {
            case 0:
                image.setImageResource(R.drawable.printemps);
                break;
            case 1:
                image.setImageResource(R.drawable.ete);
                break;
            case 2:
                image.setImageResource(R.drawable.automne);
                break;
            case 3:
                image.setImageResource(R.drawable.hiver);
                break;
            case 4:
                View view_saisons = inflater.inflate(R.layout.fragment_saisons, container, false);
                ImageView image1 = (ImageView) view_saisons.findViewById(R.id.imageView1);
                image1.setImageResource(R.drawable.printemps);

                ImageView image2 = (ImageView) view_saisons.findViewById(R.id.imageView2);
                image2.setImageResource(R.drawable.ete);

                ImageView image3 = (ImageView) view_saisons.findViewById(R.id.imageView3);
                image3.setImageResource(R.drawable.automne);

                ImageView image4 = (ImageView) view_saisons.findViewById(R.id.imageView4);
                image4.setImageResource(R.drawable.hiver);

                image1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(0);
                    }
                });

                image2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(1);
                    }
                });

                image3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(2);
                    }
                });

                image4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(3);
                    }
                });

                return view_saisons;
        }

        return view;
    }

}
