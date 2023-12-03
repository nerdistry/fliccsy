package com.example.fliccsy

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController

){
    val images = listOf(
        R.drawable.aladin,
        R.drawable.littlemermaid,
        R.drawable.lionking,
        R.drawable.scream,
        // Add more image resources as needed
    )
    Scaffold (
        containerColor = Color(0xFF000000),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(50.dp),
                containerColor = Color(0xFF0C0C0C),
            ) {
                BottomNavigation(
                    backgroundColor = Color(0xFF0C0C0C)
                ) {
                    BottomNavigationItem(
                        selected = false,
                        onClick = { navController.navigate(AllRoutes.Home.name) },
                        icon = {
                            Icon(imageVector = Icons.Default.Home, contentDescription = null, tint = Color.White)
                        },
                        label = { Text("Home", fontSize = 10.sp, color = Color.White) },
                        alwaysShowLabel = true
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { navController.navigate(AllRoutes.Swiping.name) },
                        icon = {
                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null,tint = Color.White)
                        },
                        label = { Text("Swipe", fontSize = 10.sp, color = Color.White) },
                        alwaysShowLabel = true
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { navController.navigate(AllRoutes.Settings.name) },
                        icon = {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = null, tint = Color.White)
                        },
                        label = { Text("Settings", fontSize = 10.sp, color = Color.White) },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ){
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "For Rick",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp
                    )
                    Box{
                        Row {
                            Icon(imageVector = Icons.Default.Search,
                                contentDescription = "Icon",
                                tint = Color.White)
                            Spacer(modifier = Modifier.width(7.dp))
                            Icon(imageVector = Icons.Default.Notifications,
                                contentDescription = "Icon",
                                tint = Color.White)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(13.dp))
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
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
                Spacer(modifier = Modifier.height(13.dp))
                Box(
                    modifier = Modifier
                        .height(365.dp)
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.background)
                        .border(1.dp, Color.White, MaterialTheme.shapes.medium)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.mrrobot3),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(365.dp)
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                    )

                    Column (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Spacer(modifier = Modifier.height(200.dp))
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                        ){
                            Text("Drama",color = Color.White, fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(3.dp))
                            Separator()
                            Spacer(modifier = Modifier.width(3.dp))
                            Text("Psychological thriller",color = Color.White,fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(3.dp))
                            Separator()
                            Spacer(modifier = Modifier.width(3.dp))
                            Text("Techno-thriller",color = Color.White,fontSize = 13.sp)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                shape = RoundedCornerShape(8.dp)
                            ){
                                Icon(imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Icon",tint = Color.Black
                                )
                                Text(
                                    text = "Play",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(containerColor = Color(
                                    0xFFB6B5B5
                                )
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ){
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Icon")
                                Text(
                                    text = "My List",
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }

                }
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = "Upcoming", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(13.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    items(images) { imageResource ->
                        Box(
                            modifier = Modifier
                                .width(105.dp)
                                .height(140.dp)
                                .clip(MaterialTheme.shapes.medium)
                                .background(MaterialTheme.colorScheme.background)
                                .border(1.dp, Color.White, MaterialTheme.shapes.medium)
                        ){
                            Image(
                                painter = painterResource(id = imageResource),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(105.dp)
                                    .height(140.dp)
                                    .clip(MaterialTheme.shapes.medium)
                            )

                        }
                        Spacer(modifier = Modifier.width(15.dp))
                    }
                }
            }
        }

    }

}

@Composable
fun Separator() {
    Box(
        modifier = Modifier
            .size(4.dp)
            .background(Color(0xFFE50914), CircleShape)
    )
}

