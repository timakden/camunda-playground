import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "ru.timakden"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.2.3")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.20.0")
    implementation("com.sun.xml.bind:jaxb-impl")
    implementation("com.h2database:h2")
}

kotlin {
    jvmToolchain(21)
}

tasks {
    compileKotlin {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    wrapper {
        gradleVersion = "8.6"
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
