package de.nebulit.confirmpurchase.internal

import de.nebulit.domain.commands.confirmpurchase.ConfirmPurchaseCommand
import java.util.concurrent.CompletableFuture
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class ConfirmPurchasePayload(
    var orderId: String,
    var email: String,
    var model: String,
    var price: String
)

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190533950
*/
@RestController
class ConfirmPurchaseRessource(private var commandGateway: CommandGateway) {

  var logger = KotlinLogging.logger {}

  @CrossOrigin
  @PostMapping("/debug/confirmpurchase")
  fun processDebugCommand(
      @RequestParam orderId: String,
      @RequestParam email: String,
      @RequestParam model: String,
      @RequestParam price: String
  ): CompletableFuture<Any> {
    return commandGateway.send(ConfirmPurchaseCommand(orderId, email, model, price))
  }

  @CrossOrigin
  @PostMapping("/confirmpurchase/{id}")
  fun processCommand(
      @PathVariable("id") aggregateId: java.util.UUID,
      @RequestBody payload: ConfirmPurchasePayload
  ): CompletableFuture<Any> {
    return commandGateway.send(
        ConfirmPurchaseCommand(
            orderId = payload.orderId,
            email = payload.email,
            model = payload.model,
            price = payload.price))
  }
}
