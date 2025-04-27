package de.nebulit.domain.commands.notifycustomer

import de.nebulit.common.Command

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190844964
*/
data class NotifyCustomerCommand(var email: String, var orderId: String) : Command
