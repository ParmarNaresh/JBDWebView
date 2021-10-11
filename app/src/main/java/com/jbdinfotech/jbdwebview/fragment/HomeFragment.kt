package com.jbdinfotech.jbdwebview.fragment

import android.app.Activity
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
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jbdinfotech.jbdwebview.ConstantFile
import com.jbdinfotech.jbdwebview.R
import com.jbdinfotech.jbdwebview.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var progress: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initAllControls(view)
        return view;
    }

    fun initAllControls(view: View) {
        val webView = view.findViewById<WebView>(R.id.webView);
        progress = view.findViewById<ProgressBar>(R.id.progressBar);
        val setting = webView.settings
        setting.javaScriptEnabled = true
        setting.allowFileAccess = true
        setting.loadsImagesAutomatically = true
        webView.webViewClient = MyWebViewClient(progress);
        webView.loadUrl(ConstantFile.WEBSITE_URL)

    }

    class MyWebViewClient(val progress: ProgressBar) : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progress.setVisibility(View.VISIBLE);
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progress.setVisibility(View.GONE);

        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url: String = request?.url.toString();
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


}