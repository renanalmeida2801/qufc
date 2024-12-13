package com.example.qufc.screens.homeScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.qufc.R

data class Course(
    val name: String,
    val icon: Painter,
    val code: String,
    val hours: String
)

data class Subject(
    val subject: String,
    val courses: List<Course>
)

@Composable
fun getMathCourses(): List<Course>{

    return listOf(

        Course(
            name = "Mat.Discreta",
            icon = painterResource(id =  R.mipmap.math_icon_foreground),
            code = "QXD008",
            hours = "64C/H"
        ),
        Course(
            name = "Mat.Básica",
            icon = painterResource(id =  R.mipmap.math_icon_foreground),
            code = "QXD008",
            hours = "64C/H"
        ),
        Course(
            name = "Probabilidade",
            icon = painterResource(id =  R.mipmap.probability_icon_foreground),
            code = "QXD009",
            hours = "64C/H"
        ),
        )

}