package be.frietstoofvlees.coffeebrewer

import android.app.Application
import be.frietstoofvlees.coffeebrewer.data.AppContainer
import be.frietstoofvlees.coffeebrewer.data.DefaultAppContainer

class CoffeeBrewerApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}