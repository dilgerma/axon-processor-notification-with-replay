package de.nebulit.purchases

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

data class PurchasesReadModelQuery(val orderId: String)

/*
Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190925665
*/
@Entity
class PurchasesReadModelEntity {
  @Column(name = "email") var email: String? = null

  @Column(name = "model") var model: String? = null

  @Column(name = "price") var price: String? = null

  @Id
  @Column(name = "orderId") var orderId: String? = null
}

data class PurchasesReadModel(val data: PurchasesReadModelEntity)
