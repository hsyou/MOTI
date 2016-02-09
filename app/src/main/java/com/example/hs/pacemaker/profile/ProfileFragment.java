package com.example.hs.pacemaker.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hs.pacemaker.R;
import com.github.florent37.materialviewpager.MaterialViewPager;

/**
 * Created by hs on 2016-01-09.
 */
public class ProfileFragment extends Fragment {

    private int int_items = 3;
    private MaterialViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_main_self, container, false);

//        ImageView profile_back = (ImageView)rootView.findViewById(R.id.profile_profile_img_back);
        mViewPager = (MaterialViewPager)rootView.findViewById(R.id.materialViewPager);
//        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
//            @Override
//            public HeaderDesign getHeaderDesign(int page) {
//                switch (page) {
//                    case 0:
//                        return HeaderDesign.fromColorResAndUrl(
//                                R.color.blue,
//                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
//                    case 1:
//                        return HeaderDesign.fromColorResAndUrl(
//                                R.color.green,
//                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
//                    case 2:
//                        return HeaderDesign.fromColorResAndUrl(
//                                R.color.cyan,
//                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
//                    case 3:
//                        return HeaderDesign.fromColorResAndUrl(
//                                R.color.red,
//                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
//                }
//                return null;
//            }
//        });

        Toolbar toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

            ActionBar actionBar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
        }

        ViewPager viewPager = mViewPager.getViewPager();
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());




        return rootView;
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new PhotosFragment();
                case 1 : return new FollowersFragment();
                case 2 : return new FollowingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "PHOTOS";
                case 1 :
                    return "FOLLOWING";
                case 2 :
                    return "FOLLOWERS";
            }
            return null;
        }
    }
}