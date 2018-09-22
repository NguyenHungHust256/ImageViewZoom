package com.example.bahung.imageviewzoom.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.bahung.imageviewzoom.View.Fragment.ImageFragment;

public class ImagePagerAdapter extends FragmentStatePagerAdapter {

    public ImagePagerAdapter(Fragment fragment) {
        // Note: Initialize with the child fragment manager.
        super(fragment.getChildFragmentManager());
    }

    @Override
    public int getCount() {
        return ImageData.datas.size();
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(ImageData.datas.get(position));
    }
}