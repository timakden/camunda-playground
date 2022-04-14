package ru.timakden.camunda.playground

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.timakden.camunda.playground.util.lazyLogger

@Component
class SecondDelegate : JavaDelegate {
    private val logger by lazyLogger()

    override fun execute(execution: DelegateExecution) {
        logger.info("SecondDelegate, business key = ${execution.processBusinessKey}")
        throw RuntimeException("Something went wrong...")
    }
}
