package de.nebulit.purchases.internal

import de.nebulit.events.NotificationRequestedEvent
import de.nebulit.events.PurchaseConfirmedEvent
import de.nebulit.purchases.PurchasesReadModelEntity
import java.util.UUID
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.axonframework.eventhandling.ReplayStatus
import org.axonframework.eventhandling.ResetHandler
import org.axonframework.eventhandling.gateway.EventGateway
import org.axonframework.eventhandling.replay.ReplayContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface PurchasesReadModelRepository : JpaRepository<PurchasesReadModelEntity, String>

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190925665
*/
@ProcessingGroup("purchases")
@Component
class PurchasesReadModelProjector(var repository: PurchasesReadModelRepository, val eventGateway: EventGateway) {

    @EventHandler
    fun on(event: PurchaseConfirmedEvent, replay: ReplayStatus) {
        // throws exception if not available (adjust logic)
        val entity = this.repository.findById(event.orderId).orElse(PurchasesReadModelEntity())
        entity
            .apply {
                email = event.email
                model = event.model
                price = event.price
                orderId = event.orderId
            }
            .also { this.repository.save(it) }

        if(!replay.isReplay) {
            eventGateway.publish(NotificationRequestedEvent(event.email, event.orderId))
        }
    }

    @ResetHandler
    fun resetHandler() {
        this.repository.deleteAll()
    }
}
