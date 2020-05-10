package co.torre.people.domain

data class Person(
        var professionalHeadline: String?,
        val completion: Double = 0.0,
        val showPhone: Boolean = false,
        val created: String?,
        val verified: Boolean = false,
        val weight: Int = 0,
        val locale: String?,
        val subjectId: String?,
        val picture: String?,
        val hasEmail: Boolean = false,
        val name: String?,
        val theme: String?,
        val id: String?,
        val pictureThumbnail: String?,
        val claimant: Boolean = false,
        val weightGraph: String?,
        val publicId: String??
)
