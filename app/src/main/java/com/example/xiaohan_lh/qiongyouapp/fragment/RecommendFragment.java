package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaohan_lh.qiongyouapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {


    public RecommendFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

}
