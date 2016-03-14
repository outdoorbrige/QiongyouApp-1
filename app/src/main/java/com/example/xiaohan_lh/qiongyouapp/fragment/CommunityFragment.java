package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.view.CommunityView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment implements CommunityView {


    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    public void communitySueccess(TabCommunityEntity tabCommunityEntity) {

    }

    @Override
    public void fail(Throwable t) {

    }
}
