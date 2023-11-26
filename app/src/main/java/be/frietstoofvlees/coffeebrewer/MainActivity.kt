package be.frietstoofvlees.coffeebrewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import be.frietstoofvlees.coffeebrewer.ui.screens.HomeScreen
import be.frietstoofvlees.coffeebrewer.ui.screens.LoginViewModel
import be.frietstoofvlees.coffeebrewer.ui.screens.ProfileScreen
import be.frietstoofvlees.coffeebrewer.ui.theme.CoffeeBrewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeBrewerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val loginViewModel: LoginViewModel = viewModel(factory = LoginViewModel.Factory)
                    ProfileScreen(viewModel = loginViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeBrewerTheme {
        HomeScreen()
    }
}