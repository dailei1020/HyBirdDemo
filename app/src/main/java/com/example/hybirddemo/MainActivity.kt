package com.example.hybirddemo

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRootWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRootWebView = rootWebView
        mRootWebView.loadUrl("https://www.baidu.com")
        mRootWebView.webViewClient = WebViewClient()

        val webSettings:WebSettings = mRootWebView.settings
        //设置支持缩放
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = true

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mRootWebView.canGoBack()) {
                mRootWebView.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}