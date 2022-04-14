package ru.timakden.camunda.playground

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.timakden.camunda.playground.util.lazyLogger

@Component
class FirstDelegate : JavaDelegate {
    private val logger by lazyLogger()

    override fun execute(execution: DelegateExecution) {
        logger.info("FirstDelegate, business key = ${execution.processBusinessKey}")
    }
}
