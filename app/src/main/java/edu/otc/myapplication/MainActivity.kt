package edu.otc.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}


@Composable
fun MainScreen() {

    var count by remember { mutableStateOf(0) }
    var selectedScreen by remember { mutableStateOf("dtails")}

    fun updateCount(newCount: Int) {
        count = newCount
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (selectedScreen == "home")
        {
            CounterScreen(count, ::updateCount)
        } else {
            DetailsScreen(count)
        }

        Button(onClick = { selectedScreen = if(selectedScreen == "home") "details" else "home" }) {
            Text(text = if(selectedScreen == "home") "View Details" else "Go back")
        }

    }
}

@Composable
fun DetailsScreen(count: Int)
{
    Text(text = "Count is $count")
    if (count == 0)
    {
        Text(text = "The count is currently zero!", fontSize = 20.sp, color = Red)
    }
}

@Composable
fun CounterScreen(count: Int, onChange: (Int) -> Unit) {
    Text("Counter is $count")
    Button(onClick = { onChange(count + 1) }) {
        Text("Add A Click")
    }

    Button(onClick = { onChange(0) }) {
        Text(text = "Reset")
    }

}





