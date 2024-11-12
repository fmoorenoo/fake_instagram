import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

        // HISTORIAS
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

        Row() {
            // PUBLICACIONES
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Publicaciones", fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp), fontWeight = FontWeight.Bold)

                LazyColumn(modifier = Modifier.padding(top = 8.dp).width(280.dp)) {
                    items(posts) { post ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            backgroundColor = Color(0xFFF0F0F0),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp)
                                .width(280.dp),
                            elevation = 8.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(230.dp)
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
                                            .size(50.dp)
                                            .clip(CircleShape),
                                        painter = painterResource(resourcePath = "post_image/" + post.img_autor),
                                        contentDescription = "Foto del autor"
                                    )
                                    Text(text = post.autor, modifier = Modifier.padding(start = 8.dp), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                }
                                Text(
                                    text = post.description,
                                    modifier = Modifier.padding(top = 4.dp),
                                    fontSize = 17.sp
                                )
                            }
                        }
                    }
                }
            }
            // SUGERENCIAS
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(text = "Sugerencias", fontSize = 18.sp, modifier = Modifier.padding(top = 14.dp, bottom = 26.dp), fontWeight = FontWeight.Bold)

                // SUGERENCIA DE PERSONAS
                Column(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .background(Color(0xFFF0F0F0))
                        .padding(18.dp)
                ) {
                    Text(text = "Personas", fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))
                    users_suggestions.forEach { suggestion ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape),
                                painter = painterResource(resourcePath = "suggestion_image/" + suggestion.image),
                                contentDescription = "Foto del autor"
                            )
                            Text(text = suggestion.name, modifier = Modifier.padding(start = 8.dp), fontSize = 20.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))


                // SUGERENCIA DE FOTOS
                Column(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .background(Color(0xFFF0F0F0))
                        .padding(18.dp)
                ) {
                    Text(text = "Fotos", fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
                    ) {
                        repeat(3) { numFoto ->
                            val suggestion = photo_suggestions[numFoto]
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(80.dp)
                            ) {
                                Image(
                                    modifier = Modifier.size(65.dp),
                                    painter = painterResource(resourcePath = "suggestion_image/" + suggestion.image),
                                    contentDescription = "Foto"
                                )
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        repeat(3) { numFoto ->
                            val suggestion = photo_suggestions[numFoto + 3]
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(80.dp)
                            ) {
                                Image(
                                    modifier = Modifier.size(65.dp),
                                    painter = painterResource(resourcePath = "suggestion_image/" + suggestion.image),
                                    contentDescription = "Foto"
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
        title = "Instagram",
        state = rememberWindowState(size = DpSize(750.dp, 1200.dp))
    ) {
        App()
    }
}
