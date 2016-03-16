package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.DestinationListAdapter;
import com.example.xiaohan_lh.qiongyouapp.adapter.DestinationListRecyAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.Continent;
import com.example.xiaohan_lh.qiongyouapp.bean.Country;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.ui.CountryDetailActivity;
import com.example.xiaohan_lh.qiongyouapp.view.DestinationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinationFragment extends Fragment implements DestinationView, View.OnClickListener {


    @Bind(R.id.destination_listview)
    ExpandableListView destinationListview;


    private TabPresenter presenter;
    private List<Continent> list;
    private DestinationListAdapter adapter;
    private HeadViewHolder vh;
    private DestinationListRecyAdapter.OnChildClickListener listener;
    private List<DestinationListAdapter> listAdapters = new ArrayList<>();
    private List<RadioButton> listbtn = new ArrayList<>();
    private List<TextView> listTxt = new ArrayList<>();


    public static DestinationFragment newInstance() {
        Bundle args = new Bundle();
        DestinationFragment fragment = new DestinationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination, container, false);
        ButterKnife.bind(DestinationFragment.this, view);
        vh = new HeadViewHolder();
        destinationListview.addHeaderView(vh.headView);
        initData();
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.destina_head_asbtn:
                clikelisen(R.id.destina_head_asbtn);
                adapter = listAdapters.get(0);
                break;
            case R.id.destina_head_eurbtn:
                clikelisen(R.id.destina_head_eurbtn);
                adapter = listAdapters.get(1);
                break;
            case R.id.destina_head_nobtn:
                clikelisen(R.id.destina_head_nobtn);
                adapter = listAdapters.get(2);
                break;
            case R.id.destina_head_sabtn:
                clikelisen(R.id.destina_head_sabtn);
                adapter = listAdapters.get(3);
                break;
            case R.id.destina_head_ocbtn:
                clikelisen(R.id.destina_head_ocbtn);
                adapter = listAdapters.get(4);
                break;
            case R.id.destina_head_afbtn:
                clikelisen(R.id.destina_head_afbtn);
                adapter = listAdapters.get(5);
                break;
            case R.id.destina_head_anbtn:
                clikelisen(R.id.destina_head_anbtn);
                adapter = listAdapters.get(6);
                break;
            default:
                break;
        }

        adapter.notifyDataSetChanged();
        destinationListview.setAdapter(adapter);
        if(list.get(0).getCountry().size()!=0) {
            for (int i = 0; i < 2; i++) {
                destinationListview.expandGroup(i);
            }
        }
    }

    private void clikelisen(int id) {
        for (int i = 0; i < listbtn.size(); i++) {
            if (id == listbtn.get(i).getId()) {
                listbtn.get(i).setChecked(true);
                listTxt.get(i).setTextColor(Color.WHITE);
            }else{
                listbtn.get(i).setChecked(false);
                listTxt.get(i).setTextColor(Color.GRAY);
            }
        }
    }

    public class HeadViewHolder {
        @Bind(R.id.destina_head_nobtn)
        RadioButton destinaHeadNobtn;
        @Bind(R.id.destina_head_sabtn)
        RadioButton destinaHeadSabtn;
        @Bind(R.id.destina_head_eurbtn)
        RadioButton destinaHeadEurbtn;
        @Bind(R.id.destina_head_afbtn)
        RadioButton destinaHeadAfbtn;
        @Bind(R.id.destina_head_asbtn)
        RadioButton destinaHeadAsbtn;
        @Bind(R.id.destina_head_ocbtn)
        RadioButton destinaHeadOcbtn;
        @Bind(R.id.destina_head_anbtn)
        RadioButton destinaHeadAnbtn;
        @Bind(R.id.destina_head_notxt)
        TextView destinaHeadNotxt;
        @Bind(R.id.destina_head_satxt)
        TextView destinaHeadSatxt;
        @Bind(R.id.destina_head_eurtxt)
        TextView destinaHeadEurtxt;
        @Bind(R.id.destina_head_aftxt)
        TextView destinaHeadAftxt;
        @Bind(R.id.destina_head_astxt)
        TextView destinaHeadAstxt;
        @Bind(R.id.destina_head_octxt)
        TextView destinaHeadOctxt;
        @Bind(R.id.destina_head_antxt)
        TextView destinaHeadAntxt;
        private View headView;

        public HeadViewHolder() {
            headView = LayoutInflater.from(getContext()).inflate(R.layout.destination_headview, null);
//            //注解初始化
            ButterKnife.bind(this, headView);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initData() {
        presenter = new TabPresenterImpl(this);
        presenter.getDestination();
        listener = new DestinationListRecyAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(View child, int position, Country itemEntity) {
                Intent intent = new Intent(getActivity(), CountryDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("countryid",itemEntity.getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        btnlistAdd();
    }

    private void btnlistAdd() {
        listbtn.add(vh.destinaHeadAsbtn);
        listbtn.add(vh.destinaHeadEurbtn);
        listbtn.add(vh.destinaHeadNobtn);
        listbtn.add(vh.destinaHeadSabtn);
        listbtn.add(vh.destinaHeadOcbtn);
        listbtn.add(vh.destinaHeadAfbtn);
        listbtn.add(vh.destinaHeadAnbtn);
        listTxt.add(vh.destinaHeadAstxt);
        listTxt.add(vh.destinaHeadEurtxt);
        listTxt.add(vh.destinaHeadNotxt);
        listTxt.add(vh.destinaHeadSatxt);
        listTxt.add(vh.destinaHeadOctxt);
        listTxt.add(vh.destinaHeadAftxt);
        listTxt.add(vh.destinaHeadAntxt);
        for (int i = 0; i < listbtn.size(); i++) {
            listbtn.get(i).setOnClickListener(this);
        }
    }

    @Override
    public void destinationSueccess(DestinationEntity tabDestinationEntity) {
        list = tabDestinationEntity.getData();
        initAdapter();
        adapter = listAdapters.get(0);
        destinationListview.setAdapter(adapter);
        listbtn.get(0).setChecked(true);
        if(list.get(0).getCountry().size()!=0) {
            for (int i = 0; i < 2; i++) {
                destinationListview.expandGroup(i);
            }
        }

    }

    private void initAdapter() {
        for (int i = 0; i < list.size(); i++) {
            listAdapters.add(new DestinationListAdapter(list.get(i), getActivity(),listener));
        }
    }

    @Override
    public void fail(Throwable t) {
        Toast.makeText(getContext(), "网络问题", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
