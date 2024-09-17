package com.example.funfactsa2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactsa2.ui.theme.FunFactsA2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsA2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FunFactScreen(modifier: Modifier = Modifier) {
    // List of fun facts
    val funFacts = listOf(
        "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3000 years old!",
        "Bananas are berries, but strawberries aren't!",
        "A day on Venus is longer than a year on Venus!",
        "Octopuses have three hearts!",
        "You can't hum while holding your nose closed!"
    )

    // State to hold the current fact
    var currentFact by remember { mutableStateOf(funFacts.random()) }

    // Layout to center elements on the screen
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Display the current fun fact
            Text(
                text = currentFact,
                fontSize = 24.sp,
                color = Color.Blue,
                modifier = Modifier.padding(16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button to cycle to the next fact
            Button(
                onClick = {
                    // Get a new random fact
                    currentFact = funFacts[Random.nextInt(funFacts.size)]
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Next Fact")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactScreenPreview() {
    FunFactsA2Theme {
        FunFactScreen()
    }
}