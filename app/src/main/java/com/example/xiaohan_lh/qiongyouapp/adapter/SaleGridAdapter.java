package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohan-lh on 16/3/15.
 */
public class SaleGridAdapter extends BaseAdapter {
    private List<TabRecommendEntity.DataEntity.DiscountEntity> discountEntities;
    private Context context;

    public SaleGridAdapter(List<TabRecommendEntity.DataEntity.DiscountEntity> discountEntities, Context context) {
        this.discountEntities = discountEntities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return discountEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return discountEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.sale_grid_recommend, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TabRecommendEntity.DataEntity.DiscountEntity discountEntity = discountEntities.get(position);
        viewHolder.saleImage.setImageURI(Uri.parse(discountEntity.getPhoto()));
        viewHolder.saleTitleTxt.setText(discountEntity.getTitle());
        viewHolder.saleDiscountTxt.setText(discountEntity.getPriceoff());
        viewHolder.salePriceTxt.setText(discountEntity.getPrice());

        return null;
    }

    static class ViewHolder {
        @Bind(R.id.sale_image)
        SimpleDraweeView saleImage;
        @Bind(R.id.sale_title_txt)
        TextView saleTitleTxt;
        @Bind(R.id.sale_discount_txt)
        TextView saleDiscountTxt;
        @Bind(R.id.sale_price_txt)
        TextView salePriceTxt;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
