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
import androidx.compose.foundation.layout.Arrangement // Required for "Arrangement.Centre"
//import androidx.compose.foundation.layout.Alignement.CenterHorizontally

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons

//  Requred for importing the icons using Icons.Filled.<IconName> and Icons.Outlined.<IconName>
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
// Reequired to use Material (Apparently its api changes so frequently that this is needed?)
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

// Required by line "bottomNavState by rememberSaveable"
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

//
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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

data class NavItemState (
    val title:String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasBadge: Boolean,
    val badgeNum : Int
)

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
            val items = listOf(
                NavItemState(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    hasBadge = false,
                    badgeNum=0
                ),
                NavItemState(
                    title = "Inbox",
                    selectedIcon = Icons.Filled.Email,
                    unselectedIcon = Icons.Outlined.Email,
                    hasBadge = true,
                    badgeNum=10
                ),
                NavItemState(
                    title = "Account",
                    selectedIcon = Icons.Filled.Face,
                    unselectedIcon = Icons.Outlined.Face,
                    hasBadge = true,
                    badgeNum=0
                ),
            )
            var bottomNavState by rememberSaveable { // Importable widget shows if one is in a composable function
                mutableStateOf(0)
            }
            Scaffold(
                topBar = {
                    TopAppBar(title = {Text(text = "Top bar")})
                },
                bottomBar = {
                    //BottomNavigation() // Custom Navigation declared outside
                    NavigationBar {
                        items.forEachIndexed{
                            index,item ->
                            NavigationBarItem(
                                selected = bottomNavState==index,
                                onClick={bottomNavState= index},
                                icon={
                                    BadgedBox(badge = {
                                        if(item.hasBadge) Badge{}
                                        if(item.badgeNum!=0) Badge{
                                            Text(text = item.badgeNum.toString())
                                        }
                                    }){
                                        Icon(
                                            imageVector = if (bottomNavState==index) item.selectedIcon else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                })
                        }
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                    }
                }
            ) { contentPadding ->
                Column(
                    modifier
                        .padding(contentPadding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text=items[bottomNavState].title,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize=44.sp
                    )
                }
            }
        }


}

//class MainActivity : AppCompatActivity() { //
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Super init to os.Bundle parent
        val topModifier = Modifier.fillMaxWidth()
        setContent{
        MainPage()
        }

    }

}