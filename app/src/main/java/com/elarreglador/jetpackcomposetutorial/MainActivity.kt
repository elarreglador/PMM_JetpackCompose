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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

data class MyList(val title: String, val body: String)

private val mensajes: List<MyList> = listOf(
    MyList(" 01","One piece"),
    MyList(" 02","Second life"),
    MyList(" 03","Tercera Ley de Newton o Principio de Acción y Reacción "),
    MyList(" 04","Cuarto poder"),
    MyList(" 05","Quinto elemento, peliculon!"),
    MyList(" 06","Sex pistols"),
    MyList(" 07","Seven nation army"),
    MyList(" 08","Ocho es multiplo de dos y de cuatro"),
    MyList(" 09","99 Luftballons"),
    MyList(" 10","teen titans go")
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                MyMessages(mensajes)
            }
        }
    }
}


@Composable
fun MyMessages(mensajes: List<MyList>){
    LazyColumn {
        items(mensajes) { mensajes ->
            MyComponent(mensajes)
        }
    }
}


@Composable
fun MyComponent(mensajes: MyList) {
    Row(modifier = Modifier
        .padding(18.dp)
        .background(MaterialTheme.colorScheme.background)) {
        MyImage()
        MyTexts(mensajes)
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
fun MyTexts(mensajes: MyList){
    Column {
        MyText(
            mensajes.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            mensajes.body,
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


@Preview(
    name = "Modo Dia",
    showSystemUi = true
)
@Composable
fun PreviewComponents(){
    JetpackComposeTutorialTheme {
        MyMessages(mensajes)
    }
}