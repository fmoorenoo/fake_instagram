data class User(val name: String, val image: String){}

data class Post(val image: String, val img_autor: String, val autor: String, val description: String){}

val users = listOf<User>(
    User("unai_perez", "user1.jpg"),
    User("amaro_morales", "user2.jpg"),
    User("simon_gonzález", "user3.jpg"),
    User("iriemdaluz", "user4.jpg"),
    User("fer", "user5.jpg"),
    User("Messi", "user6.jpg")
)

val posts = listOf<Post>(
    Post("post1.jpeg", "autor1.jpg", "Messi", "El MVC está sobrevalorado."),
)