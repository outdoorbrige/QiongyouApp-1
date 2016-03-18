package com.example.xiaohan_lh.qiongyouapp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.xiaohan_lh.qiongyouapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {

    @Bind(R.id.web_view)
    WebView webView;
    @Bind(R.id.web_toolbar)
    Toolbar webToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        webToolbar.setTitle("专题");
        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                webToolbar.setTitle(title);
            }

        };
        webView.setWebChromeClient(wvcc);
        webView.getSettings().setJavaScriptEnabled(true);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        String url = bundle.getString("url");
        //String title = bundle.getString("title");
        webToolbar.setTitleTextColor(Color.WHITE);
        webView.loadUrl(url);
        webToolbar.setNavigationIcon(R.mipmap.ic_back_white);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        setSupportActionBar(webToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web,menu);
        return true;
    }
}
