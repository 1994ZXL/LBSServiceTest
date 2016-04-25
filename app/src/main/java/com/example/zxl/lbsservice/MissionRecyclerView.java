package com.example.zxl.lbsservice;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZXL on 2016/4/19.
 */
public class MissionRecyclerView extends Fragment {
    private RecyclerView mRecyclerView;
    private MyListAdapter myListAdapter;
    private List<Mission> mMission;


    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.mission_recycler_list, parent, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.mission_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMission = MissionLab.getInstance(getActivity()).getMissions();
        myListAdapter = new MyListAdapter(mMission);
        mRecyclerView.setAdapter(myListAdapter);


        return v;
    }

    private class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
        private List<Mission> missions;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public View view;
            public ViewHolder(View v) {
                super(v);
                view = v;
            }
        }

        public MyListAdapter(List<Mission> missions) {
            this.missions = missions;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mission_recycler_item, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final Mission m = missions.get(position);

            TextView idTextView= (TextView) holder.view.findViewById(R.id.mission_list_item_id);
            idTextView.setText(m.getId().toString());
            idTextView.setTextColor(Color.parseColor("#3399ff"));
            idTextView.setTextSize(16);

            TextView contentTextView = (TextView) holder.view.findViewById(R.id.mission_list_item_content);
            contentTextView.setText(m.getContent());
            contentTextView.setTextColor(Color.parseColor("#3399ff"));
            contentTextView.setTextSize(16);
            contentTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = new MissionDetailsCardFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainer, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            CheckBox checkBox = (CheckBox) holder.view.findViewById(R.id.mission_list_item_checkbox);
            checkBox.setChecked(m.isSolved());
        }

        @Override
        public int getItemCount() {
            return missions.size();
        }
    }

}
