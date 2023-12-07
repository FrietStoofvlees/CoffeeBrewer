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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.frietstoofvlees.coffeebrewer.R
import be.frietstoofvlees.coffeebrewer.ui.components.FieldComponent

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel(factory = ProfileViewModel.Factory), onSignOutSuccessFull: () -> Unit = {}) {
    LaunchedEffect(key1 = viewModel.userEmail) {
        if (viewModel.userEmail == null) {
            onSignOutSuccessFull()
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        FieldComponent(
            textValue = viewModel.userEmail ?: "",
            labelValue = stringResource(R.string.email),
            icon = Icons.Outlined.Email,
            enabled = false)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (viewModel.signOut()) {
                    onSignOutSuccessFull()
                } else {
                    //TODO show toast
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
            Text(text = stringResource(R.string.sign_out))
        }
        if (viewModel.authenticationInProgress.value) {
            CircularProgressIndicator()
        }
    }
}