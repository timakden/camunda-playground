package ru.timakden.camunda.playground.multi

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.timakden.camunda.playground.util.lazyLogger

@Component
class FirstDelegate : JavaDelegate {
    private val logger by lazyLogger()

    override fun execute(execution: DelegateExecution) {
        logger.info("FirstDelegate, business key = ${execution.processBusinessKey}")
        val elements = (1..50).map { DTO(it) }
        execution.setVariable(ELEMENTS_VARIABLE, elements)
    }
}
