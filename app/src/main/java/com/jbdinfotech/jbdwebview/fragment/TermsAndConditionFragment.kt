package com.jbdinfotech.jbdwebview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.jbdinfotech.jbdwebview.R


class TermsAndConditionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_terms_and_condition, container, false)
        initAllControls(view)
        return view;
    }

    fun initAllControls(view: View)
    {
        val webView=view.findViewById<WebView>(R.id.webView);
        webView.loadUrl("file:///android_asset/terms_condition.html");
    }


}