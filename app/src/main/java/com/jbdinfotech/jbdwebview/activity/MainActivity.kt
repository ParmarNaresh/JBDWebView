package com.jbdinfotech.jbdwebview.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jbdinfotech.jbdwebview.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAllControls()
    }
    private fun initAllControls()
    {
        supportActionBar?.hide()
        Handler(Looper.myLooper()!!).postDelayed({ startNewActivity() },3000)
    }
    private fun startNewActivity()
    {
        val intent= Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}