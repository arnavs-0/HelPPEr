package com.arnav.covid_19hackathonapp.create;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.arnav.covid_19hackathonapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class FacemaskCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facemask_create);
        WebView webView = findViewById(R.id.facemask_create);

        webView.setWebViewClient(new FacemaskCreate.MyWebViewClient());
        String url = "https://www.chop.edu/how-make-homemade-diy-face-mask";
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
