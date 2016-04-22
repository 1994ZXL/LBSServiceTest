package com.example.zxl.lbsservice;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by ZXL on 2016/4/7.
 */
public class MissionDetailsCardFragment extends Fragment{
    private static final String TAG = "MDetailsCardFragment";

    private CardView mCardView1;
    private CardView mCardView2;
    private CardView mCardView3;
    private CardView mCardView4;
    private String mId;
    private Toolbar mToolbar;
    private ImageView mBackImage;

    public static MissionDetailsCardFragment newInstance(String id){
        MissionDetailsCardFragment result = new MissionDetailsCardFragment();
        result.setId(id);
        return result;
    }

    public void setId(String id) {
        mId = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.mission_details_card, parent, false);

        mToolbar = (Toolbar)v.findViewById(R.id.missoin_details_card_toolbar);
//        mToolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        mCardView1 = (CardView)v.findViewById(R.id.mission_details_cardview1);
        mCardView2 = (CardView)v.findViewById(R.id.mission_details_cardview2);
        mCardView3 = (CardView)v.findViewById(R.id.mission_details_cardview3);
        mCardView4 = (CardView)v.findViewById(R.id.mission_details_cardview4);
        mBackImage = (ImageView)v.findViewById(R.id.mission_details_card_backimage);
        mBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "返回按钮被点击");
//                MissionRecyclerView missionRecyclerView = new MissionRecyclerView();
//                FragmentManager fragmentManager = getActivity().getFragmentManager();
//                fragmentManager.beginTransaction().addToBackStack(null);
//                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, missionRecyclerView).commit();
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });

        return v;
    }

}
