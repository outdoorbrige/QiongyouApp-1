package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.ListViewForScrollViewAdapter;
import com.example.xiaohan_lh.qiongyouapp.adapter.SaleGridAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.customize.BottomScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.GridViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.ImageTxtView;
import com.example.xiaohan_lh.qiongyouapp.customize.ListViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.view.HotListView;
import com.example.xiaohan_lh.qiongyouapp.view.RecommendView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
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
    @Bind(R.id.sale_grid)
    GridViewForScrollView saleGrid;
    @Bind(R.id.sale_btn)
    Button saleBtn;
    @Bind(R.id.list_recommend_item)
    ListViewForScrollView listRecommendItem;
    @Bind(R.id.linear_list)
    LinearLayout linearList;
    @Bind(R.id.card_list)
    CardView cardList;
    @Bind(R.id.list_layout)
    LinearLayout listLayout;
    @Bind(R.id.scroll_recommend)
    BottomScrollView scrollRecommend;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @Bind(R.id.bottom_img)
    ImageView bottomImg;
    private int page = 1;
    private List<HotListRecommendEntity.DataEntity> hotListdataEntities = new ArrayList<>();
    private ListViewForScrollViewAdapter listViewForScrollViewAdapter;

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
        listLayout.setVisibility(View.GONE);
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
        listViewForScrollViewAdapter = new ListViewForScrollViewAdapter(getContext(), hotListdataEntities);
        listRecommendItem.setAdapter(listViewForScrollViewAdapter);
        scrollRecommend.setOnScrollToBottomLintener(new BottomScrollView.OnScrollToBottomListener() {
            @Override
            public void onScrollBottomListener(boolean isBottom) {
                if (isBottom) {
                    if (page < 6) {
                        new TabPresenterImpl(RecommendFragment.this).getHotListRecommend(page + "");
                        page++;
                    } else {
                        if (bottomImg.getVisibility() == View.VISIBLE) {
                            bottomImg.setVisibility(View.GONE);
                        }
                    }

                }
            }
        });

    }

    @Override
    public void hotLiveViewSueccess(HotListRecommendEntity hotListRecommendEntity) {
        List<HotListRecommendEntity.DataEntity> dataEntities = hotListRecommendEntity.getData();
        hotListdataEntities.addAll(dataEntities);
        listViewForScrollViewAdapter.notifyDataSetChanged();
        listLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void fail(Throwable t) {
        Toast.makeText(getContext(), "网络错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
