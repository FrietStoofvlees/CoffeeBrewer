package be.frietstoofvlees.coffeebrewer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

interface CoffeeBrewerDestination {
    val icon: ImageVector
    val route: String
}

object Home : CoffeeBrewerDestination {
    override val icon = Icons.Default.Home
    override val route = "home"
}

object Login : CoffeeBrewerDestination {
    override val icon = Icons.Default.AccountCircle
    override val route = "login"
}

val tabRowScreens = listOf(Home, Login)