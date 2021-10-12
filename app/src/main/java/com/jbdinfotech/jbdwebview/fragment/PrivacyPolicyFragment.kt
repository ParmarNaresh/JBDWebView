package com.jbdinfotech.jbdwebview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.jbdinfotech.jbdwebview.utility.ConstantFile.Companion.PRIVACY_POLICY_FILE_PATH
import com.jbdinfotech.jbdwebview.R


class PrivacyPolicyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_privacy_policy, container, false)
        initAllControls(view)
        return view
    }

    private fun initAllControls(view: View)
    {
        val webView=view.findViewById<WebView>(R.id.webView)
        webView.loadUrl(PRIVACY_POLICY_FILE_PATH)
    }

}