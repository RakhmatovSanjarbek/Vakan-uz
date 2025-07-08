package sanjarbek.uz.vakanuz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import sanjarbek.uz.vakanuz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
        bottomNavVisibility(navHostFragment.navController)
    }

    private fun bottomNavVisibility(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isVisibleBottomNav = when (destination.id) {
                R.id.searchFragment,
                R.id.savedFragment,
                R.id.messagesFragment,
                R.id.usersFragment,
                -> true

                else -> false
            }
            binding.bottomNav.isVisible = isVisibleBottomNav
        }
    }
}
