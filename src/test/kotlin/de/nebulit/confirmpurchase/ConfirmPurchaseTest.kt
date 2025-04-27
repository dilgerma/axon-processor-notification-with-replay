package de.nebulit.confirmpurchase

import de.nebulit.common.Event
import de.nebulit.common.support.RandomData
import de.nebulit.domain.PurchaseAggregate
import de.nebulit.domain.commands.confirmpurchase.ConfirmPurchaseCommand
import de.nebulit.events.PurchaseConfirmedEvent
import org.axonframework.test.aggregate.AggregateTestFixture
import org.axonframework.test.aggregate.FixtureConfiguration
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Foo Foo
 *
 * Boardlink: https://miro.com/app/board/uXjVIUZz1oE=/?moveToWidget=3458764626190534408
 */
class ConfirmPurchaseTest {

  private lateinit var fixture: FixtureConfiguration<PurchaseAggregate>

  @BeforeEach
  fun setUp() {
    fixture = AggregateTestFixture(PurchaseAggregate::class.java)
  }

  @Test
  fun `Confirm Purchase Test`() {

    var orderId: String = RandomData.newInstance<String> {}

    // GIVEN
    val events = mutableListOf<Event>()

    // WHEN
    val command =
        ConfirmPurchaseCommand(
            orderId = orderId,
            email = RandomData.newInstance {},
            model = RandomData.newInstance {},
            price = RandomData.newInstance {})

    // THEN
    val expectedEvents = mutableListOf<Event>()

    expectedEvents.add(
        RandomData.newInstance<PurchaseConfirmedEvent> {
          this.email = command.email
          this.model = command.model
          this.price = command.price
          this.orderId = command.orderId
        })

    fixture
        .given(events)
        .`when`(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(*expectedEvents.toTypedArray())
  }
}
