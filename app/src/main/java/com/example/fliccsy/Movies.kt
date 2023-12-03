package com.example.fliccsy

import androidx.compose.ui.graphics.Color

data class Movie(val title: String, val imageUrl: Int, val actor: String,val time: String, val tags: List<String> ,val color: Color)


val movies = listOf(
    Movie("Aladdin",
        R.drawable.aladin,
        actor = "Will Smith",
        time = "2hrs 10m",
        tags = listOf("#action","#romantic","#family"),
        color = Color(0xFFE50914)
    ),
    Movie("The Lion King",
        R.drawable.lionking2,
        actor = "Beyonce",
        time = "1hrs 58m",
        tags = listOf("#adventure","#romantic","#family"),
        color = Color(0xFFE50914)),
    Movie("The Little Mermaid",
        R.drawable.littlemermaid2,
        actor = "Halle Bailey",
        time = "2hrs 10m",
        tags = listOf("#fairytale","#romantic","#family"),
        color = Color(0xFFE50914)),
    Movie("Mr Robot",
        R.drawable.mrrobot3,
        actor = "Rami Malek",
        time = "4 Seasons",
        tags = listOf("#action","#sci-fi","#thriller"),
        color = Color(0xFFE50914)),
    Movie("Scream",
        R.drawable.scream,
        actor = "Jenna Ortega",
        time = "5 films",
        tags = listOf("#horror","#thriller","#mystery"),
        color = Color(0xFFE50914)),
)