package com.example.qufc.screens.loginRegister.components

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.material3.ButtonDefaults
import coil.compose.rememberAsyncImagePainter
import com.example.qufc.R

@SuppressLint("ResourceAsColor")
@Composable
fun CustomInputImage() {

//        var imageUri by remember {
//            mutableStateOf<Uri?>(null)
//        }
//        val context = LocalContext.current
//        val bitmap =  remember {
//            mutableStateOf<Bitmap?>(null)
//        }
//
//        val launcher = rememberLauncherForActivityResult(contract =
//        ActivityResultContracts.GetContent()) { uri: Uri? ->
//            imageUri = uri
//        }
//        Column(verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                launcher.launch("image/*")
//            }) {
//                Text(text = "Pick image")
//            }
//
//            Spacer(modifier = Modifier.height(12.dp)
//                .background(Color.Black))
//
//            imageUri?.let {
//                val source = ImageDecoder
//                    .createSource(context.contentResolver,it)
//                bitmap.value = ImageDecoder.decodeBitmap(source)
//
//                bitmap.value?.let {  btm ->
//                    Image(bitmap = btm.asImageBitmap(),
//                        contentDescription =null,
//                        modifier = Modifier.size(400.dp))
//                }
//            }
//
//        }


    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri -> imageUri = uri }
    )

    Column(
        modifier = Modifier.padding(0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { launcher.launch("image/*") },
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(0.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(190.dp)
                    .padding(0.dp),
                contentAlignment = Alignment.Center
            ) {
                if (imageUri == null) {
                    // Imagem padrão quando nenhuma imagem é selecionada
                    Image(
                        painter = painterResource(id = R.mipmap.user_icon_foreground),
                        contentDescription = "Imagem padrão",
                        modifier = Modifier
                            .size(190.dp)
                            .border(3.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
                            .background(Color.LightGray, shape = RoundedCornerShape(16.dp))
                            .padding(0.dp)

                    )
                } else {
                    // Mostrar a imagem selecionada
                    Image(
                        painter = rememberAsyncImagePainter(model = imageUri),
                        contentDescription = "Imagem selecionada",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(190.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .border(3.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))

                    )
                }
            }
        }


    }

}

@Composable
@Preview
fun Iimage() {
    CustomInputImage()
}

