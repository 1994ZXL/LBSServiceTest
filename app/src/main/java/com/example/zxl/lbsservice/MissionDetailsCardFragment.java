package com.example.zxl.lbsservice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ZXL on 2016/4/7.
 */
public class MissionDetailsCardFragment extends Fragment{
    private CardView mCardView1;
    private CardView mCardView2;
    private CardView mCardView3;
    private CardView mCardView4;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.mission_details_card, parent, false);

        mCardView1 = (CardView)v.findViewById(R.id.mission_details_cardview1);
        mCardView2 = (CardView)v.findViewById(R.id.mission_details_cardview2);
        mCardView3 = (CardView)v.findViewById(R.id.mission_details_cardview3);
        mCardView4 = (CardView)v.findViewById(R.id.mission_details_cardview4);

        return v;
    }

}
