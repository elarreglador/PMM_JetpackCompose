package com.elarreglador.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elarreglador.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                MyComponent()
            }
            MyComponent()
        }
    }
}


@Composable
fun MyComponent() {
    Row(modifier = Modifier
        .padding(18.dp)
        .background(MaterialTheme.colorScheme.background)
    ) {
        MyImage()
        MyTexts()
    }
}


@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}


@Composable
fun MyTexts(){
    Column {
        MyText(
            "Hola Jetpack Compose!",
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            "Preparado?",
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall
        )
    }
}


@Composable
fun MyText(text: String, color: Color, style: TextStyle){
    Text(
        text,
        color = color,
        style = style)
}

@Preview(name = "Modo Dia")
@Preview(
    name = "Modo Noche",
    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents(){
    MyComponent()
}