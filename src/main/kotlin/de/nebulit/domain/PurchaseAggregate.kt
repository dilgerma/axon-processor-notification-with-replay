package de.nebulit.domain

import de.nebulit.domain.commands.confirmpurchase.ConfirmPurchaseCommand
import de.nebulit.domain.commands.notifycustomer.NotifyCustomerCommand
import de.nebulit.events.CustomerNotifiedEvent
import de.nebulit.events.PurchaseConfirmedEvent
import java.util.UUID
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateCreationPolicy
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.modelling.command.CreationPolicy
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class PurchaseAggregate {

  @AggregateIdentifier var aggregateId: String? = null

  @CommandHandler
  fun handle(command: NotifyCustomerCommand) {

    AggregateLifecycle.apply(
        CustomerNotifiedEvent(email = command.email, orderId = command.orderId))
  }

  @EventSourcingHandler
  fun on(event: CustomerNotifiedEvent) {
    // handle event

  }

    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
  @CommandHandler
  fun handle(command: ConfirmPurchaseCommand) {

    AggregateLifecycle.apply(
        PurchaseConfirmedEvent(
            orderId = command.orderId,
            email = command.email,
            model = command.model,
            price = command.price))
  }

  @EventSourcingHandler
  fun on(event: PurchaseConfirmedEvent) {
    // handle event
      this.aggregateId = event.orderId

  }
}
