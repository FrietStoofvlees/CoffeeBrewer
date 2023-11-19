package be.frietstoofvlees.coffeebrewer.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.frietstoofvlees.coffeebrewer.R
import be.frietstoofvlees.coffeebrewer.ui.components.InputFieldComponent

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        InputFieldComponent(labelValue = stringResource(R.string.email),
            icon = Icons.Outlined.Email)
        Spacer(modifier = Modifier.height(10.dp))
        InputFieldComponent(labelValue = stringResource(R.string.password),
            icon = Icons.Outlined.Lock)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Log in")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileScreen()
}