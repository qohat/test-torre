package co.torre.listitem.application.query

import co.torre.listitem.domain.ListItem
import reactor.core.publisher.Flux

interface IListItemService {

    fun findByKeyId(id: String): Flux<ListItem>

    fun findByKeyIdAndValue(id: String, text: String): Flux<ListItem>
}