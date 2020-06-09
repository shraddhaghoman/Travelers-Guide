package com.example.shraddha.travellersguide.Tab_Cities.Agra;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.shraddha.travellersguide.R;
public class agraweather extends Activity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wea_agra);
        webView = (WebView) findViewById(R.id.webviewagra);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.co.in/search?ei=FGivW4uZCszKvgTi25zICw&q=agra+weather&oq=agra+we&gs_l=psy-ab.3.0.0i67k1j0l2j0i67k1j0l3j0i67k1j0l2.11376.14987.0.16223.7.7.0.0.0.0.176.630.1j4.5.0....0...1c.1.64.psy-ab..2.5.630...0i131i67k1j0i131k1.0.H-tn-wqfsMI");
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

