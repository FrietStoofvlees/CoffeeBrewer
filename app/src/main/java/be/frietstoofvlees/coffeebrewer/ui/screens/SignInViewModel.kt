package be.frietstoofvlees.coffeebrewer.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.frietstoofvlees.coffeebrewer.CoffeeBrewerApplication
import be.frietstoofvlees.coffeebrewer.data.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignInViewModel(private val userRepository: UserRepository) : ViewModel() {
    private var email: String by mutableStateOf("")
    private var password: String by mutableStateOf("")

    var authenticationInProgress = mutableStateOf(false)

    fun emailChanged(newEmail: String) {
        email = newEmail
    }

    fun passwordChanged(newPassword: String) {
        password = newPassword
    }

    fun signIn(callback: (Boolean) -> Unit) {
        authenticationInProgress.value = true

        val email = email
        val password = password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    authenticationInProgress.value = false
                    Log.d(TAG, "${it.isSuccessful}")
                    callback(true)
                }
            }
            .addOnFailureListener {
                Log.e(TAG, "Authentication failed", it)
                callback(false)
            }
    }

    private fun signOut() {
        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = AuthStateListener {
            if(it.currentUser == null) {
                TODO("navigate to signInScreen")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }

    //https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository#5
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CoffeeBrewerApplication)
                val userRepository = application.container.userRepository
                SignInViewModel(userRepository = userRepository)
            }
        }
    }
}
