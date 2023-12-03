package com.example.fliccsy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormTextField(
    value: String,
    error: String?,
    placeholder: String,
    textFieldHeight: Dp = 54.dp,
//    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF232222),
    placeholderColor: Color = Color(0xFF929090),
    leadingIcon: ImageVector
) {
    Column {
        TextField(
            value = value,
            onValueChange = { },
            placeholder = {
                Text(
                    text = placeholder,
                    color = placeholderColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = placeholderColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(textFieldHeight),
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "Icon",
                    tint = placeholderColor
                )
            },
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}
