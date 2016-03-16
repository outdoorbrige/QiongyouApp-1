package com.example.xiaohan_lh.qiongyouapp.customize;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * 继承自SwipeRefreshLayout,从而实现滑动到底部时上拉加载更多的功能.
 *
 * @author mrsimple
 */
public class RefreshLayout extends SwipeRefreshLayout {
    private boolean isLoading;
    private boolean isBottom;
    private OnScrollToBottomListener onScrollToBottomListener;

    /**
     * 滑动到最下面时的上拉操作
     */

    private int mTouchSlop;
    /**
     * 按下时的y坐标
     */
    private int mYDown;
    /**
     * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
     */
    private int mLastY;

    public RefreshLayout(Context context) {
        super(context);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 按下
                mYDown = (int) event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                // 移动
                mLastY = (int) event.getRawY();
                break;

            case MotionEvent.ACTION_UP:
                // 抬起
                if (canLoad()) {
                    onScrollToBottomListener.scrollToBottom();
                }
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    /**
     * 是否可以加载更多, 条件是到了最底部, listview不在加载中, 且为上拉操作.
     */
    private boolean canLoad() {
        return isBottom && !isLoading && isPullUp() && onScrollToBottomListener != null;
    }

//    /**
//     * 判断是否到了最底部
//     */
//
//    @Override
//    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
//        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
//        if (scrollY != 0) {
//            isBottom = clampedY;
//        }
//    }

    /**
     * 是否是上拉操作
     */
    private boolean isPullUp() {
        return (mYDown - mLastY) >= mTouchSlop;
    }

    public void setOnScrollToBottomListener(boolean isLoading ,boolean isBottom, OnScrollToBottomListener onScrollToBottomListener) {
        this.isBottom = isBottom;
        this.isLoading = isLoading;
        this.onScrollToBottomListener = onScrollToBottomListener;

    }

    public interface OnScrollToBottomListener {
        public void scrollToBottom();
    }
}

//    public void setLoading(boolean loading) {
//        isLoading = loading;
//        if (isLoading) {
//            mListView.addFooterView(mListViewFooter);
//        } else {
//            mListView.removeFooterView(mListViewFooter);
//            mYDown = 0;
//            mLastY = 0;
//        }
//    }
//    public void setOnLoadListener(OnLoadListener loadListener) {
//        mOnLoadListener = loadListener;
//    }
//
//    @Override
//    public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//    }
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
//                         int totalItemCount) {
//        // 滚动时到了最底部也可以加载更多
//        if (canLoad()) {
//            loadData();
//        }
//    }

