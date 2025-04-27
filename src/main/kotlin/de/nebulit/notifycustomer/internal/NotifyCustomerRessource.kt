package de.nebulit.notifycustomer.internal

import de.nebulit.domain.commands.notifycustomer.NotifyCustomerCommand
import java.util.concurrent.CompletableFuture
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class NotifyCustomerPayload(var email: String, var orderId: String)

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190844964
*/
@RestController
class NotifyCustomerRessource(private var commandGateway: CommandGateway) {

  var logger = KotlinLogging.logger {}

  @CrossOrigin
  @PostMapping("/debug/notifycustomer")
  fun processDebugCommand(
      @RequestParam email: String,
      @RequestParam orderId: String
  ): CompletableFuture<Any> {
    return commandGateway.send(NotifyCustomerCommand(email, orderId))
  }

  @CrossOrigin
  @PostMapping("/notifycustomer/{id}")
  fun processCommand(
      @PathVariable("id") aggregateId: java.util.UUID,
      @RequestBody payload: NotifyCustomerPayload
  ): CompletableFuture<Any> {
    return commandGateway.send(
        NotifyCustomerCommand(email = payload.email, orderId = payload.orderId))
  }
}
