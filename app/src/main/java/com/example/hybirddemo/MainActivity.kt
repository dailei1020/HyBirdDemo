package com.example.hybirddemo

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRootWebView: WebView
    private lateinit var webSettings: WebSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRootWebView = rootWebView
        initWebSettings()
        setJsEnable(webSettings)
        setZoom()

//        mRootWebView.loadUrl("https://www.baidu.com")
        //加载本地网页
        mRootWebView.loadUrl("file:///android_asset/index.html")
        callListener()

    }

    private fun callListener() {
        mRootWebView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }


        mRootWebView.webChromeClient = object : WebChromeClient() {
            //获取网页进度
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }

            //获取网页title
            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
            }
        }
    }


    private fun setZoom() {

        //设置支持缩放
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = true
    }

    private fun initWebSettings() {
        webSettings = mRootWebView.settings
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setJsEnable(webSettings: WebSettings) {
        webSettings.javaScriptEnabled = true
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