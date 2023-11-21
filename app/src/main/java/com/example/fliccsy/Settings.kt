package com.example.fliccsy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.sharp.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class AppSettings {


    private val backgroundColor = Color(35, 34, 34)
    private val grayColor = Color(0xFF929090)
    private val redColor = Color(0xFFE50914)

    @Composable
    fun build() {
        var checked by remember { mutableStateOf(true) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.size(40.dp))
                Text(
                    text = "App Settings",
                    Modifier
                        .scale(2f)
                        .padding(top = 20.dp, bottom = 90.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

                Box(
                    modifier = Modifier
                        .background(backgroundColor, shape = RoundedCornerShape(10.0.dp))
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            Icons.Default.PlayArrow,
                            //painter = painterResource(id = R.drawable.ic_play_video),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.scale(2.0F),
                        )
                        //Box(modifier = Modifier.size(width = 40.dp, height = 0.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Video Quality",
                                modifier = Modifier.scale(1.2f),
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                            )
                            Text(
                                text = "Standard Quality",
                                modifier = Modifier.scale(1.0f),
                                //fontWeight = FontWeight.Bold,
                                color = grayColor,
                            )
                        }
                        Icon(
                            Icons.Default.ArrowForward,
                            //painter = painterResource(id = R.drawable.ic_play_video),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.scale(1.5F),
                        )
                    }

                }

                Box(modifier = Modifier.size(width = 0.dp, height = 40.dp))

                Box(
                    modifier = Modifier
                        .background(backgroundColor, shape = RoundedCornerShape(10.0.dp))
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            Icons.Default.Face,
                            //painter = painterResource(id = R.drawable.ic_play_video),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.scale(2.0F),
                        )
                        //Box(modifier = Modifier.size(width = 40.dp, height = 0.dp))

                        Text(
                            text = "Pal Suggestions",
                            modifier = Modifier.scale(1.2f),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )

                        Switch(
                            checked = checked,
                            onCheckedChange = {
                                checked = it
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = redColor,
                            )
                        )
                    }

                }


                Box(modifier = Modifier.size(width = 0.dp, height = 40.dp))

                Box(
                    modifier = Modifier
                        .background(backgroundColor, shape = RoundedCornerShape(10.0.dp))
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            Icons.Default.ArrowDropDown,
                            //painter = painterResource(id = R.drawable.ic_play_video),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.scale(2.0F),
                        )
                        //Box(modifier = Modifier.size(width = 40.dp, height = 0.dp))

                        Text(
                            text = "Downloads",
                            modifier = Modifier.scale(1.2f),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                        Icon(
                            Icons.Default.ArrowForward,
                            //painter = painterResource(id = R.drawable.ic_play_video),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.scale(1.5F),
                        )
                    }
                }

                Box(modifier = Modifier.size(width = 0.dp, height = 40.dp))

                Box(
                    modifier = Modifier
                        .background(backgroundColor, shape = RoundedCornerShape(10.0.dp))
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            Icons.Sharp.Clear,
                            //painter = painterResource(id = R.drawable.ic_play_video),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.scale(2.0F),
                        )
                        //Box(modifier = Modifier.size(width = 40.dp, height = 0.dp))

                        Text(
                            text = "Clear History",
                            modifier = Modifier.scale(1.2f),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                        Box(modifier = Modifier)

                    }
                }
            }
        }
    }

}