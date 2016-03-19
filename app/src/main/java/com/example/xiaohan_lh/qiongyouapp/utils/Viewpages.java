package com.example.xiaohan_lh.qiongyouapp.utils;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
public class Viewpages {


    public static void initView(List<String> list, ConvenientBanner convenientBanner) {
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        },list);
        convenientBanner.startTurning(5000);
    }

    static class LocalImageHolderView implements Holder<String> {
        private SimpleDraweeView simpleDraweeView;

        @Override
        public View createView(Context context) {
            simpleDraweeView = new SimpleDraweeView(context);
            simpleDraweeView.setScaleType(SimpleDraweeView.ScaleType.FIT_XY);
            return simpleDraweeView;
        }

        @Override
        public void UpdateUI(Context context, final int position, String data) {
            simpleDraweeView.setImageURI(Uri.parse(data));
        }
    }
}
