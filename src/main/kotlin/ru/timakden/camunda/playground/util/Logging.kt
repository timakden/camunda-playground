package ru.timakden.camunda.playground.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

fun <T : Any> logger(forClass: Class<T>): Logger {
    return LoggerFactory.getLogger(unwrapCompanionClass(forClass).name)
}

fun <T : Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> {
    return if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.companionObject?.java == ofClass) {
        ofClass.enclosingClass
    } else {
        ofClass
    }
}

fun <T : Any> unwrapCompanionClass(ofClass: KClass<T>): KClass<*> {
    return unwrapCompanionClass(ofClass.java).kotlin
}

fun <R : Any> R.lazyLogger(): Lazy<Logger> {
    return lazy { logger(this.javaClass) }
}
