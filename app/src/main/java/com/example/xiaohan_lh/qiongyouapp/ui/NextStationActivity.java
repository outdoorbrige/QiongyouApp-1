package com.example.xiaohan_lh.qiongyouapp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.SimpleImageItemAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.NextStationEntity;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.view.NextStationView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NextStationActivity extends AppCompatActivity implements NextStationView {
    @Bind(R.id.recycler_next)
    RecyclerView recyclerNext;
    private int page = 1;
    @Bind(R.id.toolbar_nextTitle)
    Toolbar toolbarNextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_station);
        ButterKnife.bind(this);
        toolbarNextTitle.setNavigationIcon(R.mipmap.ic_back_white);
        toolbarNextTitle.setTitle("专题列表");
        toolbarNextTitle.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbarNextTitle);
        new TabPresenterImpl(this).getNextstation(page + "");
        page++;
    }

    @Override
    public void NextStationSueccess(NextStationEntity nextStationEntity) {
        List<NextStationEntity.DataEntity> dataEntities = nextStationEntity.getData();
        SimpleImageItemAdapter simpleImageItemAdapter = new SimpleImageItemAdapter(dataEntities, this);
        recyclerNext.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerNext.setAdapter(simpleImageItemAdapter);
    }

    @Override
    public void fail(Throwable t) {
        Toast.makeText(this, "网络问题", Toast.LENGTH_SHORT).show();
    }
}
