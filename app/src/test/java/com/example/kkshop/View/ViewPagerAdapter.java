package com.example.kkshop.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.kkshop.Utils.logUtil;

import java.util.List;


/**
 * Created by KID on 2017/8/10 0010.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments;
    private static final String TAG = "ViewPagerAdapter";

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public Fragment getItem(int position) {
        logUtil.e(TAG,"get item");
        return fragments.get(position);
    }

}
