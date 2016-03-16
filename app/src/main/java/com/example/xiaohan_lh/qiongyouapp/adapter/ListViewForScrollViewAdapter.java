package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohan-lh on 16/3/15.
 */
public class ListViewForScrollViewAdapter extends BaseAdapter {
    private Context context;
    private List<HotListRecommendEntity.DataEntity> dataEntities;

    public ListViewForScrollViewAdapter(Context context, List<HotListRecommendEntity.DataEntity> dataEntities) {
        this.context = context;
        this.dataEntities = dataEntities;
    }

    @Override
    public int getCount() {
        return dataEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return dataEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item_recommend, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        convertView.setTag(convertView);
        HotListRecommendEntity.DataEntity dataEntity = dataEntities.get(position);
        viewHolder.listItemImg.setImageURI(Uri.parse(dataEntity.getPhoto()));
        viewHolder.itemTitleTxt.setText(dataEntity.getTitle());
        viewHolder.itemFromTxt.setText(dataEntity.getUsername());
        viewHolder.seeTxt.setText(dataEntity.getViews()+"");
        viewHolder.commentTxt.setText(dataEntity.getReplys());
        return convertView;
    }



    class ViewHolder {
        @Bind(R.id.list_item_img)
        SimpleDraweeView listItemImg;
        @Bind(R.id.item_title_txt)
        TextView itemTitleTxt;
        @Bind(R.id.item_from_txt)
        TextView itemFromTxt;
        @Bind(R.id.see_txt)
        TextView seeTxt;
        @Bind(R.id.comment_txt)
        TextView commentTxt;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
