package co.torre.people.domain

import javax.persistence.*

@Entity
@Table(name = "people")
data class People(
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var picture: String?,
    var name: String?,
    @Column(name = "person_id")
    var personId: String?,
    var profileName: String
)