package de.nebulit.events

import de.nebulit.common.Event

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190756695
*/
data class CustomerNotifiedEvent(var email: String, var orderId: String) : Event
