package de.nebulit.purchases.internal

import de.nebulit.purchases.PurchasesReadModel
import de.nebulit.purchases.PurchasesReadModelQuery
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190925665
*/
@Component
class PurchasesReadModelQueryHandler(private val repository: PurchasesReadModelRepository) {

  @QueryHandler
  fun handleQuery(query: PurchasesReadModelQuery): PurchasesReadModel? {

    if (!repository.existsById(query.orderId)) {
      return null
    }
    return PurchasesReadModel(repository.findById(query.orderId).get())
  }
}
