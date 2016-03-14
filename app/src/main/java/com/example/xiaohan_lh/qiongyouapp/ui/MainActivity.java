package com.example.xiaohan_lh.qiongyouapp.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.TabPagerAdapter;
import com.example.xiaohan_lh.qiongyouapp.fragment.CommunityFragment;
import com.example.xiaohan_lh.qiongyouapp.fragment.DestinationFragment;
import com.example.xiaohan_lh.qiongyouapp.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.user_btn)
    ImageView userBtn;
    @Bind(R.id.search_btn)
    ImageView searchBtn;
    @Bind(R.id.tab_pager)
    ViewPager tabPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        fragments.add(RecommendFragment.newInstance());
        fragments.add(DestinationFragment.newInstance());
        fragments.add(CommunityFragment.newInstance());
        titles.add("推荐");
        titles.add("目的地");
        titles.add("社区");
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), titles, fragments);
        tabPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(tabPager);
    }

}
