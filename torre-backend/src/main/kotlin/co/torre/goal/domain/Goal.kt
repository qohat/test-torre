package co.torre.goal.domain

import co.torre.listitem.domain.ListItem
import java.util.*
import javax.persistence.*

@Entity
@Table(name="goals")
data class Goal (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,
        var peopleId: String,
        var interestId: String,
        var interestName: String,
        @OneToOne
        @JoinColumn(name = "level_id", referencedColumnName = "id")
        var level: ListItem?,
        var expirationDate: Date?,
        var score: Int?
)
