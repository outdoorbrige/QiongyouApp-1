package com.example.xiaohan_lh.qiongyouapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;
import com.example.xiaohan_lh.qiongyouapp.bean.DiscountRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.ui.DiscountActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohan-lh on 16/3/18.
 */
public class DiscountListAdapter extends BaseAdapter {
    private List<?> list;
    private Context context;
    private int type;

    public DiscountListAdapter(List<?> list, Context context, int type) {
        this.list = list;
        this.context = context;
        this.type = type;
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
        return type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ViewHoler viewHoler = null;
            String s = "";
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.discount_list_item, null);
            viewHoler = new ViewHoler(convertView);
            convertView.setTag(viewHoler);
        }else{
            viewHoler = (ViewHoler) convertView.getTag();
        }
        switch (type) {
            case DiscountActivity.CALL_TYPE:
                List<DiscountRecommendEntity.DataEntity.TypeEntity> typeEntitys = ((List<DiscountRecommendEntity.DataEntity.TypeEntity>) list);
                s = typeEntitys.get(position).getCatename();
                break;
            case DiscountActivity.START_TYPE:
                List<DiscountRecommendEntity.DataEntity.DepartureEntity> departureEntities = (List<DiscountRecommendEntity.DataEntity.DepartureEntity>) list;
                s = departureEntities.get(position).getCity_des();
                break;
            case DiscountActivity.END_TYPE:
                List<DiscountRecommendEntity.DataEntity.PoiEntity> poiEntities = (List<DiscountRecommendEntity.DataEntity.PoiEntity>) list;
                s = poiEntities.get(position).getContinent_name();
                break;
            case DiscountActivity.TIME_TYPE:
                List<DiscountRecommendEntity.DataEntity.TimesDrangeEntity> timesDrangeEntities = (List<DiscountRecommendEntity.DataEntity.TimesDrangeEntity>) this.list;
                s = timesDrangeEntities.get(position).getDescription();
                break;
        }
        viewHoler.discountListTxt.setText(s);
        return convertView;
    }

    static class ViewHoler {
        @Bind(R.id.discount_list_txt)
        TextView discountListTxt;

        public ViewHoler(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
