package ru.timakden.camunda.playground.multi

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.timakden.camunda.playground.util.lazyLogger

@Component
class ThirdDelegate : JavaDelegate {
    private val logger by lazyLogger()

    override fun execute(execution: DelegateExecution) {
        val product = execution.getVariable(ELEMENT_VARIABLE)
        logger.info("ThirdDelegate, business key = ${execution.processBusinessKey}, element = $product")
    }
}
