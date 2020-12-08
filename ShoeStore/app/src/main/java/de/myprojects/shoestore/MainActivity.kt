package de.myprojects.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        setupActionBarWithNavController()
    }

    private fun setupActionBarWithNavController() {
        val appBarConfiguration = AppBarConfiguration
                .Builder(R.id.homeFragment,R.id.welcomeFragment, R.id.loginFragment,  R.id.instructionFragment)
                .build()

        navController = this.findNavController(R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
