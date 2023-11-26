package be.frietstoofvlees.coffeebrewer.data

data class User(val email: String, val password: String)

interface UserRepository {
    suspend fun login(email: String, password: String): Boolean
}

class InMemoryUserRepository : UserRepository {
    private val users = listOf(
        User("user1@example.com", "password123"),
        User("user2@example.com", "securePassword"),
    )

    override suspend fun login(email: String, password: String): Boolean {
        val user = users.find { it.email == email && it.password == password }
        return user != null
    }

}