package com.example.studentsproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    Boolean on = true;
    WebView navegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        // Cas inicial
        navegador = (WebView) findViewById(R.id.webView);
        navegador.setWebViewClient(new WebViewClient());
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.loadUrl("https://elpais.com/");
        on = false;
    }

    public void switchWebView(View view) {
        if (on) {
            navegador.loadUrl("https://elpais.com/");
            on = false;
        }
        else {
            navegador.loadUrl("https://eldiario.es/");
            on = true;
        }

    }
}
