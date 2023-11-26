package be.frietstoofvlees.coffeebrewer.data

interface AppContainer {
    val userRepository: UserRepository
}

class DefaultAppContainer : AppContainer {
    override val userRepository: UserRepository by lazy {
        InMemoryUserRepository()
    }
}