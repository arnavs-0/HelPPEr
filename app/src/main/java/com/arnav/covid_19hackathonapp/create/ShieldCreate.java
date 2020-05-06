package com.arnav.covid_19hackathonapp.create;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.arnav.covid_19hackathonapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class ShieldCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shield_create);
        WebView webView = findViewById(R.id.faceshield_create);

        webView.setWebViewClient(new ShieldCreate.MyWebViewClient());
        String url = "https://specs.engin.umich.edu/um-face-shield/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
    //open link in app
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
