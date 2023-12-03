@file:OptIn(ExperimentalMaterial3Api::class)

package be.frietstoofvlees.coffeebrewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.frietstoofvlees.coffeebrewer.ui.components.CoffeeBrewerTabRow
import be.frietstoofvlees.coffeebrewer.ui.screens.HomeScreen
import be.frietstoofvlees.coffeebrewer.ui.screens.SignInScreen
import be.frietstoofvlees.coffeebrewer.ui.theme.CoffeeBrewerTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            CoffeeBrewerApp()
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
    }
}

@Composable
fun CoffeeBrewerApp() {
    CoffeeBrewerTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        // Fetch your currentDestination:
        val currentDestination = currentBackStack?.destination
        // Change the variable to this and use Home as a backup screen if this returns null
        val currentScreen = tabRowScreens.find { it.route == currentDestination?.route } ?: Home

        Scaffold(
            topBar = {
                CoffeeBrewerTabRow(
                    allScreens = tabRowScreens,
                    onTabSelected = { newScreen ->
                        navController
                            .navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = Home.route) {
                    HomeScreen()
                }
                composable(route = SignIn.route) {
                    SignInScreen()
                }
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeBrewerApp()
}