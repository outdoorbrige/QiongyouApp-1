package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.CountryDiscountEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/16.
 */
public class CountryDetailListAdapter extends BaseAdapter {
    private Context context;
    private List<CountryDiscountEntity> list;

    public CountryDetailListAdapter(Context context, List<CountryDiscountEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size() != 0 ? list.size() : 0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.country_detail_listitem, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        vh.countryDetailListItemSimview.setImageURI(Uri.parse(list.get(position).getPhoto()));
        vh.countryDetailListItemTitletxt.setText(list.get(position).getTitle());
        vh.countryDetailListItemDiscount.setText(list.get(position).getPriceoff());
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(list.get(position).getPrice());
        String string = matcher.replaceAll("");
        vh.countryDetailListItemPrivce.setText(string);
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.country_detail_list_item_simview)
        SimpleDraweeView countryDetailListItemSimview;
        @Bind(R.id.country_detail_list_item_titletxt)
        TextView countryDetailListItemTitletxt;
        @Bind(R.id.country_detail_list_item_discount)
        TextView countryDetailListItemDiscount;
        @Bind(R.id.country_detail_list_item_privce)
        TextView countryDetailListItemPrivce;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
