package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Karma on 23/01/16.
 */
public class AdapterPager extends FragmentStatePagerAdapter {
    List<Fragment> fragments;
    String[] tabTitles = {"Journey Planner", "Line Status"};

    public AdapterPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
