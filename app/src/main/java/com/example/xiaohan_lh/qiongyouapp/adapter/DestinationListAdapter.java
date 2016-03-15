package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.Continent;

/**
 * Created by Administrator on 2016/3/14.
 */
public class DestinationListAdapter extends BaseExpandableListAdapter {
    private Continent continent;
    private Context context;
    private DestinationListRecyAdapter adapter;
    private GridLayoutManager layoutManager;
    private DestinationListRecyAdapter.OnChildClickListener listener;

    public DestinationListAdapter(Continent continent, Context context,DestinationListRecyAdapter.OnChildClickListener listener) {
        this.continent = continent;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public int getGroupCount() {
        return continent.getCountry().size()!=0?2:1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Object object ;
        if(groupPosition==0){
           object =  continent.getHot_country().get(childPosition);
        }else{
            object =  continent.getCountry().get(childPosition);
        }
        return object;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder vh;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.destination_list_item,parent,false);
            vh = new GroupViewHolder(convertView);
            convertView.setTag(vh);
        }
        vh = (GroupViewHolder) convertView.getTag();
        if(groupPosition==0){
        vh.textView.setText(continent.getCnname()+"热门目的地");
        }else{
            vh.textView.setText(continent.getCnname()+"其他目的地");
        }
        return convertView;
    }

    public class GroupViewHolder{
        private TextView textView;

        public GroupViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.destina_list_titletxt);
        }
    }



    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.destination_list_itemt,parent,false);
            viewHolder = new ChildViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ChildViewHolder) convertView.getTag();
        if(groupPosition==0){
        adapter = new DestinationListRecyAdapter(context,continent.getHot_country(),0,listener);
        }else{
            adapter = new DestinationListRecyAdapter(context,continent.getCountry(),1,listener);
        }
        layoutManager = new GridLayoutManager(context,2);
        viewHolder.recyclerView.setLayoutManager(layoutManager);
        viewHolder.recyclerView.setAdapter(adapter);
        return convertView;
    }

    public class ChildViewHolder{
        private RecyclerView recyclerView;

        public ChildViewHolder(View view) {
            recyclerView = (RecyclerView) view.findViewById(R.id.destina_list_item_recy);
        }
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
