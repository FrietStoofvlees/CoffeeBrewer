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

object Profile : CoffeeBrewerDestination {
    override val icon = Icons.Default.AccountCircle
    override val route = "profile"
}

object SignIn : CoffeeBrewerDestination {
    override val icon = Icons.Default.AccountCircle
    override val route = "sign in"
}

object SignUp : CoffeeBrewerDestination {
    override val icon = Icons.Default.AccountCircle
    override val route = "sign up"
}

val tabRowScreens = listOf(Home, Profile, SignIn)