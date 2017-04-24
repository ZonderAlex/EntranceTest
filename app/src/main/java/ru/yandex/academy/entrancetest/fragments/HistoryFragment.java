package ru.yandex.academy.entrancetest.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.yandex.academy.entrancetest.R;

//Фрагмент истории переводов. На данный момент пустой для теста работоспособности

public class HistoryFragment extends Fragment {
    public HistoryFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        return inflater.inflate(R.layout.history_fragment, container, false);
    }
}
