package ru.timakden.camunda.playground.multi

import java.io.Serializable
import java.util.*

data class DTO(val number: Int, val id: UUID = UUID.randomUUID()) : Serializable
