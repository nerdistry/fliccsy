package com.example.fliccsy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignupScreen(){
    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 50.dp),
    ) {
        Text(
            text = "Sign Up",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Join the Movie Magic 🍿",
            color = Color(0xFF929090),
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Discover , Share and Enjoy the Best Films Together!",
            color = Color(0xFF929090),
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))
        FormTextField(value = "", error = "", placeholder = "Full Name", leadingIcon = Icons.Outlined.Person,
        )
        FormTextField(value = "", error = "", placeholder = "Email Address", leadingIcon = Icons.Outlined.Email,
        )
        FormTextField(value = "", error = "", placeholder = "Password", leadingIcon = Icons.Outlined.Lock,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE50914)),
            modifier = Modifier.size(width = 366.dp, height = 54.dp),
            shape = RoundedCornerShape(8.dp)
        ){
            Text(
                text = "Sign up",
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(
            modifier = Modifier.height(45.dp)
        )
        OrSigninWithDivider()
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            TechButton(
                onClick = {},
                imageUrl = R.drawable.facebook,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            TechButton(
                onClick = {},
                imageUrl = R.drawable.google,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            TechButton(
                onClick = {},
                imageUrl = R.drawable.apple,
                modifier = Modifier.size(27.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Already have an account?",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.outline
            )
            TextButton(
                onClick = {},
                content = {
                    Text(
                        text = "Sign up here",
                        color = Color(0xFFE50914)
                    )
                }
            )
        }
    }
}


@Composable
fun OrSigninWithDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(
            text = "or sign up with",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.outline
        )

        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@Composable
private fun TechButton(
    onClick: () -> Unit,
    imageUrl: Int,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .size(47.dp)
            .clip(CircleShape)
            .background(Color(0xFF1B1A1A))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = null,
            modifier = modifier
        )
    }
}
