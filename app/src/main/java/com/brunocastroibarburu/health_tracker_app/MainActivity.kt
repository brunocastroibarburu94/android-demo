package com.brunocastroibarburu.health_tracker_app
//import com.brunocastroibarburu.health_tracker_app.R
// Fragment Framework
import android.os.Bundle
//import android.view.Menu
//import com.google.android.material.snackbar.Snackbar
//import com.google.android.material.navigation.NavigationView
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.appcompat.app.AppCompatActivity
//import com.example.health_tracker_app.databinding.ActivityMainBinding

// Compose Framework
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.navigation.compose.rememberNavController

//@Composable
//fun MyScreen(onNavigate: (Int) -> Unit) {
//    Button(onClick = { onNavigate(R.id.nav_profile) } { /* ... */ }
//}
@Composable
fun MainPage(){
    val navController = rememberNavController()
    Text(text = "Hi ${R.id.nav_home}")

}
//class MainActivity : AppCompatActivity() { //
class MainActivity : ComponentActivity(){

//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Super init to os.Bundle parent
//        val navController = rememberNavController()
        val topModifier = Modifier.fillMaxWidth()
        setContent{
        MainPage()
        //            Text(text = "Hi ${R.id.nav_home}")
        }
        // Bindings to Activity Main
        //     binding = ActivityMainBinding.inflate(layoutInflater)
        //     setContentView(binding.root)
        //
        //        setSupportActionBar(binding.appBarMain.toolbar)
        //
        //        binding.appBarMain.fab.setOnClickListener { view ->
        //            Snackbar.make(view, "Replace with your own action!!!", Snackbar.LENGTH_LONG)
        //                    .setAction("Action", null).show()
        //        }
        //        val drawerLayout: DrawerLayout = binding.drawerLayout
        //        val navView: NavigationView = binding.navView
        //        val navController = findNavController(R.id.nav_host_fragment_content_main)
        //        // Passing each menu ID as a set of Ids because each
        //        // menu should be considered as top level destinations.
        //        appBarConfiguration = AppBarConfiguration(setOf(
        //            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        //        setupActionBarWithNavController(navController, appBarConfiguration) // Add navigation bar
        //        navView.setupWithNavController(navController) // Allows for page navigation
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
}