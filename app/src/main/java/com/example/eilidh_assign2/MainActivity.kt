/*
*   Eilidh Macsymic
*   SODV3203 Assignment 2
*   Create an Art Space App
*
*   Reference links:
*   https://developer.android.com/develop/ui/compose/graphics/images/customize
*/

package com.example.eilidh_assign2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eilidh_assign2.data.Datasource
import com.example.eilidh_assign2.ui.theme.Eilidh_assign2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Eilidh_assign2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtDisplay(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtDisplay(
    modifier: Modifier = Modifier
) {
    val artList = remember { Datasource().loadArtInfo()}
    var currentIndex by remember { mutableStateOf(0)}

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ){
        val currentArt = artList[currentIndex]

        Image(
            painter = painterResource(currentArt.artImageResId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.width(350.dp)
                .height(400.dp)
                .padding(10.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(currentArt.nameResId),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
            Row(){
                Text(
                    text = stringResource(currentArt.artistResId) ,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 3.dp)
                )
                Text(
                    text = " - " , //created to separate the artist and year
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(currentArt.yearResId),
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 3.dp)
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 32.dp)
        ){
            Button(
                onClick = {
                    currentIndex = if (currentIndex > 0) {
                        currentIndex - 1
                    } else {
                        artList.size - 1
                    }
                },
                modifier = Modifier.padding(20.dp)
                    .size(130.dp, 36.dp)
            ){
                Text(
                    text = "Previous"
                )
            }
            Button(
                onClick = {
                    currentIndex = if (currentIndex < artList.size - 1) {
                        currentIndex + 1
                    } else {
                        0
                    }
                },
                modifier = Modifier.padding(20.dp)
                    .size(130.dp, 36.dp)
            ){
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Eilidh_assign2Theme {
        ArtDisplay()
    }
}