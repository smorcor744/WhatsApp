package com.example.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import com.example.whatsapp.ui.theme.WhatsAppGreen
import com.example.whatsapp.ui.theme.WhatsAppDarkGray
import com.example.whatsapp.ui.theme.WhatsAppBackgroundGray
import com.example.whatsapp.ui.theme.WhatsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val appName = stringResource(id = R.string.app_name)

    val names = mutableListOf(
        stringResource(id = R.string.first_name),
        stringResource(id = R.string.second_name),
        stringResource(id = R.string.tercero_name),
        stringResource(id = R.string.cuarto_name),
        stringResource(id = R.string.quinto_name)
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(WhatsAppDarkGray)
                .padding(16.dp),
        ) {
            Text(
                text = appName,
                color = WhatsAppGreen,
                modifier = Modifier.weight(1f),
            )

            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call Icon",
                modifier = Modifier.size(24.dp),
                tint = WhatsAppGreen
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(24.dp),
                tint = WhatsAppGreen
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "MoreVert Icon",
                modifier = Modifier.size(24.dp),
                tint = WhatsAppGreen
            )
        }

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(WhatsAppBackgroundGray)) {
            items(names) { name ->
                Contacto(name = name)
            }
        }
    }
}

@Composable
fun Contacto(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Contact icon",
            modifier = Modifier.size(40.dp),
            tint = WhatsAppDarkGray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = name,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppTheme {
        Greeting()
    }
}
