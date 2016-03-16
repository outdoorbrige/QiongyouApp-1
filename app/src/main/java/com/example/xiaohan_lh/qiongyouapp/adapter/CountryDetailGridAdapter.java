package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.CountryCityEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/16.
 */
public class CountryDetailGridAdapter extends BaseAdapter {

    private Context context;
    private List<CountryCityEntity> list;

    public CountryDetailGridAdapter(Context context, List<CountryCityEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.country_detail_griditem, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }
        vh= (ViewHolder) convertView.getTag();
        vh.countryDetailGridItemSimview.setImageURI(Uri.parse(list.get(position).getPhoto()));
        vh.countryDetailGridItemCnname.setText(list.get(position).getCnname());
        vh.countryDetailGrirItemEnname.setText(list.get(position).getEnname());
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.country_detail_grid_item_simview)
        SimpleDraweeView countryDetailGridItemSimview;
        @Bind(R.id.country_detail_grid_item_cnname)
        TextView countryDetailGridItemCnname;
        @Bind(R.id.country_detail_grir_item_enname)
        TextView countryDetailGrirItemEnname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
