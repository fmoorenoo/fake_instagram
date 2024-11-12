data class User(val name: String, val image: String){}

data class Post(val image: String, val img_autor: String, val autor: String, val description: String){}

data class Suggestion(val name: String, val image: String){}


val users = listOf<User>(
    User("unai_perez", "user1.jpg"),
    User("amaro_morales", "user2.jpg"),
    User("simon_gonzález", "user3.jpg"),
    User("iriemdaluz", "user4.jpg"),
    User("feer.mm_", "user5.jpg"),
    User("fabio_waszshowitsf", "user6.jpg")
)

val posts = listOf<Post>(
    Post("post1.jpg", "autor1.jpg", "messi", "Odio a Cristiano Ronaldo, pero odio más AndroidStudio. #kotlin #futbol"),
    Post("post1.jpg", "autor1.jpg", "messi", "Odio a Cristiano Ronaldo, pero odio más AndroidStudio. #kotlin #futbol"),
    Post("post1.jpg", "autor1.jpg", "messi", "Odio a Cristiano Ronaldo, pero odio más AndroidStudio. #kotlin #futbol"),
    Post("post1.jpg", "autor1.jpg", "messi", "Odio a Cristiano Ronaldo, pero odio más AndroidStudio. #kotlin #futbol"),
)

val users_suggestions = listOf<Suggestion>(
    Suggestion("cristiano", "user1.jpg"),
    Suggestion("thegrefg", "user2.jpg"),
    Suggestion("fortnitepro_2009", "user3.jpg"),
    Suggestion("shrek_official", "user4.jpg")
)

val photo_suggestions = listOf<Suggestion>(
    Suggestion("", "photo1.jpg"),
    Suggestion("", "photo2.jpg"),
    Suggestion("", "photo3.jpg"),
    Suggestion("", "photo4.jpg"),
    Suggestion("", "photo5.jpg"),
    Suggestion("", "photo6.jpg"),
)