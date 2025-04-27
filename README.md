## Nebulit GmbH - Axon Example with Replay Check

This is an example of how Axon can use Notifications to trigger event processors. 

In this case, you need to be Replay-Aware to only notify a processor in case no replay is active.

The Event Model for this case is [here](https://miro.com/app/board/uXjVI9I9GSM=/?moveToWidget=3458764626209443544&cot=14)

The Code in this sample application is 95% generated from the model, using the [Miro Event Modeling Toolkit](https://nebulit.de/accelerate)

You can find all details also in the [Understanding Eventsourcing Book](https://leanpub.com/eventmodeling-and-eventsourcing)
and in the Companion Course [Implementing Eventsourcing Course](https://www.eventsourcingcourse.com)

Here the processor sends an E-Mail (indicated by a log statement):

[Code](https://github.com/dilgerma/axon-processor-notification-with-replay/blob/main/src/main/kotlin/de/nebulit/notifycustomer/internal/ProcessorProcessor.kt#L27)

And [here](https://github.com/dilgerma/axon-processor-notification-with-replay/blob/main/src/main/kotlin/de/nebulit/purchases/internal/PurchasesReadModelProjector.kt#L38) the processor is triggered,
guarded by a Replay-Check.

Contact: info@nebulit.de
Company: https://www.nebulit.de