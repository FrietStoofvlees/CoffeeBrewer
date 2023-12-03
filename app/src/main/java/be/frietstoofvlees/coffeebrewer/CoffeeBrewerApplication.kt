package be.frietstoofvlees.coffeebrewer

import android.app.Application
import be.frietstoofvlees.coffeebrewer.data.AppContainer
import be.frietstoofvlees.coffeebrewer.data.DefaultAppContainer
import com.google.firebase.FirebaseApp

class CoffeeBrewerApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()

        FirebaseApp.initializeApp(this)
    }
}