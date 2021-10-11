package com.jbdinfotech.jbdwebview.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.jbdinfotech.jbdwebview.R


class MailUsFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mail_us, container, false)
        initAllControls(view)
        return view;
    }
    fun initAllControls(view:View)
    {
        val btnMailNow=view.findViewById<Button>(R.id.btnMailNow)
        btnMailNow.setOnClickListener({
            sendMail()
        })
    }

    fun sendMail()
    {
        val intent= Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, "parmarnaresh108@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Write Subject here");
        intent.putExtra(Intent.EXTRA_TEXT, "Write message here");

//need this to prompts email client only
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }


}