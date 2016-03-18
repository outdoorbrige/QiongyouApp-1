package com.example.xiaohan_lh.qiongyouapp.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.CountryDetailGridAdapter;
import com.example.xiaohan_lh.qiongyouapp.adapter.CountryDetailListAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.customize.GridViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.ImageTxtView;
import com.example.xiaohan_lh.qiongyouapp.customize.ListViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.utils.Viewpages;
import com.example.xiaohan_lh.qiongyouapp.view.CountryDetailView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CountryDetailActivity extends AppCompatActivity implements CountryDetailView {


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
    @Bind(R.id.country_detail_toolbar)
    Toolbar countryDetailToolbar;
    @Bind(R.id.country_detail_wantgo)
    Button countryDetailWantgo;
    @Bind(R.id.country_detail_friends)
    RadioButton countryDetailFriends;
    @Bind(R.id.country_detail_ask)
    RadioButton countryDetailAsk;
    @Bind(R.id.country_detail_scroll)
    ScrollView countryDetailScroll;
    @Bind(R.id.country_detail_viewpage)
    ConvenientBanner countryDetailViewpage;
    @Bind(R.id.country_detail_linear)
    LinearLayout countryDetailLinear;
    private TabPresenter tabPresenter;
    private CountryResponseEntity countryentity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        ButterKnife.bind(this);
        setSupportActionBar(countryDetailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initData() {
        countryDetailListview.setFocusable(false);
        countryDetailGridview.setFocusable(false);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = (int) bundle.get("countryid");
        tabPresenter = new TabPresenterImpl(this);
        tabPresenter.getCountryDetail(id + "");
        if(Build.VERSION.SDK_INT>=23){
        countryDetailScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int viewheight = countryDetailViewpage.getHeight();
                if (oldScrollY < viewheight) {
                    if (scrollY < viewheight) {
//                        countryDetailToolbar.setAlpha(scrollY * 1.0f / viewheight);
                        float f = scrollY*1.0f/viewheight;
                        countryDetailToolbar.setBackgroundColor(Color.argb((int)(f*255),21,181,89));
                        countryDetailToolbar.setTitleTextColor(Color.argb((int)(f*255),255,255,255));
                        countryDetailToolbar.setSubtitleTextColor(Color.argb((int)(f*255),255,255,255));
                    }
                } else {
                    countryDetailToolbar.setBackgroundColor(Color.argb(255,21,181,89));
                    countryDetailToolbar.setTitleTextColor(Color.argb(255,255,255,255));
                    countryDetailToolbar.setSubtitleTextColor(Color.argb(255,255,255,255));
                }
            }
        });}

        initListen();
    }

    private void initListen() {
        countryDetailGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(CountryDetailActivity.this,CityDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("cityid",countryentity.getData().getHot_city().get(position).getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void countrydelSuccess(CountryResponseEntity entity) {
        countryentity = entity;
        countryDetailCnname.setText(entity.getData().getCnname());
        countryDetailEnname.setText(entity.getData().getEnname());
        countryDetailDetailtxt.setText(entity.getData().getEntryCont());
        CountryDetailListAdapter listadapter = new CountryDetailListAdapter(this, entity.getData().getNew_discount());
        countryDetailListview.setAdapter(listadapter);
        CountryDetailGridAdapter gridadapter = new CountryDetailGridAdapter(this, entity.getData().getHot_city());
        countryDetailGridview.setAdapter(gridadapter);
        Viewpages.initView(entity.getData().getPhotos(),countryDetailViewpage);
        initToolbar();
    }

    private void initToolbar() {
        countryDetailToolbar.setNavigationIcon(R.mipmap.ic_back_white);
        countryDetailToolbar.setTitle(countryentity.getData().getCnname());
        countryDetailToolbar.setSubtitle(countryentity.getData().getEnname());
        countryDetailToolbar.setTitleTextColor(Color.argb(0,255,255,255));
        countryDetailToolbar.setSubtitleTextColor(Color.argb(0,255,255,255));
        countryDetailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
