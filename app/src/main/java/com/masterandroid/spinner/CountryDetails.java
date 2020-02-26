package com.masterandroid.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.PipedReader;

public class CountryDetails extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private WebView webView;
    private Bundle extra;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        mContext = CountryDetails.this;

        webView = findViewById(R.id.simpleWebViewId);
        extra = getIntent().getExtras();


        textView = findViewById(R.id.CountryTextId);
        imageView = findViewById(R.id.CountryImageId);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            textView.setText(bundle.getString("titles"));
            imageView.setImageResource(bundle.getInt("flags"));
        }

        if(extra != null){
            String data = extra.getString("details");
            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl(url);

            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(false);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }
    }
}
