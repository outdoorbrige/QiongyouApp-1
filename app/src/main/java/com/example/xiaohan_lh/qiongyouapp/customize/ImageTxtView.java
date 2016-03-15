package com.example.xiaohan_lh.qiongyouapp.customize;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xiaohan_lh.qiongyouapp.R;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public class ImageTxtView extends RelativeLayout {
    public ImageTxtView(Context context) {
        super(context);
    }

    public ImageTxtView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public ImageTxtView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_txt_view, this, true);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.text);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageTxtView);
        int color = typedArray.getColor(R.styleable.ImageTxtView_image_txtColor, Color.GRAY);
        Drawable drawable = typedArray.getDrawable(R.styleable.ImageTxtView_image_src);
        CharSequence text = typedArray.getText(R.styleable.ImageTxtView_image_txt);
        float gap = typedArray.getDimension(R.styleable.ImageTxtView_image_gap, 20.0F);
        float txtSize = typedArray.getDimension(R.styleable.ImageTxtView_image_txtSize, 10.0F);
        imageView.setImageDrawable(drawable);
        textView.setText(text);
        textView.setTextColor(color);
        textView.setTextSize(txtSize);
        RelativeLayout.LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.setMargins(0, (int) gap,0,0);
    }



}
