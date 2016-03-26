package com.example.zxl.lbsservice;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import com.baidu.mapapi.SDKInitializer;

public class LBSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        Fragment fragment;
        FragmentManager fm = getFragmentManager();
        fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (null == fragment) {
            fragment = new LBSFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

}
