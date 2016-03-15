package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;

import java.util.List;

/**
 * Created by xiaohan-lh on 16/3/15.
 */
public class ListViewForScrollViewAdapter extends BaseAdapter {
    private Context context;
    private List<HotListRecommendEntity> hotListRecommendEntities;

    public ListViewForScrollViewAdapter(Context context, List<HotListRecommendEntity> hotListRecommendEntities) {
        this.context = context;
        this.hotListRecommendEntities = hotListRecommendEntities;
    }

    @Override
    public int getCount() {
        return hotListRecommendEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return hotListRecommendEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
//            convertView = LayoutInflater.from(context).inflate()
        }
        return null;
    }
    private static class ViewHolder{

        public ViewHolder() {
        }
    }
}
