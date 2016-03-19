package com.example.xiaohan_lh.qiongyouapp.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.adapter.ListViewForScrollViewAdapter;
import com.example.xiaohan_lh.qiongyouapp.adapter.SaleGridAdapter;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.customize.BottomScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.GridViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.ImageTxtView;
import com.example.xiaohan_lh.qiongyouapp.customize.ListViewForScrollView;
import com.example.xiaohan_lh.qiongyouapp.customize.RefreshLayout;
import com.example.xiaohan_lh.qiongyouapp.presenter.impl.TabPresenterImpl;
import com.example.xiaohan_lh.qiongyouapp.ui.DiscountActivity;
import com.example.xiaohan_lh.qiongyouapp.ui.NextStationActivity;
import com.example.xiaohan_lh.qiongyouapp.ui.WebActivity;
import com.example.xiaohan_lh.qiongyouapp.utils.AppConnector;
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
    @Bind(R.id.bottom_img)
    ImageView bottomImg;
    @Bind(R.id.swipe_layout)
    RefreshLayout swipeLayout;
    @Bind(R.id.scroll_recommend)
    BottomScrollView scrollRecommend;
    @Bind(R.id.convenient_pager)
    ConvenientBanner convenientPager;
    @Bind(R.id.punchIn_btn)
    ImageButton punchInBtn;
    @Bind(R.id.bottom_layout)
    LinearLayout bottomLayout;
    private int page = 1;
    private List<HotListRecommendEntity.DataEntity> hotListdataEntities = new ArrayList<>();
    private ListViewForScrollViewAdapter listViewForScrollViewAdapter;
    private boolean isLoading = false;

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
        pullToTopRerefsh();
        init();
        return view;
    }

    private void init() {
        saleGrid.setFocusable(false);
        listLayout.setVisibility(View.GONE);
        AnimationDrawable animationDrawable = (AnimationDrawable) bottomImg.getDrawable();
        animationDrawable.start();
        nextStationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NextStationActivity.class);
                startActivity(intent);
            }
        });
        punchInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", AppConnector.Recommend.MILEAGE_RECOMMEDN);
                Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        saleItv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DiscountActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void RecommenndSueccess(final TabRecommendEntity tabRecommendEntity) {
        final List<TabRecommendEntity.DataEntity.SubjectEntity> nextStationContent = tabRecommendEntity.getData().getSubject();
        nextStationHead.setImageURI(Uri.parse(nextStationContent.get(0).getPhoto()));
        nextStationContentLeft.setImageURI(Uri.parse(nextStationContent.get(1).getPhoto()));
        nextStationContentRight.setImageURI(Uri.parse(nextStationContent.get(2).getPhoto()));
        initSetListener(nextStationContent.get(0), nextStationHead);
        initSetListener(nextStationContent.get(1), nextStationContentLeft);
        initSetListener(nextStationContent.get(2), nextStationContentRight);
        saleHeadImg.setImageURI(Uri.parse(tabRecommendEntity.getData().getDiscount_subject().get(0).getPhoto()));
        saleHeadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                TabRecommendEntity.DataEntity.DiscountSubjectEntity discountSubjectEntity = tabRecommendEntity.getData().getDiscount_subject().get(0);
                bundle.putString("url",discountSubjectEntity.getUrl());
                Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        SaleGridAdapter saleGridAdapter = new SaleGridAdapter(tabRecommendEntity.getData().getDiscount(), getContext());
        saleGrid.setAdapter(saleGridAdapter);
        listViewForScrollViewAdapter = new ListViewForScrollViewAdapter(getContext(), hotListdataEntities);
        listRecommendItem.setAdapter(listViewForScrollViewAdapter);
        scrollRecommend.setOnScrollToBottomLintener(new BottomScrollView.OnScrollToBottomListener() {
            @Override
            public void onScrollBottomListener(boolean isBottom) {
                pullToBottomRerefsh(isBottom);
            }
        });
        swipeLayout.setRefreshing(false);
        List<TabRecommendEntity.DataEntity.SlideEntity> slide = tabRecommendEntity.getData().getSlide();
        initConvenientPager(slide);
        saleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int discountId = tabRecommendEntity.getData().getDiscount().get(position).getId();
                Bundle bundle = new Bundle();
                bundle.putString("url","http://z.qyer.com/deal/"+discountId);
                Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
    }

    private void initSetListener(final TabRecommendEntity.DataEntity.SubjectEntity subjectEntity, View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", subjectEntity.getUrl());
                bundle.putString("title",subjectEntity.getTitle());
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }

    private void initConvenientPager(final List<TabRecommendEntity.DataEntity.SlideEntity> slide) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < slide.size(); i++) {
            list.add(slide.get(i).getPhoto());
        }
        convenientPager.setPages(new CBViewHolderCreator<LocalImageHolderView>() {

            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, list);
        convenientPager.setPageIndicator(new int[]{R.drawable.pager_flase, R.drawable.pager_true});
        convenientPager.startTurning(5000);
        convenientPager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url", slide.get(position).getUrl());
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }


    private void pullToTopRerefsh() {
        swipeLayout.setColorSchemeResources(R.color.green, R.color.orange, R.color.blue, R.color.cyan);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listLayout.setVisibility(View.GONE);
                new TabPresenterImpl(RecommendFragment.this).getRecommend();
            }
        });
    }

    //下拉加载
    private void pullToBottomRerefsh(boolean isBottom) {
        swipeLayout.setOnScrollToBottomListener(isLoading, isBottom, new RefreshLayout.OnScrollToBottomListener() {
            @Override
            public void scrollToBottom() {
                isLoading = true;
                if (page < 6) {
                    new TabPresenterImpl(RecommendFragment.this).getHotListRecommend(page + "");
                    page++;
                    if (page == 5 && bottomLayout.getVisibility() == View.VISIBLE) {
                        bottomLayout.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    @Override
    public void hotLiveViewSueccess(final HotListRecommendEntity hotListRecommendEntity) {
        final List<HotListRecommendEntity.DataEntity> dataEntities = hotListRecommendEntity.getData();
        hotListdataEntities.addAll(dataEntities);
        listViewForScrollViewAdapter.notifyDataSetChanged();
        if (listLayout.getVisibility() == View.GONE) {
            listLayout.setVisibility(View.VISIBLE);
        }
        isLoading = false;
        listRecommendItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("url",hotListdataEntities.get(position).getView_author_url());
                Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
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

    public class LocalImageHolderView implements Holder<String> {
        private SimpleDraweeView simpleDraweeView;

        @Override
        public View createView(Context context) {
            simpleDraweeView = new SimpleDraweeView(context);
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            return simpleDraweeView;
        }

        @Override
        public void UpdateUI(Context context, final int position, String data) {
            simpleDraweeView.setImageURI(Uri.parse(data));
        }
    }
}
