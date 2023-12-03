package com.example.fliccsy

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home2(
    navController: NavHostController
){
    val images = listOf(
        R.drawable.aladin,
        R.drawable.littlemermaid,
        R.drawable.lionking,
        // Add more image resources as needed
    )
    Scaffold (
        modifier = Modifier.background(Color(0xFF0C0C0C)),
    ){
        Row {
            Text(
                text = "For Rick",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Box{
                Row {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "Icon",
                        tint = Color.White)
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "Icon",
                        tint = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (horizontalArrangement = Arrangement.SpaceBetween){
            OutlinedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent,)) {
                Text("Tv Shows",color = Color.White)
            }
            OutlinedButton(onClick = { }) {
                Text("Movies", color = Color.White)
            }
            OutlinedButton(onClick = { }) {
                Text("Categories",color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .height(415.dp)
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.background)
                .border(1.dp, Color.White, MaterialTheme.shapes.medium)
        ){
            Image(
                painter = painterResource(id = R.drawable.mrrobot),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(415.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
            )
            Column {
                Row {
                    Text("Drama",color = Color.White)
                    Text("Psychological thriller",color = Color.White)
                    Text("Techno-thriller",color = Color.White)
                }
                Row {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp)
                    ){
                        Icon(imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Icon")
                        Text(
                            text = "Play",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9D9D9)),
                        shape = RoundedCornerShape(8.dp)
                    ){
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "Icon")
                        Text(
                            text = "Sign up",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Upcoming")
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(images) { imageResource ->
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(105.dp)
                        .height(140.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .padding(4.dp)
                )
            }
        }

    }
}