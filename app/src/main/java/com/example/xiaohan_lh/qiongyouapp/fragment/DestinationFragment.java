package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.TabDestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.view.DestinationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinationFragment extends Fragment implements DestinationView{


    public static DestinationFragment newInstance() {

        Bundle args = new Bundle();

        DestinationFragment fragment = new DestinationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination, container, false);
    }

    @Override
    public void destinationSueccess(TabDestinationEntity tabDestinationEntity) {

    }

    @Override
    public void fail(Throwable t) {

    }
}
