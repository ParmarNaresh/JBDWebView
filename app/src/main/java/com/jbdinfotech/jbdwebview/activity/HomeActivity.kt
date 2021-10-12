package com.jbdinfotech.jbdwebview.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.jbdinfotech.jbdwebview.utility.ConstantFile
import com.jbdinfotech.jbdwebview.utility.IOnBackPressed
import com.jbdinfotech.jbdwebview.R
import com.jbdinfotech.jbdwebview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)

        binding.appBarHome.fab.setOnClickListener {
            startDailPad()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_privacy_policy,
                R.id.nav_terms_conditions,
                R.id.nav_about_us,
                R.id.nav_mail_us
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        val navControllers =
            this.supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_home)
        val label = navControllers?.findNavController()?.currentDestination?.label
        if (label?.equals("Home") == true) {
            val activityShouldFinish = (navControllers.childFragmentManager.fragments[0] as IOnBackPressed).onBackPressed()
            if (activityShouldFinish) super.onBackPressed()
        } else {
            navControllers?.findNavController()?.navigate(R.id.nav_home)
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun startDailPad() {
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        intent.data = Uri.parse("tel:" + ConstantFile.TELEPHONE_NUMBER)
        startActivity(intent)
    }
}