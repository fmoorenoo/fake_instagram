data class User(val name: String, val image: String){}

data class Post(val image: String, val img_autor: String, val autor: String, val description: String){}

val users = listOf<User>(
    User("User1", "user1.jpeg"),
    User("User2", "user2.jpeg"),
    User("User3", "user3.jpeg"),
    User("User4", "user4.jpeg"),
    User("User5", "user5.jpeg"),
    User("User6", "user6.jpeg")
)

val posts = listOf<Post>(
    Post("post1.jpeg", "autor1.jpeg", "feer._mm", "Hola, mi primera publicación"),
    Post("post2.jpeg", "autor2.jpeg", "Messi", "El MVC está sobrevalorado."),
)