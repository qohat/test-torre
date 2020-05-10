package co.torre.listitem.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="list_items")
data class ListItem (
        @Id
        val id: Int,
        val keyId: String,
        val value: String,
        val subValue: String,
        val active: String
)
