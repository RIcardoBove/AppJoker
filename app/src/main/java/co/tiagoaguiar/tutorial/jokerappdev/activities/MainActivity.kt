package co.tiagoaguiar.tutorial.jokerappdev.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.presentetion.HomePresenter
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {

    installSplashScreen()

    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    var toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)

    val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
    val navView = findViewById<NavigationView>(R.id.nav_view)

    navController = findNavController(R.id.nav_host_fragment_content_main)

    appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.nav_home, R.id.nav_joker_day, R.id.nav_about
      ), drawerLayout
    )

    setupActionBarWithNavController(navController, appBarConfiguration)

    navView.setupWithNavController(navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
  }
}