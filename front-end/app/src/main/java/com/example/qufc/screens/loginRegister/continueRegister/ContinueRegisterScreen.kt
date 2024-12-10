package com.example.qufc.screens.loginRegister.continueRegister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qufc.R
import com.example.qufc.screens.loginRegister.components.CustomInputImage
import com.example.qufc.screens.loginRegister.components.TextFieldLogin
import com.example.qufc.screens.loginRegister.register.fontInter
import com.example.qufc.screens.loginRegister.register.fontModak

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContinueRegisterScreen() {

    var matricula : String by remember { mutableStateOf("") }
    var isExpanded: Boolean by remember { mutableStateOf(false) }
    val courses = listOf("Engenharia de Software",
        "Engenharia da Computação",
        "Ciência da Computação",
        "Design Digital",
        "Sistema de Informação",
        "Redes de Computadores"
        )
    var selectedCourse by remember { mutableStateOf(courses[0]) }
    var isStudent: Boolean by remember { mutableStateOf(false) }
    var isTeacher: Boolean by remember { mutableStateOf(false) }

    Surface(
        color = colorResource(id = R.color.bgColor),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Cadastro",
                fontSize = 60.sp,
                fontFamily = fontModak,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 0.dp, 0.dp, 60.dp)

            )

            CustomInputImage()

            Text(
                text = "Você Professor ou Aluno?",
                fontSize = 26.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )

            fun StudentHandler(){
                isStudent = true
                isTeacher = false
            }
            fun TeacherHandler(){
                isStudent = false
                isTeacher = true
            }


            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 30.dp)
                ) {
                Checkbox(checked = isStudent, onCheckedChange = {StudentHandler()})
                Text(text =  "Aluno",
                    color = Color.White,
                    fontSize = 20.sp
                )
                Checkbox(
                    checked = isTeacher,
                    onCheckedChange = {TeacherHandler()},
                    modifier = Modifier.padding(25.dp, 0.dp,0.dp,0.dp)
                )
                Text(text =  "Professor",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }

            TextFieldLogin(matricula, "Matrícula", modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp)){
                    newMatricula -> matricula = newMatricula
            }

            Text(text =  "Selecione o seu Curso",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Start)
                    .padding(50.dp,0.dp,0.dp, 0.dp)
            )

            ExposedDropdownMenuBox(expanded = isExpanded,
                onExpandedChange = {isExpanded = !isExpanded}) {

                TextField(modifier = Modifier.menuAnchor(),
                    value = selectedCourse,
                    onValueChange = {},
                    readOnly = true,
                    colors = ExposedDropdownMenuDefaults.textFieldColors(focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                        ),
                    trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)},
                    shape = RoundedCornerShape(16.dp)
                )

                DropdownMenu(
                    expanded = isExpanded, onDismissRequest = { isExpanded = false },
                    modifier = Modifier.wrapContentSize()
                ) {
                    courses.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                selectedCourse = courses[index]
                                isExpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(22.dp),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(0.dp,10.dp, 0.dp, 0.dp)
                    .size(260.dp, 50.dp)
            ) {
                Text(text = "Finalizar Cadastro",
                    color = colorResource(id = R.color.bgColor),
                    fontSize = 26.sp,
                    fontFamily = fontInter,
                    fontWeight = FontWeight.ExtraBold
                )
            }



//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    text = "Já possui conta?",
//                    fontSize = 20.sp,
//                    color = Color.White,
//                    fontWeight = FontWeight(1000)
//                )
//                Button(
//                    onClick = {},
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
//                    contentPadding = ButtonDefaults.TextButtonContentPadding
//                ) {
//
//                    Text(
//                        text = "Entrar!",
//                        fontSize = 20.sp,
//                        color = Color.White,
//                        textDecoration = TextDecoration.Underline
//                    )
//                }
//            }
        }
    }
}

@Composable
@Preview
fun ContinueRegisterPreview(){
    ContinueRegisterScreen()
}