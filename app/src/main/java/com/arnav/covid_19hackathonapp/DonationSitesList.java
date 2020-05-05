package com.arnav.covid_19hackathonapp;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class DonationSitesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_sites_list);
        WebView webView = findViewById(R.id.donation_map);

        webView.setWebViewClient(new MyWebViewClient());
        String url = "https://findthemasks.com/give.html";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
