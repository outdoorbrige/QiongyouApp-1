package com.example.xiaohan_lh.qiongyouapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.CountryDetailGridAdapter;
import com.example.xiaohan_lh.qiongyouapp.adapter.CountryDetailListAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.customize.GridViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.ImageTxtView;
import com.example.xiaohan_lh.qiongyouapp.customize.ListViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.view.CountryDetailView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CountryDetailActivity extends AppCompatActivity implements CountryDetailView {


    @Bind(R.id.country_detail_viewpage)
    ViewPager countryDetailViewpage;
    @Bind(R.id.country_detail_cnname)
    TextView countryDetailCnname;
    @Bind(R.id.country_detail_enname)
    TextView countryDetailEnname;
    @Bind(R.id.country_detail_qvguo)
    ImageTxtView countryDetailQvguo;
    @Bind(R.id.country_detail_detailtxt)
    TextView countryDetailDetailtxt;
    @Bind(R.id.country_detail_information)
    TextView countryDetailInformation;
    @Bind(R.id.country_detail_gridtxt)
    TextView countryDetailGridtxt;
    @Bind(R.id.country_detail_gridview)
    GridViewForScrollView countryDetailGridview;
    @Bind(R.id.country_detail_listtxt)
    TextView countryDetailListtxt;
    @Bind(R.id.country_detail_listview)
    ListViewForScrollView countryDetailListview;
    private TabPresenter tabPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = (int) bundle.get("countryid");
        tabPresenter = new TabPresenterImpl(this);
        tabPresenter.getCountryDetail(id + "");
    }

    @Override
    public void countrydelSuccess(CountryResponseEntity entity) {
        countryDetailCnname.setText(entity.getData().getCnname());
        countryDetailEnname.setText(entity.getData().getEnname());
        countryDetailDetailtxt.setText(entity.getData().getEntryCont());
        CountryDetailListAdapter listadapter = new CountryDetailListAdapter(this, entity.getData().getNew_discount());
        countryDetailListview.setAdapter(listadapter);
        CountryDetailGridAdapter gridadapter = new CountryDetailGridAdapter(this, entity.getData().getHot_city());
        countryDetailGridview.setAdapter(gridadapter);
    }

    @Override
    public void fail(Throwable t) {

    }
}
