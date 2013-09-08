package com.example.sm_webapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
public class MainActivity extends Activity {
private WebView mWebView;
 
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getWindow().requestFeature(Window.FEATURE_NO_TITLE);
	mWebView = new WebView(this);
	mWebView.loadUrl("http://app.speed-mandarin.com");
	WebSettings webSettings = mWebView.getSettings();
	mWebView.setHorizontalScrollBarEnabled(false);
	webSettings.setJavaScriptEnabled(true);
	
	mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
	mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER);
	
	mWebView.setWebViewClient(new WebViewClient() {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
	view.loadUrl(url);
	
	
	return true;
}
});
 
this.setContentView(mWebView);
}
 
@Override
public boolean onKeyDown(final int keyCode, final KeyEvent event) {
	if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
	mWebView.goBack();
	return true;
}
return super.onKeyDown(keyCode, event);
}
}
