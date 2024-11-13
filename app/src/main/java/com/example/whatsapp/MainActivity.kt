package com.example.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.sp
import com.example.whatsapp.ui.theme.WhatsAppGreen
import com.example.whatsapp.ui.theme.WhatsAppDarkGray
import com.example.whatsapp.ui.theme.WhatsAppBackgroundGray
import com.example.whatsapp.ui.theme.WhatsAppTheme
import kotlin.random.Random


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
        stringResource(id = R.string.first_name_1),
        stringResource(id = R.string.second_name_1),
        stringResource(id = R.string.tercero_name_1),
        stringResource(id = R.string.cuarto_name_1),
        stringResource(id = R.string.quinto_name_1),
        stringResource(id = R.string.first_name_2),
        stringResource(id = R.string.second_name_2),
        stringResource(id = R.string.tercero_name_2),
        stringResource(id = R.string.cuarto_name_2),
        stringResource(id = R.string.quinto_name_2),
        stringResource(id = R.string.first_name_3),
        stringResource(id = R.string.second_name_3),
        stringResource(id = R.string.tercero_name_3),
        stringResource(id = R.string.cuarto_name_3),
        stringResource(id = R.string.quinto_name_3),
        stringResource(id = R.string.first_name_4),
        stringResource(id = R.string.second_name_4),
        stringResource(id = R.string.tercero_name_4),
        stringResource(id = R.string.cuarto_name_4),
        stringResource(id = R.string.quinto_name_4)
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = appName,
                color = WhatsAppGreen,
                modifier = Modifier.weight(1f),
                fontSize = 25.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            )
            {

                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call Icon",
                    modifier = Modifier.size(25.dp),
                    tint = WhatsAppGreen
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(25.dp),
                    tint = WhatsAppGreen
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "MoreVert Icon",
                    modifier = Modifier.size(25.dp),
                    tint = WhatsAppGreen
                )
            }
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

fun hora(): String {
    var hora1 = Random.nextInt(0,24)
    var hora2 = Random.nextInt(0,60)
    if (hora1 < 10 && hora2 < 10) {return "0$hora1:0$hora2"}
    if (hora1 < 10 && hora2 >= 10) {return "0$hora1:$hora2"}
    if (hora1 > 10 && hora2 < 10) {return "$hora1:0$hora2"}
    else return "$hora1:$hora2"

}

@Composable
fun Contacto(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(top = 2.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Contact icon",
            modifier = Modifier.size(40.dp),
            tint = WhatsAppDarkGray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = name,
            color = Color.Black,
            fontSize = 18.sp

        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = hora(),
            color = Color.Black,
            fontSize = 14.sp,

        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppTheme {
        Greeting()
    }
}
