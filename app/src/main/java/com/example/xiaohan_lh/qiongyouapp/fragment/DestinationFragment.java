package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.Continent;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.model.TabModel;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.view.DestinationView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinationFragment extends Fragment implements DestinationView {


    @Bind(R.id.destination_listview)
    ExpandableListView destinationListview;
    @Bind(R.id.destina_head_radioGroup)
    RadioGroup radioGroup;
    private TabPresenter presenter;
    private List<Continent> list;


    public static DestinationFragment newInstance() {
        Bundle bundle = new Bundle();
        DestinationFragment fragment = new DestinationFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination, container, false);
        ButterKnife.bind(getActivity());
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.destination_headview,null,false);
        destinationListview.addHeaderView(view);
        initData();
        return view;
    }

    private void initData() {
        presenter.getDestination();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.destina_head_nobtn:
                        break;
                    case R.id.destina_head_sabtn:break;
                    case R.id.destina_head_eurbtn:break;
                    case R.id.destina_head_afbtn:break;
                    case R.id.destina_head_asbtn:break;
                    case R.id.destina_head_ocbtn:break;
                    case R.id.destina_head_anbtn:break;
                    default:break;
                }
            }
        });
    }


    @Override
    public void destinationSueccess(DestinationEntity destinationEntity) {
        list = destinationEntity.getData();
    }

    @Override
    public void fail(Throwable t) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
