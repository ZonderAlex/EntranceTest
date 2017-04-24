package ru.yandex.academy.entrancetest.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.yandex.academy.entrancetest.R;

//Фрагмент избраного. На данный момент пустой для теста работоспособности

public class BookmarkFragment extends Fragment {
    public BookmarkFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        return inflater.inflate(R.layout.bookmark_fragment, container, false);
    }
}
