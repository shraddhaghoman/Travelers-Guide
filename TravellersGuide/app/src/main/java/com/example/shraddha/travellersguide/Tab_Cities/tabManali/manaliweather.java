package com.example.shraddha.travellersguide.Tab_Cities.tabManali;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.shraddha.travellersguide.R;
public class manaliweather extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wea_man);
        webView = (WebView) findViewById(R.id.webviewman);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.co.in/search?ei=LW2vW96qAYntvASni4-gDQ&q=manali+weather&oq=manali+weather&gs_l=psy-ab.3..0i131i67k1l2j0l6j0i67k1l2.403751.405386.0.405744.7.7.0.0.0.0.321.997.0j6j0j1.7.0....0...1c.1.64.psy-ab..0.7.996...0i7i30k1.0.tTwLRrMoBPc");
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



