import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.52.0"
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.spring") version "2.2.0"
}

group = "ru.timakden"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.3")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.23.0")
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
            jvmTarget.set(JVM_21)
        }
    }
    wrapper {
        gradleVersion = "8.14.2"
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
