package de.nebulit.support.internal

import org.axonframework.config.EventProcessingConfiguration
import org.axonframework.eventhandling.StreamingEventProcessor
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ResetStream(
    // (1)
    val config: EventProcessingConfiguration
) {

    @PostMapping("/reset/{processingGroup}")
    fun reset(@PathVariable processingGroup: String) {
        // (2)
        this.config.eventProcessor<StreamingEventProcessor>(processingGroup).ifPresent {
            // (3)
            it.shutdownAsync().thenRun {
                // (4)
                it.resetTokens()
                it.start()
            }
        }
    }
}