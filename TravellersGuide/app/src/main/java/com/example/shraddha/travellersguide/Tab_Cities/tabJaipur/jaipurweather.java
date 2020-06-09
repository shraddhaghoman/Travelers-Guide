package com.example.shraddha.travellersguide.Tab_Cities.tabJaipur;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.shraddha.travellersguide.R;
public class jaipurweather extends Activity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wea_jaip);
        webView = (WebView) findViewById(R.id.webviewjai);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.co.in/search?ei=oWqvW-ziHMzIvgTLi7uYCQ&q=jaipur+weather&oq=jaipur+weather&gs_l=psy-ab.3..0i67k1j0l7j0i67k1l2.15863.19686.0.22133.7.7.0.0.0.0.140.789.1j6.7.0....0...1c.1.64.psy-ab..0.7.786...0i7i30k1j0i131i67k1.0.S0qZA5v-9hA");
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
