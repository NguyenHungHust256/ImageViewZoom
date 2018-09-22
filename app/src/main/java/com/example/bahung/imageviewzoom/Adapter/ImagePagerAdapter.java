package com.example.bahung.imageviewzoom.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.bahung.imageviewzoom.View.Fragment.ImageFragment;

import static com.example.bahung.imageviewzoom.Adapter.ImageData.IMAGE_DRAWABLES;

public class ImagePagerAdapter extends FragmentStatePagerAdapter {

    public ImagePagerAdapter(Fragment fragment) {
        // Note: Initialize with the child fragment manager.
        super(fragment.getChildFragmentManager());
    }

    @Override
    public int getCount() {
        return IMAGE_DRAWABLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(IMAGE_DRAWABLES[position]);
    }
}