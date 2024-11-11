import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    Column {
        Row(modifier = Modifier.padding(10.dp) .fillMaxWidth()) {
            Text(
                text = "Instagram",
            )
        }
        Row(modifier = Modifier.padding(10.dp) .fillMaxWidth()) {
            users.forEach { user ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(80.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(5.dp)
                            .clip(CircleShape),
                        painter = painterResource(resourcePath = user.image),
                        contentDescription = "Foto de ${user.name}"
                    )
                    Text(
                        text = user.name,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
