package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.SaleGridAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.customize.GridViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.ImageTxtView;
import com.example.xiaohan_lh.qiongyouapp.customize.ListViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.view.HotListView;
import com.example.xiaohan_lh.qiongyouapp.view.RecommendView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment implements RecommendView, HotListView {

    @Bind(R.id.ad_viewPager)
    ViewPager adViewPager;
    @Bind(R.id.pack_itv)
    ImageTxtView packItv;
    @Bind(R.id.sale_itv)
    ImageTxtView saleItv;
    @Bind(R.id.hotel_itv)
    ImageTxtView hotelItv;
    @Bind(R.id.travel_itv)
    ImageTxtView travelItv;
    @Bind(R.id.next_station_head)
    SimpleDraweeView nextStationHead;
    @Bind(R.id.next_station_content_left)
    SimpleDraweeView nextStationContentLeft;
    @Bind(R.id.next_station_content_right)
    SimpleDraweeView nextStationContentRight;
    @Bind(R.id.next_station_btn)
    Button nextStationBtn;
    @Bind(R.id.sale_head_img)
    SimpleDraweeView saleHeadImg;
    @Bind(R.id.list_recommend_item)
    ListViewForScrollView listRecommendItem;
    @Bind(R.id.sale_grid)
    GridViewForScrollView saleGrid;
    @Bind(R.id.scroll_recommend)
    ScrollView scrollRecommend;

    public static RecommendFragment newInstance() {
        Bundle args = new Bundle();
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new TabPresenterImpl(this).getRecommend();
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        listRecommendItem.setVisibility(View.GONE);
    }

    @Override
    public void RecommenndSueccess(TabRecommendEntity tabRecommendEntity) {
        List<TabRecommendEntity.DataEntity.SubjectEntity> nextStationContent = tabRecommendEntity.getData().getSubject();
        nextStationHead.setImageURI(Uri.parse(nextStationContent.get(0).getPhoto()));
        nextStationContentLeft.setImageURI(Uri.parse(nextStationContent.get(1).getPhoto()));
        nextStationContentRight.setImageURI(Uri.parse(nextStationContent.get(2).getPhoto()));
        saleHeadImg.setImageURI(Uri.parse(tabRecommendEntity.getData().getDiscount_subject().get(0).getPhoto()));
        SaleGridAdapter saleGridAdapter = new SaleGridAdapter(tabRecommendEntity.getData().getDiscount(), getContext());
        saleGrid.setAdapter(saleGridAdapter);

    }

    @Override
    public void hotLiveViewSueccess(HotListRecommendEntity hotListRecommendEntity) {

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
