package com.example.qufc.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qufc.R
import com.example.qufc.screens.homeScreen.Course
import com.example.qufc.screens.homeScreen.getMathCourses
import com.example.qufc.screens.loginRegister.register.fontEsteban
import com.example.qufc.screens.loginRegister.register.fontModak


@Composable
fun CoursesComp(course: Course, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(140.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorResource(R.color.cinzaCraro))
            .border(
                width = 2.dp,
                color = colorResource(R.color.black),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = course.name,
                color = colorResource(id = R.color.bgColor),
                modifier = Modifier.padding(bottom = 10.dp),
                fontFamily = fontModak
            )
            Image(
                painter = course.icon,
                contentDescription = course.name,
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = "${course.code} ${course.hours}",
                modifier = Modifier.padding(top = 10.dp),
                color = colorResource(R.color.bgColor),
                fontFamily = fontEsteban
            )
        }
    }
}


@Composable
fun CoursesRow(modifier: Modifier = Modifier) {
    val mathCourses = getMathCourses()
    Column {
        Column(modifier = Modifier.padding(bottom = 10.dp)) {
            Text(
                text = "Matemática",
                fontFamily = fontEsteban,
                color = colorResource(R.color.bgColor),
                modifier = Modifier.padding(start = 13.dp, bottom = 10.dp)
            )
            LazyRow() {
                items(mathCourses) { item ->
                    CoursesComp(course = item, modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                }
            }
        }
        Column(modifier = Modifier.padding(bottom = 10.dp)) {
            Text(
                text = "Matemática",
                fontFamily = fontEsteban,
                color = colorResource(R.color.bgColor),
                modifier = Modifier.padding(start = 13.dp, bottom = 10.dp)
            )
            LazyRow() {
                items(mathCourses) { item ->
                    CoursesComp(course = item, modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                }
            }
        }
    }

}

@Preview
@Composable
fun PrevComp(){
    CoursesRow()
}