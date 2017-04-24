package ru.yandex.academy.entrancetest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import ru.yandex.academy.entrancetest.fragments.BookmarkFragment;
import ru.yandex.academy.entrancetest.fragments.HistoryFragment;
import ru.yandex.academy.entrancetest.fragments.SettingsFragment;
import ru.yandex.academy.entrancetest.fragments.TranslateFragment;

public class MainActivity extends AppCompatActivity {

    //Ссылка объекта навигации
    BottomNavigationView bottomNavigationView;
    //Добавился контейнер для показа фрагментов
    ViewPager viewPager;
    //Объявление фрагментов
    BookmarkFragment bookmarkFragment;
    HistoryFragment historyFragment;
    SettingsFragment settingsFragment;
    TranslateFragment translateFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация меню и контейнера
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Установка нужного фрагмента при выборе пункта меню
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tab_translate:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.tab_history:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.tab_bookmark:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.tab_settings:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                });

        //Смена выбранного элемента меню при смене фрагмента (сейчас не используется
        //т.к. следующим методом отключил возможность переключения между фрагментами пальцем (так сделано в яндекс.переводчике)
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //Обязаны быть
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageScrollStateChanged(int state) {}

            @Override
            public void onPageSelected(int curPosition) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                bottomNavigationView.getMenu().getItem(curPosition).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(curPosition);
            }
        });

        //Не очень хорошее решение. Когда я обнаружил, что возврат true работает с задержкой, из-за чего
        //фрагмент успевает немного сместиться, уже не было времени реализовывать свой класс от viewpager,
        //чтобы переопределить методы переключения экранов свайпом
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewPager.setCurrentItem(viewPager.getCurrentItem());
                return true;
            }
        });

        //Инициализация фрагментов, адаптера и viewpager'a
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        bookmarkFragment = new BookmarkFragment();
        historyFragment = new HistoryFragment();
        settingsFragment = new SettingsFragment();
        translateFragment = new TranslateFragment();
        pagerAdapter.addFragment(translateFragment);
        pagerAdapter.addFragment(historyFragment);
        pagerAdapter.addFragment(bookmarkFragment);
        pagerAdapter.addFragment(settingsFragment);
        viewPager.setAdapter(pagerAdapter);
    }
}
