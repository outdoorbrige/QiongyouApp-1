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
 * Created by Administrator on 2016/3/17.
 */
public class CityDetailGridAdapter extends BaseAdapter {
    private Context context;
    private List<CountryDiscountEntity> list;

    public CityDetailGridAdapter(Context context, List<CountryDiscountEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.sale_grid_recommend, parent, false);
            vh =new ViewHolder(convertView);
            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        vh.saleImage.setImageURI(Uri.parse(list.get(position).getPhoto()));
        vh.saleTitleTxt.setText(list.get(position).getTitle());
        vh.saleDiscountTxt.setText(list.get(position).getPriceoff());
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(list.get(position).getPrice());
        String string = matcher.replaceAll("");
        vh.salePriceTxt.setText(string);
        return convertView;
    }

     class ViewHolder {
        @Bind(R.id.sale_image)
        SimpleDraweeView saleImage;
        @Bind(R.id.sale_title_txt)
        TextView saleTitleTxt;
        @Bind(R.id.yuan_txt)
        TextView yuanTxt;
        @Bind(R.id.sale_price_txt)
        TextView salePriceTxt;
        @Bind(R.id.sale_discount_txt)
        TextView saleDiscountTxt;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
