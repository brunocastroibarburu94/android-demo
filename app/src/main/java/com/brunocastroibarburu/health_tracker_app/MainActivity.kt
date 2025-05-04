@file:OptIn(ExperimentalMaterial3Api::class)

package com.brunocastroibarburu.health_tracker_app
//import com.brunocastroibarburu.health_tracker_app.R
// Fragment Framework
import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.navigation.compose.rememberNavController
import com.brunocastroibarburu.health_tracker_app.ui.theme.HealthTrackerApplicationTheme
import com.brunocastroibarburu.health_tracker_app.ui.theme.*

//@Composable
//fun MyScreen(onNavigate: (Int) -> Unit) {
//    Button(onClick = { onNavigate(R.id.nav_profile) } { /* ... */ }
//}
sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.ic_menu_camera
        )

    object List :
        BottomNavItem(
            "List",
            R.drawable.ic_menu_gallery
        )

    object Analytics :
        BottomNavItem(
            "Analytics",
            R.drawable.ic_menu_slideshow
        )

//    object Profile :
//        BottomNavItem(
//            "Profile",
//            R.drawable.baseline_person_24
//        )
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {
    NavigationBarItem(
        // Text that shows bellow the icon
        label = {
            Text(text = screen.title)
        },

        // The icon resource
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },

        // Display if the icon it is select or not
        selected = true,

        // Always show the label bellow the icon or not
        alwaysShowLabel = true,

        // Click listener for the icon
        onClick = {
            print(screen.icon)
//            pageId= screen.icon
        },

        // Control all the colors of the icon
//        colors = NavigationBarItemDefaults.colors()
    )
}
@Composable
fun BottomNavigation() {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.List,
        BottomNavItem.Analytics,
//        BottomNavItem.Profile
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item
            )
        }
    }
}

@Composable
fun SecondaryPage(){} // TODO: Create secondary page to toggle to

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(modifier:Modifier = Modifier){
//    var pageId = 1
//    if(pageId==1) {
        HealthTrackerApplicationTheme {
//            val navController = rememberNavController()
//            Row(){}
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = GreenLight//MaterialTheme.colorScheme.background
//            ) {
//                Text(text = "Hi ${R.id.nav_home}")
//           6}

            Scaffold(
                topBar = {
                    TopAppBar(title = {Text(text = "Top bar")})
                },
                bottomBar = {
                    BottomNavigation()
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                    }
                }
            ) { contentPadding ->
                Column(modifier.padding(contentPadding)) {
                    //Column(modifie.padding(contentPadding)) {
                    Text(text="Hi")
                }
            }
        }
//    }


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