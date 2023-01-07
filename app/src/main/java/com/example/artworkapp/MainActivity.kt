package com.example.artworkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artworkapp.ui.theme.ArtWorkAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtWorkAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtWorkMain()
                }
            }
        }
    }
}

@Composable
fun ArtWorkMain() {

    var artNumber by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
        ) {
            when (artNumber) {
                1 -> ArtWork(
                    artImageResource = R.drawable.art1,
                    artTitle = "Art of the ocean",
                    artDescription = "stained art"
                )
                2 -> ArtWork(
                    artImageResource = R.drawable.art2,
                    artTitle = "Splash Red",
                    artDescription = "A red image that looks like rose"
                )
                3 -> ArtWork(
                    artImageResource = R.drawable.art3,
                    artTitle = "Eiffel Tower",
                    artDescription = "Who would have thought that the Eiffel can be son nice"
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = { artNumber-- }) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = {
                if (artNumber < 3) {
                    artNumber++
                }
            }) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ArtWork(
    artImageResource: Int,
    artTitle: String,
    artDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.height(400.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                elevation = 10.dp,
                //modifier = Modifier.wrapContentSize()
            ) {
                Image(
                    painter = painterResource(id = artImageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF000000),
                            shape = RectangleShape
                        )
                        .padding(30.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }


        Spacer(modifier = Modifier.height(40.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                elevation = 10.dp,
                modifier = Modifier.shadow(2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                ) {
                    Text(
                        text = artTitle,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(10)
                    )
                    Text(
                        text = artDescription,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtWorkAppTheme {
        ArtWorkMain()
    }
}