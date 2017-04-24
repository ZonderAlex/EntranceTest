package ru.yandex.academy.entrancetest;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class ViewPagerAdapter extends FragmentPagerAdapter {
    //массив для ссылок
    private final List<Fragment> FragmentsList = new ArrayList<>();

    //реализация get set для адаптера
    ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return FragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentsList.size();
    }

    void addFragment(Fragment fragment) {
        FragmentsList.add(fragment);
    }
}
