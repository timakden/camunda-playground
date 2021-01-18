package ru.timakden.camunda.playground.multi

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.timakden.camunda.playground.util.lazyLogger
import kotlin.random.Random

@Component
class SecondDelegate : JavaDelegate {
    private val logger by lazyLogger()

    override fun execute(execution: DelegateExecution) {
        val element = execution.getVariable(ELEMENT_VARIABLE)
        logger.info("SecondDelegate, business key = ${execution.processBusinessKey}, element = $element")
        Thread.sleep(Random.nextLong(1000, 3000))
    }
}
