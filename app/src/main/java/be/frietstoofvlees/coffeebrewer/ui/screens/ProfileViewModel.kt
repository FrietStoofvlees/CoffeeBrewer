package be.frietstoofvlees.coffeebrewer.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel() : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val currentUser = firebaseAuth.currentUser

    val userEmail = currentUser?.email

    var authenticationInProgress = mutableStateOf(false)

    fun signOut(): Boolean {
        return try {
            firebaseAuth.signOut()
            true
        } catch (e: Exception) {
            //TODO Handle exception?
            false
        }
    }

    //https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository#5
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ProfileViewModel()
            }
        }
    }
}
