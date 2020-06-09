package com.example.shraddha.travellersguide.Tab_Cities.tabDehli;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.shraddha.travellersguide.R;
public class delhiweather extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wea_del);
        webView = (WebView) findViewById(R.id.webviewdel);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.co.in/search?ei=JWivW8X0FKGavQSv4ay4Dg&q=delhi+weather&oq=delhi+weather&gs_l=psy-ab.3..0i67k1j0l2j0i67k1l3j0l4.613160.617512.0.617876.11.9.1.0.0.0.233.1127.0j7j1.8.0....0...1c.1.64.psy-ab..2.9.1132...0i7i30k1j0i131i67k1.0.w85Uswe3qhM");
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
