package co.torre.people.domain

data class Interests(
        var id: String??,
        val code: Int = 0, 
        val name: String?, 
        val created: String?, 
        val media: List<Any>?
)