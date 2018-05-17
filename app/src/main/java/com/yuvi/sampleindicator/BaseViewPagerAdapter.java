package com.yuvi.sampleindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Fragment adapter
 *
 * @param <L>
 */

public abstract class BaseViewPagerAdapter<L> extends FragmentStatePagerAdapter {

    List<L> list;

    public BaseViewPagerAdapter(FragmentManager fm, List<L> l) {
        super(fm);
        this.list = l;
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return attachFragment(list.get(position));
        } catch (Exception e) {
            e.printStackTrace();
           Log.w(this.getClass().getSimpleName(), "either list is null or something wrong with the BaseViewPageadapter");
        }
        return null;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    public abstract Fragment attachFragment(L l);
}
