import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.font.FontWeight

@Composable
fun App() {
    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 40.dp)) {
        Text(text = "Instagram", fontSize = 30.sp, fontWeight = FontWeight.Bold)

        Text(text = "Historias", fontSize = 18.sp, modifier = Modifier.padding(top = 8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp, bottom = 15.dp)
        ) {
            users.forEach { user ->
                var username = user.name
                if (username.length > 10) {
                    username = username.substring(0, 8) + "..."
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(80.dp),
                ) {
                    Image(
                        modifier = Modifier
                            .size(80.dp)
                            .border(1.dp, Color.Gray, CircleShape)
                            .padding(4.dp)
                            .clip(CircleShape),
                        painter = painterResource(resourcePath = "user_image/" + user.image),
                        contentDescription = "Foto de ${user.name}"
                    )
                    Text(
                        text = username,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Publicaciones", fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))

                LazyColumn(modifier = Modifier.padding(top = 8.dp).width(280.dp)) {
                    items(posts) { post ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            backgroundColor = Color(0xFFF5F5F5),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .width(280.dp),
                            elevation = 6.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .align(Alignment.CenterHorizontally),
                                    painter = painterResource(resourcePath = "post_image/" + post.image),
                                    contentDescription = "Foto publicada"
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = 10.dp)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(45.dp)
                                            .clip(CircleShape),
                                        painter = painterResource(resourcePath = "post_image/" + post.img_autor),
                                        contentDescription = "Foto del autor"
                                    )
                                    Text(text = post.autor, modifier = Modifier.padding(start = 8.dp))
                                }
                                Text(
                                    text = post.description,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = "Sugerencias", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
            }
        }
    }
}


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Instagram",
        state = rememberWindowState(size = DpSize(800.dp, 1200.dp))
    ) {
        App()
    }
}
