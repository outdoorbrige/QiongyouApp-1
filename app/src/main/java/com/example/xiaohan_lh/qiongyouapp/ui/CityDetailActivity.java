package com.example.xiaohan_lh.qiongyouapp.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.CityDetailGridAdapter;
import com.example.xiaohan_lh.qiongyouapp.adapter.CountryDetailListAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.CityDetailEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.CityDetailResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.customize.GridViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.ImageTxtView;
import com.example.xiaohan_lh.qiongyouapp.customize.ListViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.utils.Viewpages;
import com.example.xiaohan_lh.qiongyouapp.view.CityDetailView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CityDetailActivity extends AppCompatActivity implements CityDetailView {

    @Bind(R.id.country_detail_viewpage)
    ConvenientBanner countryDetailViewpage;
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
    @Bind(R.id.city_detail_scroll)
    ScrollView cityDetailScroll;
    @Bind(R.id.city_detail_toolbar)
    Toolbar cityDetailToolbar;
    @Bind(R.id.country_detail_wantgo)
    Button countryDetailWantgo;
    @Bind(R.id.country_detail_friends)
    RadioButton countryDetailFriends;
    @Bind(R.id.country_detail_ask)
    RadioButton countryDetailAsk;
    private TabPresenter presenter;
    private CityDetailResponseEntity cityEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);
        ButterKnife.bind(this);
        setSupportActionBar(cityDetailToolbar);
        initData();

    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String id = (String) bundle.get("cityid");
        presenter = new TabPresenterImpl(this);
        presenter.getCityDetail(id);
        if (Build.VERSION.SDK_INT >= 23) {
            cityDetailScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    int viewheight = countryDetailViewpage.getHeight();
                    if (oldScrollY < viewheight) {
                        if (scrollY < viewheight) {
//                        countryDetailToolbar.setAlpha(scrollY * 1.0f / viewheight);
                            float f = scrollY * 1.0f / viewheight;
                            cityDetailToolbar.setBackgroundColor(Color.argb((int) (f * 255), 21, 181, 89));
                            cityDetailToolbar.setTitleTextColor(Color.argb((int) (f * 255), 255, 255, 255));
                            cityDetailToolbar.setSubtitleTextColor(Color.argb((int) (f * 255), 255, 255, 255));
                        }
                    } else {
                        cityDetailToolbar.setBackgroundColor(Color.argb(255, 21, 181, 89));
                        cityDetailToolbar.setTitleTextColor(Color.argb(255, 255, 255, 255));
                        cityDetailToolbar.setSubtitleTextColor(Color.argb(255, 255, 255, 255));
                    }
                }
            });
        }
    }


    @Override
    public void citydelSuccess(CityDetailResponseEntity entity) {
        cityEntity = entity;
        countryDetailInformation.setText("城市实用信息>");
        countryDetailDetailtxt.setText(entity.getData().getEntryCont());
        countryDetailCnname.setText(entity.getData().getCnname());
        countryDetailEnname.setText(entity.getData().getEnname());
        CityDetailGridAdapter gridaapter = new CityDetailGridAdapter(this, entity.getData().getLocal_discount());
        countryDetailGridview.setAdapter(gridaapter);
        CountryDetailListAdapter listadapter = new CountryDetailListAdapter(this, entity.getData().getNew_discount());
        countryDetailListview.setAdapter(listadapter);
        Viewpages.initView(entity.getData().getPhotos(), countryDetailViewpage);
        initToolbar();

    }

    private void initToolbar() {
        cityDetailToolbar.setNavigationIcon(R.mipmap.ic_back_white);
        cityDetailToolbar.setTitle(cityEntity.getData().getCnname());
        cityDetailToolbar.setSubtitle(cityEntity.getData().getEnname());
        cityDetailToolbar.setTitleTextColor(Color.argb(0, 255, 255, 255));
        cityDetailToolbar.setSubtitleTextColor(Color.argb(0, 255, 255, 255));
        cityDetailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void fail(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
