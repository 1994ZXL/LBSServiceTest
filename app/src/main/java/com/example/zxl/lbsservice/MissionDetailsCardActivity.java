package com.example.zxl.lbsservice;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by ZXL on 2016/4/7.
 */
public class MissionDetailsCardActivity extends Activity{

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment;
        FragmentManager fm = getFragmentManager();
        fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (null == fragment) {
            fragment = new MissionDetailsCardFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

}
