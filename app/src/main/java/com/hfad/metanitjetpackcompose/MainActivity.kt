package com.hfad.metanitjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@Composable
fun Main() {
    // Контроллер навигации - управление стеком навигации
    val navController = rememberNavController()

    Column(
        modifier = Modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NavHost(navController, startDestination = NavRouters.Home.route) {
            composable(NavRouters.Home.route) { Home() }
            composable(NavRouters.About.route) { About() }
            composable(NavRouters.Contacts.route) { Contacts() }
        }

        Box() {
            BottomNavigationBar(navController = navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        // Идентификация текущего маршрута
        val backStaticEntry by navController.currentBackStackEntryAsState();
        val currentRouters = backStaticEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRouters == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image, contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )
        }
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Contacts",
            image = Icons.Filled.Face,
            route = "contacts"
        ),
        BarItem(
            title = "About",
            image = Icons.Filled.Info,
            route = "about"
        )
    )
}

data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)

@Composable
fun Home() {
    Text("Home Page", fontSize = 30.sp)
}

@Composable
fun Contacts() {
    Text("Contacts Page", fontSize = 30.sp)
}

@Composable
fun About() {
    Text("About Page", fontSize = 30.sp)
}

sealed class NavRouters(val route: String) {
    object Home: NavRouters("home")
    object Contacts: NavRouters("contacts")
    object About: NavRouters("about")
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun GreetingPreview() {
    Main()
}