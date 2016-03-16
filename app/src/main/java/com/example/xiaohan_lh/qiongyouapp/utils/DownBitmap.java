package com.example.xiaohan_lh.qiongyouapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.graphics.Palette;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Administrator on 2016/3/15.
 */
public class DownBitmap {

    private Bitmap bitmap;
    private String url;
    private LinearLayout linearLayout;

    public DownBitmap(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            bitmap = (Bitmap) msg.obj;
            Palette palette = Palette.from(bitmap).generate();
            Palette.Swatch vibrantSwatch = palette.getMutedSwatch();
            if (vibrantSwatch != null) {
                linearLayout.setBackgroundColor(vibrantSwatch.getRgb());
            }
        }
    };

    public Bitmap getBitmap(final String urls, final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = Picasso.with(context).load(urls).get();
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = bitmap;
                    handler.sendMessage(msg);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
        return bitmap;

    }


}
