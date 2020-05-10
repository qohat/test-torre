package co.torre.listitem.adapter.`in`.http

import co.torre.listitem.application.query.ListItemService
import co.torre.listitem.domain.ListItem
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/lists")
class ListItemRouting(val listItemService: ListItemService) {

    @GetMapping("/{key_id}")
    fun findByKey(@PathVariable("key_id") keyId: String): Flux<ListItem> {
        return listItemService.findByKeyId(keyId)
    }

    @GetMapping("/{key_id}/{text}")
    fun findByKeyAndValue(@PathVariable("key_id") keyId: String, @PathVariable("text") text: String): Flux<ListItem> {
        return listItemService.findByKeyIdAndValue(keyId, text)
    }

}