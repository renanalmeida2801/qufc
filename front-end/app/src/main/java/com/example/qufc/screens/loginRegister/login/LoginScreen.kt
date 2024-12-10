package com.example.qufc.screens.loginRegister.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qufc.R
import com.example.qufc.User
import com.example.qufc.ui.theme.QufcTheme
import com.example.qufc.screens.loginRegister.components.TextFieldLogin

@Composable
fun LoginScreen(onEnterClick: (User) -> Unit, onNotRegistered: () -> Unit) {
    val fontModak = FontFamily(Font(R.font.modak))

    var login: String by remember { mutableStateOf("") }
    var senha: String by remember { mutableStateOf("") }

    Surface(
        color = colorResource(id = R.color.bgColor),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "QUFC",
                fontSize = 40.sp,
                fontFamily = fontModak,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 0.dp, 0.dp, 60.dp)

            )

            TextFieldLogin(login, "E-mail", modifier = Modifier.padding(0.dp,0.dp,0.dp,40.dp)) { newLogin -> login = newLogin }

            TextFieldLogin(senha, "Senha", modifier = Modifier.padding(0.dp,0.dp,0.dp,40.dp)) { newSenha -> senha = newSenha }

            Button(
                onClick = {onEnterClick(User(login, senha))},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 0.dp, 0.dp, 40.dp)
                    .size(150.dp, 50.dp)
            ) {
                Text(
                    text = "Entrar",
                    color = colorResource(id = R.color.bgColor),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Não possui conta?",
                    fontSize = 20.sp,
                    color = Color.White,
                )
                Button(
                    onClick = { onNotRegistered() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = ButtonDefaults.TextButtonContentPadding
                ) {

                    Text(
                        text = "Cadastre-se aqui!",
                        fontSize = 20.sp,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun loginPreview(modifier: Modifier = Modifier){
    QufcTheme {
        LoginScreen(onEnterClick = {}, onNotRegistered = {})
    }
}