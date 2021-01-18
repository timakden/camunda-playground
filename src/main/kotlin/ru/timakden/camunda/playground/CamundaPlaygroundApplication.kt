package ru.timakden.camunda.playground

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import java.util.*

@SpringBootApplication
@EnableProcessApplication
class CamundaPlaygroundApplication(private val runtimeService: RuntimeService) {
    @EventListener
    fun processPostDeploy(event: PostDeployEvent?) {
        runtimeService.startProcessInstanceByKey(MULTI_INSTANCE_PROCESS, UUID.randomUUID().toString())
    }
}

fun main(args: Array<String>) {
    runApplication<CamundaPlaygroundApplication>(*args)
}
