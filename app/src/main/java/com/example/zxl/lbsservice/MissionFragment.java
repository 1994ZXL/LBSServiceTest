package com.example.zxl.lbsservice;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ZXL on 2016/4/5.
 */
public class MissionFragment extends ListFragment{
    private ArrayList<Mission> mMission;

    private class MissionAdapter extends ArrayAdapter<Mission> {

        public MissionAdapter(ArrayList<Mission> missions){
            super(getActivity(), 0, missions);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(null == convertView) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.mission_list_item, null);
            }

            Mission m = getItem(position);

            TextView idTextView= (TextView) convertView.findViewById(R.id.mission_list_item_id);
            idTextView.setText(m.getId().toString());
            idTextView.setTextColor(Color.parseColor("#3399ff"));
            idTextView.setTextSize(16);

            TextView contentTextView = (TextView) convertView.findViewById(R.id.mission_list_item_content);
            contentTextView.setText(m.getContent());
            contentTextView.setTextColor(Color.parseColor("#3399ff"));
            contentTextView.setTextSize(16);

            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.mission_list_item_checkbox);
            checkBox.setChecked(m.isSolved());

            return convertView;
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Mission m = ((MissionAdapter) getListAdapter()).getItem(position);

        MissionDetailsCardFragment missionDetailsCardFragment = new MissionDetailsCardFragment();
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, missionDetailsCardFragment).commit();
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setHasOptionsMenu(true);

        getActivity().setTitle("任务列表");
        mMission = MissionLab.getInstance(getActivity()).getMissions();
        MissionAdapter adapter = new MissionAdapter(mMission);
        setListAdapter(adapter);
    }

}
