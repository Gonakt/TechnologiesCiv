package com.redbox.technology.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.redbox.technology.R;
import com.redbox.technology.adapters.PagerFragmentAdapter;
import com.redbox.technology.models.Technology;

import java.lang.reflect.Type;
import java.util.List;

public class PagesFragment extends Fragment {
    private ViewPager pager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private String rList;
    private List<Technology> techs;
    private int page_;

    public PagesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v  = inflater.inflate(R.layout.fragment_pager, container, false);

        rList = getArguments().getString("List");
        page_ = getArguments().getInt("Item");

        Type listType = new TypeToken<List<Technology>>(){}.getType();
        final GsonBuilder builder = new GsonBuilder();
        Gson gson =  builder.create();
        techs = gson.fromJson(rList, listType);
        techs.remove(0);



        pager = v.findViewById(R.id.infoViewPager);
        fragmentPagerAdapter = new PagerFragmentAdapter(getActivity().getSupportFragmentManager(),techs);
        pager.setAdapter(fragmentPagerAdapter);
        pager.setCurrentItem(page_);
        return v;
    }

}
