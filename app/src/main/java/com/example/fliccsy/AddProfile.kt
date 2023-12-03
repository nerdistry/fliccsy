package com.example.fliccsy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fliccsy.ui.theme.FliccsyTheme
import com.example.fliccsy.FormTextField

//class AddProfile : AddProfile() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ComposeBasicsTheme {
//                AddProfile(modifier = Modifier.fillMaxSize())
//            }
//        }
//    }
//}

@Composable
fun AddProfile(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .zIndex(3f)
            .padding(start = 30.dp, end = 30.dp, top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Profile",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile2),
            contentDescription = stringResource(
                id = R.string.profile
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .zIndex(3f)
                .size(80.dp)
                .clip(RoundedCornerShape(30.dp))
        )

        ConstraintLayout() {
            val (title, desc) = createRefs()
            Box(
                modifier = Modifier
                    .alpha(0.05f)
                    .background(Color(0xffffffff))
                    .height(200.dp)
                    .width(450.dp)
                    .zIndex(1f)
                    .border(
                        width = 2.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(5.dp))
                    .constrainAs(title) {
                        top.linkTo(parent.top, margin = (-30).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, margin = (-100).dp)
                    }
            )
        }
//        Spacer(modifier = Modifier.height(20.dp))

        ConstraintLayout() {
            val (title, desc) = createRefs()

            Box(
                modifier = Modifier
                    .zIndex(3f)
                    .padding(5.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top, margin = (-110).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                FormTextField(
                    value = "",
                    error = "",
                    placeholder = "Morty",
                    leadingIcon = Icons.Default.Person
                )
            }
        }

        Button(
            onClick = {
                SampleProfiles.profileSample.add(
                    Profile(
                        R.drawable.profile2,
                        "Morty"
                    )
                )
                navController.navigate(AllRoutes.Profile.name)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffFFE50914)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(16.dp, 4.dp, 16.dp, 16.dp)
                .size(300.dp, 60.dp)
                .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
        ) {
            Text(
                text = "Add Profile",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }

    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun AddProfilePreview() {
    FliccsyTheme() {
        AddProfile(navController = rememberNavController())
    }
}