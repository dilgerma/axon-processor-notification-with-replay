package de.nebulit.events

import de.nebulit.common.Event

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190448609
*/
data class PurchaseConfirmedEvent(
    var email: String,
    var model: String,
    var price: String,
    var orderId: String
) : Event
