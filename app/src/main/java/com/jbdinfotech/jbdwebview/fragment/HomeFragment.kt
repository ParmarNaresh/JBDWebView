package com.jbdinfotech.jbdwebview.fragment

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.jbdinfotech.jbdwebview.utility.ConstantFile
import com.jbdinfotech.jbdwebview.utility.IOnBackPressed
import com.jbdinfotech.jbdwebview.R

class HomeFragment : Fragment(), IOnBackPressed {

    private lateinit var progress: ProgressBar
    private lateinit var webView: WebView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initAllControls(view)
        return view
    }

    private fun initAllControls(view: View) {
        view.findViewById<WebView>(R.id.webView).also { webView = it }
        view.findViewById<ProgressBar>(R.id.progressBar).also { progress = it }
        val setting = webView.settings
        setting.javaScriptEnabled = true
        setting.allowFileAccess = true
        setting.loadsImagesAutomatically = true
        webView.webViewClient = MyWebViewClient(progress)
        webView.loadUrl(ConstantFile.WEBSITE_URL)

    }

    class MyWebViewClient(private val progress: ProgressBar) : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progress.visibility = View.VISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progress.visibility = View.GONE

        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url: String = request?.url.toString()
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceError
        ) {

        }
    }

    override fun onBackPressed(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
            return false
        }
        return true


    }


}