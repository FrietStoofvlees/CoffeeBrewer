package be.frietstoofvlees.coffeebrewer.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.frietstoofvlees.coffeebrewer.R
import be.frietstoofvlees.coffeebrewer.ui.components.ClickableTextComponent
import be.frietstoofvlees.coffeebrewer.ui.components.InputFieldComponent

@Composable
    fun SignInScreen(viewModel: SignInViewModel = viewModel(factory = SignInViewModel.Factory), onNavigateToProfile: () -> Unit = {}, onNavigateToSignUp: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Welcome! Please sign in to continue.",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        InputFieldComponent(
            labelValue = stringResource(R.string.email),
            icon = Icons.Outlined.Email,
            onTextChanged = { viewModel.emailChanged(it) })
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldComponent(
            labelValue = stringResource(R.string.password),
            icon = Icons.Outlined.Lock,
            onTextChanged = { viewModel.passwordChanged(it) })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.signIn() { success ->
                    if (success) {
                        onNavigateToProfile()
                    } else {
                        //TODO show toast
                    }
                }
            },
            shape = RoundedCornerShape(3.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 6.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text = stringResource(R.string.sign_in))
        }
        Spacer(modifier = Modifier.height(16.dp))
        ClickableTextComponent(
            header = stringResource(id = R.string.sign_up_header),
            textValue = stringResource(id = R.string.sign_up),
            navigateTo = onNavigateToSignUp
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (viewModel.authenticationInProgress.value) {
            CircularProgressIndicator()
        }
    }
}