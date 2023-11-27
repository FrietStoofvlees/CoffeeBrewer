package be.frietstoofvlees.coffeebrewer.ui.screens

import android.widget.TextClock
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import be.frietstoofvlees.coffeebrewer.R

@Composable
fun HomeScreen() {
     Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayClock()

        Image(
            painter = painterResource(id = R.drawable.icons8_coffee),
            contentDescription = "coffee icon",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Time to Brew!",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { /* Handle button click */ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .width(200.dp)
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
            Text("Start Brewing")
        }
    }
}

@Composable
fun DisplayClock() {
    var color: Int = MaterialTheme.colorScheme.onBackground.toArgb()
    
    AndroidView(
        factory = { context ->
            TextClock(context).apply {
                format24Hour?.let {this.format24Hour = "HH:mm:ss"}
                timeZone?.let { this.timeZone = it }
                textSize.let { this.textSize = 30f }

                setTextColor(color)
            }
        },
        modifier = Modifier.padding(bottom = 16.dp)
    )
}
