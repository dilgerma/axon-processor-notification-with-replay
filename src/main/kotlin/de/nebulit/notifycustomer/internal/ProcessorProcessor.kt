package de.nebulit.notifycustomer.internal

import de.nebulit.common.Processor
import de.nebulit.events.NotificationRequestedEvent
import de.nebulit.purchases.PurchasesReadModel
import de.nebulit.purchases.PurchasesReadModelQuery
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190844958
*/
@Component
class ProcessorProcessor : Processor {
  var logger = KotlinLogging.logger {}

  @Autowired lateinit var commandGateway: CommandGateway
  @Autowired lateinit var queryGateway: QueryGateway

  @EventHandler
  fun on(event: NotificationRequestedEvent) {
    var rm = queryGateway.query(PurchasesReadModelQuery(event.orderId), PurchasesReadModel::class.java).get()
    println("Sending EMAIL" + rm.data.email)
  }
}
