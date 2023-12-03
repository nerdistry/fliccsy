package com.example.fliccsy

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun SwipingBox(){
    val state = rememberSwipeableCardState()
    val states = movies.reversed()
        .map { it to rememberSwipeableCardState() }
    var hint by remember {
        mutableStateOf("Swipe a card or press a button below")
    }

    Hint(hint)
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFE50914))
        ) {
        states.forEach { (movie, state) ->
            if (state.swipedDirection == null) {
                MovieCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(Direction.Down),
                            onSwiped = {
                                // swipes are handled by the LaunchedEffect
                                // so that we track button clicks & swipes
                                // from the same place
                            },
                            onSwipeCancel = {
                                Log.d("Swipeable-Card", "Cancelled swipe")
                                hint = "You canceled the swipe"
                            }
                        ),
                    movie = movie
                )
            }
            LaunchedEffect(movie, state.swipedDirection) {
                if (state.swipedDirection != null) {
                    hint = "You swiped ${stringFrom(state.swipedDirection!!)}"
                }
            }
        }
    }
}

private fun stringFrom(direction: Direction): String {
    return when (direction) {
        Direction.Left -> "Left 👈"
        Direction.Right -> "Right 👉"
        Direction.Up -> "Up 👆"
        Direction.Down -> "Down 👇"
    }
}

@Composable
private fun Hint(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MovieCard(modifier: Modifier,movie: Movie){
    Box(
       modifier = modifier
    ){
        Box(modifier = Modifier
            .clip(
                MaterialTheme.shapes.medium.copy(
                    bottomEnd = CornerSize(20.dp),
                    bottomStart = CornerSize(20.dp)
                )
            )
            .background(Color(0xFF000000))
        ){
            Column {
                Image(
                    painter = painterResource(id = movie.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(430.dp)
                        .fillMaxWidth()
                )
                Text(movie.title,color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 30.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(movie.actor,color = Color(0xFF929090), fontSize = 16.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 30.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(movie.time,color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 30.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Row (
                    modifier = Modifier.padding(start = 30.dp)
                ){
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = "Icon",
                        tint = Color(0xFFF8BD00))
                    Spacer(modifier = Modifier.height(10.dp))
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = "Icon",
                        tint = Color(0xFFF8BD00))
                    Spacer(modifier = Modifier.height(10.dp))
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = "Icon",
                        tint = Color(0xFFF8BD00))
                    Spacer(modifier = Modifier.height(10.dp))
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = "Icon",
                        tint = Color(0xFFF8BD00))
                    Spacer(modifier = Modifier.height(10.dp))
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = "Icon",
                        tint = Color(0xFFF8BD00))
                }
                Spacer(modifier = Modifier.height(30.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                    ,
                ){
                    items(movie.tags) { tag ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .background(color = Color(0xFF0C0C0C), shape = CircleShape)
                        ) {
                            Text(
                                text = tag,
                                color = Color.White,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
        Box(modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .align(Alignment.TopEnd)
            .padding(15.dp)
            .background(Color(0xFFFCE8E8).copy(alpha = 0.4F)),
            contentAlignment = Alignment.Center
        ){
            Icon(imageVector = Icons.Default.Clear,
                contentDescription = "Icon")
        }
        Box(
            modifier = Modifier
                .background(
                    movie.color
                )
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(55.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "More Info",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}