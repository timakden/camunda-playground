import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

group = "ru.timakden"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.2.2")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.20.0")
    implementation("com.sun.xml.bind:jaxb-impl:4.0.4")
    implementation("com.h2database:h2:2.2.224")
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
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
