package com.jbdinfotech.jbdwebview.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.jbdinfotech.jbdwebview.utility.ConstantFile
import com.jbdinfotech.jbdwebview.R


class MailUsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mail_us, container, false)
        initAllControls(view)
        return view
    }

    private fun initAllControls(view: View) {
        val btnMailNow = view.findViewById<Button>(R.id.btnMailNow)
        btnMailNow.setOnClickListener {
            sendMail()
        }
    }

    private fun sendMail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, ConstantFile.MAIL_ADDRESS)
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_message_for_mail))
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.write_message_for_mail))
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, getString(R.string.choose_email)))
    }


}