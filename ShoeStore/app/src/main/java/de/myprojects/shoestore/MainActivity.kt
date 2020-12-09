package de.myprojects.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import de.myprojects.shoestore.databinding.ActivityMainBinding
import de.myprojects.shoestore.databinding.FragmentHomeBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
