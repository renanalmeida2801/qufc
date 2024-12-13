package com.example.qufc.screens.loginRegister.register

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
import com.example.qufc.screens.loginRegister.components.TextFieldLogin

val fontModak = FontFamily(Font(R.font.modak))
val fontInter = FontFamily((Font(R.font.inter_regular)))
val fontEsteban = FontFamily(Font(R.font.esteban_regular))

@Composable
fun RegisterScreen(onContinueClick: (User) -> Unit, onHasAccount: (User) -> Unit) {

    var name: String by remember { mutableStateOf("") }
    var userName: String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
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
                text = "Cadastro",
                fontSize = 60.sp,
                fontFamily = fontModak,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 0.dp, 0.dp, 60.dp)

            )

            TextFieldLogin(name, "Nome Completo", modifier = Modifier.padding(0.dp,0.dp,0.dp,40.dp)) { newNome -> name = newNome }

            TextFieldLogin(userName, "Nome de Usuário", modifier = Modifier.padding(0.dp,0.dp,0.dp,40.dp)) { newUsername -> userName = newUsername }

            TextFieldLogin(email, "E-mail", modifier = Modifier.padding(0.dp,0.dp,0.dp,40.dp)) { newEmail -> email = newEmail }

            TextFieldLogin(senha, "Senha", modifier = Modifier.padding(0.dp,0.dp,0.dp,40.dp)) { newSenha -> senha = newSenha }

            Button(
                onClick = { onContinueClick(User(email, senha)) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(22.dp),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 0.dp, 0.dp, 40.dp)
                    .size(150.dp, 50.dp)
            ) {
                Text(
                    text = "Continuar",
                    color = colorResource(id = R.color.bgColor),
                    fontSize = 26.sp,
                    fontFamily = fontInter,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Já possui conta?",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight(1000)
                )
                Button(
                    onClick = { onHasAccount(User(email, senha)) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = ButtonDefaults.TextButtonContentPadding
                ) {

                    Text(
                        text = "Entrar!",
                        fontSize = 20.sp,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun RegisterPreview() {
    RegisterScreen(onContinueClick = {}, onHasAccount = {})
}