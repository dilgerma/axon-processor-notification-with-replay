package de.nebulit.purchases.internal

import de.nebulit.purchases.PurchasesReadModel
import de.nebulit.purchases.PurchasesReadModelQuery
import java.util.concurrent.CompletableFuture
import mu.KotlinLogging
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190925665
*/
@RestController
class PurchasesRessource(private var queryGateway: QueryGateway) {

  var logger = KotlinLogging.logger {}

  @CrossOrigin
  @GetMapping("/purchases/{id}")
  fun findReadModel(
      @PathVariable("orderId") orderId: String
  ): CompletableFuture<PurchasesReadModel> {
    return queryGateway.query(PurchasesReadModelQuery(orderId), PurchasesReadModel::class.java)
  }
}
