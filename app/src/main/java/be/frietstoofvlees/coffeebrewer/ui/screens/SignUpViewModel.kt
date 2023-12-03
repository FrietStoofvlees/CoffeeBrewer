package be.frietstoofvlees.coffeebrewer.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpViewModel : ViewModel() {
    private var email: String by mutableStateOf("")
    private var password: String by mutableStateOf("")

    var signUpInProgress = mutableStateOf(false)

    fun emailChanged(newEmail: String) {
        email = newEmail
    }

    fun passwordChanged(newPassword: String) {
        password = newPassword
    }

    private fun createUserInFirebase(email: String, password: String) {
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = Firebase.auth.currentUser
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", it.exception)
                }
            }
            .addOnFailureListener {
                Log.e(TAG, "Creating user failed", it)
            }
    }

    fun signUp() {
        createUserInFirebase(email, password)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SignUpViewModel()
            }
        }
    }
}
