package de.nebulit.domain.commands.confirmpurchase

import de.nebulit.common.Command
import org.axonframework.modelling.command.TargetAggregateIdentifier

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190533950
*/
data class ConfirmPurchaseCommand(
    @TargetAggregateIdentifier var orderId: String,
    var email: String,
    var model: String,
    var price: String
) : Command
