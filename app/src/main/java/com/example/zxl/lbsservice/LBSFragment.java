package com.example.zxl.lbsservice;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXL on 2016/3/25.
 */
public class LBSFragment extends Fragment {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private String[] str = {"我的过往", "消息中心", "客服中心", "关于我们"};

    MapView mMapView = null;
    BaiduMap mBaiduMap = null;

    private static final String TAG = "LBSFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, parent, false);

        mMapView = (MapView)v.findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        LatLng point = new LatLng(39.963175, 116.400244);
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
        mBaiduMap.addOverlay(option);

        toolbar = (Toolbar)v.findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout)v.findViewById(R.id.dl_left);
        listView = (ListView)v.findViewById(R.id.lv_left_menu);
        toolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        TextView textView1 = (TextView)v.findViewById(R.id.toolbar_personal);
        TextView textView2 = (TextView)v.findViewById(R.id.toolbar_mission);
        textView1.setClickable(true);
        textView2.setClickable(true);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MissionActivity.class);
                startActivity(intent);
            }
        });
        //MyAdapter myAdapter = new MyAdapter(str);
        arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, str);
        listView.setAdapter(arrayAdapter);
        return v;
    }
    /*
    private class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(String[] str){
            super(getActivity(), 0, str);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if ( null == convertView ) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.personal_fragment, null);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.personal_imageview);
            TextView textView = (TextView) convertView.findViewById(R.id.personal_textview);

            textView.setTextSize(16);
            textView.setTextColor(getResources().getColor(R.color.material_blue_grey_800));

            return convertView;
        }
    }
    */
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_lbs, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
