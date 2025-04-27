package de.nebulit.events

import de.nebulit.common.Event



/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626191016154
*/
data class NotificationRequestedEvent(
    var email:String,
	var orderId:String
) : Event
