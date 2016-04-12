package com.example.zxl.lbsservice;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by ZXL on 2016/4/5.
 */
public class MissionLab {
    private static ArrayList<Mission> mMissions;
    private static MissionLab sMissionLab;
    private Context mAppContext;

    private MissionLab(Context mAppContext) {
        this.mAppContext = mAppContext;
        mMissions = new ArrayList<Mission>();
        for (int i = 0; i < 100; i++) {
            Mission m = new Mission();
            m.setContent("Mission #" + i);
            m.setSolved(i % 2 == 0);
            mMissions.add(m);
        }
    }

    public static MissionLab getInstance(Context context) {
        if (null == sMissionLab) {
            sMissionLab = new MissionLab(context.getApplicationContext());
        }
        return sMissionLab;
    }

    public ArrayList<Mission> getMissions() {
        return mMissions;
    }
}
