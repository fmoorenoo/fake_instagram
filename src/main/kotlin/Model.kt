data class User(val name: String, val image: String){}

data class Post(val image: String, val img_autor: String, val autor: String, val description: String){}

data class Suggestion(val name: String, val image: String){}


val users = listOf<User>(
    User("unai123", "user1.jpg"),
    User("amarooo_", "user2.jpg"),
    User("simon_fitness", "user3.jpg"),
    User("feer.mm_", "user4.jpg"),
    User("iiiiiiriem", "user5.jpg"),
    User("fabio_waszshowitsf", "user6.jpg")
)

val posts = listOf<Post>(
    Post("post2.jpg", "autor2.jpg", "feer.mm_", "Mi nueva casa! :D  #ahorros #emprendimiento"),
    Post("post3.jpg", "autor3.jpg", "elonmusk", "'Tesla guisante' coming soon... #tesla #future"),
    Post("post1.jpg", "autor1.jpg", "messi", "Odio a Cristiano Ronaldo, pero odio más AndroidStudio.\n#kotlin #futbol"),
    Post("post4.jpg", "autor4.jpg", "unai123", "Actualización de mi físico. #mrolympia"),
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
    Suggestion("", "photo7.jpg"),
    Suggestion("", "photo8.jpg"),
    Suggestion("", "photo9.jpg"),
)