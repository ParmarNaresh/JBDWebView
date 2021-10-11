package com.jbdinfotech.jbdwebview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.jbdinfotech.jbdwebview.R

class AboutUsFrament : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_about_us_frament, container, false)
        initAllControls(view)
        return view;
        // Inflate the layout for this fragment
    }

    fun initAllControls(view:View)
    {
        val webView=view.findViewById<WebView>(R.id.webView);
        webView.loadUrl("file:///android_asset/about_us.html");
    }
}