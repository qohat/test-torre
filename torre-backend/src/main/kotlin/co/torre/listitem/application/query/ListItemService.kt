package co.torre.listitem.application.query

import co.torre.listitem.adapter.out.persistence.IListItemRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ListItemService(val listItemRepository: IListItemRepository): IListItemService {

    override fun findByKeyId(id: String) = Flux.fromIterable(listItemRepository.findByKeyId(id))

    override fun findByKeyIdAndValue(id: String, text: String) = Flux.fromIterable(listItemRepository.findByKeyId(id))
        .filter { it.value.toLowerCase().contains(text.toLowerCase()) || it.subValue.toLowerCase().contains(text.toLowerCase()) }

}