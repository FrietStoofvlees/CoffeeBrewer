package be.frietstoofvlees.coffeebrewer.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.frietstoofvlees.coffeebrewer.CoffeeBrewerApplication
import be.frietstoofvlees.coffeebrewer.data.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private var email: String by mutableStateOf("")
    private var password: String by mutableStateOf("")

// TODO
//    fun setEmail(email: String) {
//        this.email = email
//    }
//    fun setPassword(password: String) {
//        this.password = password
//    }

    fun login() {
        viewModelScope.launch {
            val loginSuccessful = userRepository.login(email, password)
            // TODO
            if (loginSuccessful) {
            } else {
            }
        }
    }

    //https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository#5
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CoffeeBrewerApplication)
                val userRepository = application.container.userRepository
                LoginViewModel(userRepository = userRepository)
            }
        }
    }
}
