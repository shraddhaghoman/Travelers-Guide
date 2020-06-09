package com.example.shraddha.travellersguide.Tab_Cities.tabGoa;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.shraddha.travellersguide.R;
public class goaweather extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wea_goa);
        webView = (WebView) findViewById(R.id.webviewgoa);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.co.in/search?ei=9m6vW9f5A8vMvgTSkKbABw&q=goa+weather&oq=goa+w&gs_l=psy-ab.3.0.0i67k1j0l3j0i67k1j0l5.20333.21578.0.23046.5.5.0.0.0.0.199.647.0j5.5.0....0...1c.1.64.psy-ab..0.5.646...0i131i67k1j0i131k1.0.Z7zofw5F6i4");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}