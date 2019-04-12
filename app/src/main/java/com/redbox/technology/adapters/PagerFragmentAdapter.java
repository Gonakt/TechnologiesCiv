package com.redbox.technology.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.redbox.technology.fragments.TemplatePageFragment;
import com.redbox.technology.models.Technology;

import java.util.List;

public class PagerFragmentAdapter extends FragmentPagerAdapter {

    private List <Technology> techs;

    public PagerFragmentAdapter(FragmentManager fm, List<Technology> l) {
        super(fm);
        this.techs = l;
    }

    @Override
    public Fragment getItem(int i) {
        return TemplatePageFragment.newInstance(i, techs.get(i).getName(), techs.get(i).getHelpText(), techs.get(i).getGraphic());
    }

    @Override
    public int getCount() {
        return techs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  techs.get(position).getName();
    }
}
