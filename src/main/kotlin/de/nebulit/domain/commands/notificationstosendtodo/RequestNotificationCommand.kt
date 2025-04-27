package de.nebulit.domain.commands.notificationstosendtodo

import org.axonframework.modelling.command.TargetAggregateIdentifier
import de.nebulit.common.Command


/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626191243501
*/
data class RequestNotificationCommand(
    var email:String,
	var orderId:String
): Command
