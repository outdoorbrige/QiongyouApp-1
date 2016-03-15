package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.Country;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class DestinationListRecyAdapter extends RecyclerView.Adapter<DestinationListRecyAdapter.RecViewHolder> implements View.OnClickListener {

    private Context context;
    private List<Country> list;
    private RecyclerView recyclerView;
    private OnChildClickListener listener;
    private int tag;

    public DestinationListRecyAdapter(Context context, List<Country> list,int tag,OnChildClickListener listener) {
        this.context = context;
        this.list = list;
        this.tag = tag;
        this.listener=listener;
    }

    public void setListener(OnChildClickListener listener){
        this.listener = listener;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.destination_list_recy_item,parent,false);
        view.setOnClickListener(this);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {
        if(tag==1){
            holder.simpleDraweeView.setVisibility(View.GONE);
            holder.linearLayout.setVisibility(View.GONE);
        }else {
            holder.simpleDraweeView.setVisibility(View.VISIBLE);
            holder.linearLayout.setVisibility(View.VISIBLE);
        }
        holder.simpleDraweeView.setImageURI(Uri.parse(list.get(position).getPhoto()));
        holder.countTxt.setText(list.get(position).getCount()+"");
        holder.labelTxt.setText(list.get(position).getLabel());
        holder.cnnameTxt.setText(list.get(position).getCnname());
        holder.ennameTxt.setText(list.get(position).getEnname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            int position = recyclerView.getChildAdapterPosition(v);
            listener.onChildClick(v, position, list.get(position));
        }
    }

    public static class RecViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simpleDraweeView;
        private TextView countTxt,labelTxt,cnnameTxt,ennameTxt;
        private LinearLayout linearLayout;
        public RecViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.destina_list_recy_simview);
            countTxt = (TextView) itemView.findViewById(R.id.destina_list_recy_count);
            labelTxt = (TextView) itemView.findViewById(R.id.destina_list_recy_label);
            cnnameTxt = (TextView) itemView.findViewById(R.id.destina_list_recy_cnname);
            ennameTxt = (TextView) itemView.findViewById(R.id.destina_list_recy_enname);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.destina_list_recy_linear);
        }
    }
    public interface OnChildClickListener {
        void onChildClick(View child, int position, Country itemEntity);
    }
}
