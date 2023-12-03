package com.example.fliccsy

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


class KeyPadActivity {

    private val redColor = Color(0xFFE50914)
    private val grayColor = Color(0xFF929090)
    private val containerColor = Color(0xFF232222)


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun keypadScreen(
        navController: NavHostController

    ) {
        var key by remember { mutableStateOf("") }

        val containerColors = TextFieldDefaults.textFieldColors(
            containerColor = containerColor,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = Color.White
        );
        val context = LocalContext.current;
        val textStyle = TextStyle(fontSize = TextUnit(18.0F, TextUnitType.Sp), fontWeight = FontWeight.Bold);
        val buttonModifier= Modifier.size(60.dp);



        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // poor man's spacer
                Box(modifier = Modifier.size(60.dp))

                Box(contentAlignment = Alignment.Center) {


                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Email",
                        modifier = Modifier
                            .rotate(45.0F)
                            .size(120.dp)
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        tint = redColor
                    )
                }
                Text(
                    text = "Confirm registration",
                    Modifier
                        .scale(2f)
                        .padding(top = 20.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = "Please enter the code sent to your email.",
                    Modifier
                        .scale(1.2f)
                        .padding(top = 30.dp), fontWeight = FontWeight.Bold,
                    color = grayColor
                )

                Row(
                    modifier = Modifier
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TextField(
                        colors = containerColors,
                        readOnly = true,
                        textStyle=textStyle,
                        value = (key.getOrNull(0) ?: "").toString(),

                        onValueChange = {},
                        modifier = Modifier.size(50.dp)
                    )
                    TextField(
                        colors = containerColors,
                        readOnly = true,
                        textStyle=textStyle,
                        value = (key.getOrNull(1) ?: "").toString(),
                        onValueChange = {},
                        modifier = Modifier.size(50.dp)
                    )
                    TextField(
                        readOnly = true,
                        colors = containerColors,
                        textStyle=textStyle,
                        value = (key.getOrNull(2) ?: "").toString(),
                        onValueChange = {},
                        modifier = Modifier.size(50.dp)
                    )
                    TextField(
                        readOnly = true,
                        colors = containerColors,
                        textStyle=textStyle,
                        value = (key.getOrNull(3) ?: "").toString(),
                        onValueChange = {},
                        modifier = Modifier.size(50.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 34.dp, vertical = 10.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    Row {
                        Text(text = "Didn't receive it? ", color = Color.White)

                        Text(text = "Resend", modifier = Modifier.clickable {
                            Toast.makeText(
                                context,
                                "Clicked resend",
                                Toast.LENGTH_SHORT
                            ).show();
                        }, color = redColor)
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 34.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            navController.navigate(AllRoutes.Profile.name)
                        },
                        shape = CutCornerShape(0),
                        colors = ButtonDefaults
                            .buttonColors(containerColor = redColor)
                    ) {

                        Text(text = "Verify", color = Color.White)
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp, horizontal = 60.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "1"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "1",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "2"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "2",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "3"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "3",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "4"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "4",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "5"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "5",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "6"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "6",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "7"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "7",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "8"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "8",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "9"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "9",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = buttonModifier,
                            onClick = {
                                key += "0"
                            },
                            shape = CutCornerShape(0),
                            colors = ButtonDefaults
                                .buttonColors(containerColor = containerColor)
                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "0",
                                    modifier = Modifier.scale(1.7F),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        Box(modifier = Modifier.size(width = 30.dp, height = 30.dp))

                        IconButton(
                            modifier = buttonModifier,
                            onClick = {
                                key = key.dropLast(1);
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = containerColor,
                                contentColor = Color.White
                            )

                        ) {

                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = null,
                                    tint = redColor,
                                    modifier = Modifier.size(50.dp)

                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

