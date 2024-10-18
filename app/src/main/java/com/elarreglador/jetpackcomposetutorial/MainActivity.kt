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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    MyList(" 01","One piece Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam scelerisque posuere nisi, eu pellentesque nisl. Donec sed purus non elit semper scelerisque. Curabitur tincidunt, justo quis sollicitudin eleifend, augue tortor semper enim"),
    MyList(" 02","Second lifeLorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam scelerisque posuere nisi, eu pellentesque nisl. Donec sed purus non elit semper scelerisque. Curabitur tincidunt"),
    MyList(" 03","Tercera Ley de Newton o Principio de Acción y Reacción Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam scelerisque posuere nisi, eu pellentesque nisl. Donec sed purus non elit semper scelerisque. "),
    MyList(" 04","Cuarto poder ac finibus nulla consequat. Etiam porttitor sem eu purus tincidunt porttitor."),
    MyList(" 05","Quinto elemento, peliculon! rutrum ut cursus vel, condimentum sed ex. rutrum ut cursus vel, condimentum sed ex."),
    MyList(" 06","Sex pistols Aliquam finibus et sapien vel cursus. Donec ut aliquam arcu." ),
    MyList(" 07","Seven nation army Vestibulum quis ultricies ipsum, quis venenatis lorem"),
    MyList(" 08","Ocho es multiplo de dos y de cuatro Suspendisse hendrerit maximus feugiat. Nunc maximus augue in placerat volutpat. Aenean at risus ipsum. Mauris vestibulum odio a purus congue congue. Vestibulum quis ultricies ipsum, quis venenatis lorem. Donec eget diam et enim tempor dignissim vel sodales lorem. Suspendisse lectus sapien, rutrum vitae purus sit amet, dapibus faucibus massa."),
    MyList(" 09","99 Luftballons Lorem Ipsum"),
    MyList(" 10","teen titans go quam imperdiet. Aliquam finibus et sapien vel cursus. Donec ut aliquam arcu.")
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

    // Codigo instintivo que no te va a funcionar:
    // var expanded = false
    // el odigo correcto es:
    var expanded by remember { mutableStateOf( false ) }
    // remember es una función que se utiliza para almacenar el estado de un valor entre recomposiciones de un componente.
    // mutableStateOf actualiza automáticamente la interfaz de usuario cuando el valor de la variable
    Column (modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }){
        MyText(
            mensajes.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            mensajes.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}


@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(
        text,
        color = color,
        style = style,
        maxLines = lines)
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