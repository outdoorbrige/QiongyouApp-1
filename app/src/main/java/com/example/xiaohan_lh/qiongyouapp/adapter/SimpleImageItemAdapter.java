package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.NextStationEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohan-lh on 16/3/17.
 */
public class SimpleImageItemAdapter extends RecyclerView.Adapter<SimpleImageItemAdapter.MyViewHolder> {
    private List<NextStationEntity.DataEntity> list;
    private Context context;

    public SimpleImageItemAdapter(List<NextStationEntity.DataEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.next_station_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NextStationEntity.DataEntity dataEntity = list.get(position);
        holder.nextItemImg.setImageURI(Uri.parse(dataEntity.getPhoto()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.next_item_img)
        SimpleDraweeView nextItemImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
