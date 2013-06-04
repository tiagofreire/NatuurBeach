package br.gov.ce.semace.natuurbeach;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WebView wv = (WebView) findViewById(R.id.webview);
        
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        
        wv.setWebViewClient(new MyCustomWebViewClient());
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        
        
        wv.loadUrl(getResources().getString(R.string.url));
        
        createDialog(this);
    }
    
    private class MyCustomWebViewClient extends WebViewClient {
    	
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		view.loadUrl(url);
    		return true;
    	}
    }
    
    protected void createDialog(Context context) {
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle(R.string.title_dialog);
    	builder.setMessage(R.string.text_dialog);
    	builder.show();
    }
    
}