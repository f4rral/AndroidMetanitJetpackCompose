package com.hfad.metanitjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

    Column(Modifier.padding(8.dp).fillMaxSize()) {
        NavBar(navController = navController)

        // Host навигации - это специальный компонент, который добавляется в макет пользовательского
        // интерфейса действия и служит заполнителем для страниц, по которым будет
        // перемещаться пользователь
        NavHost(navController, startDestination = NavRouters.Home.route) {
            composable(NavRouters.Home.route) { Home() }
            composable(NavRouters.About.route) { About() }
            composable(NavRouters.Contacts.route) { Contacts() }
        }
    }
}

@Composable
fun NavBar(navController: NavController) {
    Row(
        Modifier.fillMaxWidth().padding(bottom = 8.dp)
    ) {
        Text("Home",
            Modifier
                .weight(0.33f)
                .clickable {
                    navController.navigate(NavRouters.Home.route)
                },
            fontSize = 22.sp, color = Color(0xFF6650a4)
        )
        Text("Contacts",
            Modifier
                .weight(0.33f)
                .clickable {
                    navController.navigate(NavRouters.Contacts.route)
                },
            fontSize = 22.sp, color = Color(0xFF6650a4)
        )
        Text("About",
            Modifier
                .weight(0.33f)
                .clickable {
                    navController.navigate(NavRouters.About.route)
                },
            fontSize = 22.sp, color = Color(0xFF6650a4)
        )
    }
}

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