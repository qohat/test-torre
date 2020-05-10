package co.torre.people.domain

data class Bio (
    val person: Person,
    val interests: List<Interests>,
    val opportunities: List<Opportunities>
)

