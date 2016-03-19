package com.example.xiaohan_lh.qiongyouapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.DiscountRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.view.DiscountView;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DiscountActivity extends AppCompatActivity implements DiscountView {
    @Bind(R.id.toolbar_discount)
    Toolbar toolbarDiscount;
    @Bind(R.id.discount_all)
    RadioButton discountAll;
    @Bind(R.id.discount_start)
    RadioButton discountStart;
    @Bind(R.id.discount_end)
    RadioButton discountEnd;
    @Bind(R.id.discount_time)
    RadioButton discountTime;
    @Bind(R.id.radio_discount)
    RadioGroup radioDiscount;
    @Bind(R.id.recycler_discount)
    RecyclerView recyclerDiscount;
    @Bind(R.id.content_discount_list)
    RelativeLayout contentDiscountList;
    private Map<String, String> map = new HashMap<>();
    private ListPopupWindow listPopupWindow;
    public static final int CALL_TYPE = 1;
    public static final int START_TYPE = 2;
    public static final int END_TYPE = 3;
    public static final int TIME_TYPE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarDiscount);
        map.put("client_id", "qyer_android");
        map.put("client_secret", "9fcaae8aefc4f9ac4915");
        map.put("v", "1");
        new TabPresenterImpl(this).getDiscountRecommend(map);
    }

    @Override
    public void discountSueccess(DiscountRecommendEntity discountRecommendEntity) {
        radioDiscount.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });


    }

    @Override
    public void fail(Throwable t) {
        Toast.makeText(this,"网络错误",Toast.LENGTH_SHORT).show();
    }
}
