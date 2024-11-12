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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Instagram", fontSize = 30.sp)

        Text(text = "Historias", fontSize = 18.sp, modifier = Modifier.padding(top = 8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp, bottom = 15.dp)
        ) {
            users.forEach { user ->
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
                        text = user.name,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }


        Row(modifier = Modifier.fillMaxWidth()) {
            Column() {
                Text(text = "Publicaciones", fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))
                posts.forEach { post ->
                    Column(modifier = Modifier.padding(top = 8.dp).width(250.dp)) {
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                            backgroundColor = Color.LightGray,
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Image(
                                    modifier = Modifier
                                        .size(170.dp)
                                        .clip(RoundedCornerShape(8.dp)),
                                    painter = painterResource(resourcePath = "post_image/" + post.image),
                                    contentDescription = "Foto",
                                    alignment = Alignment.CenterStart
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(top = 8.dp)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(55.dp)
                                            .clip(CircleShape),
                                        painter = painterResource(resourcePath = "post_image/" + post.image),
                                        contentDescription = "Foto"
                                    )
                                    Text(text = post.autor, modifier = Modifier.padding(start = 8.dp))
                                }
                                Text(
                                    text = post.description, modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Instagram"
    ) {
        App()
    }
}
