package co.torre.listitem.adapter.out.persistence

import co.torre.listitem.domain.ListItem
import org.springframework.data.jpa.repository.JpaRepository

interface IListItemRepository: JpaRepository<ListItem, Int> {

    fun findByKeyId(keyId: String): List<ListItem>
}