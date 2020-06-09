package com.example.shraddha.travellersguide.Tab_Cities.tabMumbai;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.shraddha.travellersguide.R;
public class mumbaiweather extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wea_mum);
        webView = (WebView) findViewById(R.id.webviewmum);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.co.in/search?ei=w26vW6WXK8vxvgThkIWgBQ&q=mumbai+weather&oq=mumbai+weather&gs_l=psy-ab.3..0i67k1j0l9.17176.19079.0.19408.8.8.0.0.0.0.138.769.0j6.6.0....0...1c.1.64.psy-ab..2.6.767...0i7i30k1j0i131i67k1.0.fONbuxjzqpU");
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
