package com.example.fliccsy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ComposeBasicsTheme {
//                MyApp(modifier = Modifier.fillMaxSize())
//            }
//        }
//    }
//}

data class Profile(val imageResource: Int, val name: String)

@Composable
fun ProfileCard(
    profile: Profile,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .width(350.dp)
            .height(90.dp)
            .clickable { navController.navigate(AllRoutes.Home.name) }
            .background(Color(0xffd3d3d3).copy(alpha = 0.3f), shape = RoundedCornerShape(7.dp))
            .padding(10.dp, 4.dp, 10.dp, 4.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = profile.imageResource),
            contentDescription = stringResource(
                id = R.string.profile
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = profile.name,
            color = Color.White,
            modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp),
            fontSize = 23.sp
        )
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Transparent)
        )
        Image(
            painter = painterResource(R.drawable.pencil),
            contentDescription = stringResource(id = R.string.edit_description),
            modifier = Modifier
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
                .size(30.dp)
        )

    }
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(
            Modifier
                .height(12.dp)
        )
    }
}


@Composable
fun ProfileList(
    navController: NavHostController,
    profiles: List<Profile>
) {
    val lazyColumnListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier.padding(bottom = 75.dp),
        state = lazyColumnListState
    ) {
        coroutineScope.launch {
            lazyColumnListState.animateScrollToItem(profiles.size - 1)
        }

        items(profiles) { profile ->
            ProfileCard(profile, navController)
        }
    }
}

@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Who's Watching",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 40.dp)
        )
        ProfileList(navController, SampleProfiles.profileSample)
        Button(
            onClick = { navController.navigate(AllRoutes.AddProfile.name) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .padding(16.dp, 4.dp, 16.dp, 16.dp)
                .size(250.dp, 60.dp)
                .dashedBorder(1.dp, White, 8.dp)
                .background(color = Color.Transparent)
                .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
        ) {
            Text(
                text = "Add Profile",
                color = White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }

    }
}

fun Modifier.dashedBorder(strokeWidth: Dp, color: Color, cornerRadiusDp: Dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerRadiusPx = density.run { cornerRadiusDp.toPx() }

        this.then(
            Modifier.drawWithCache {
                onDrawBehind {
                    val stroke = Stroke(
                        width = strokeWidthPx,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )

                    drawRoundRect(
                        color = color,
                        style = stroke,
                        cornerRadius = CornerRadius(cornerRadiusPx)
                    )
                }
            }
        )
    }
)

//@Composable
//private fun MyApp(modifier: Modifier = Modifier) {
//    var showOnBoarding by rememberSaveable() { mutableStateOf(true) }
//
//    Surface(modifier) {
//        OnBoardingScreen()
//    }
//}

object SampleProfiles {
    var profileSample = mutableStateListOf(
        Profile(
            R.drawable.profile,
            "Rick"
        ),
        Profile(
            R.drawable.profile2,
            "Morty"
        )
    )
}