import org.gradle.api.JavaVersion.VERSION_17
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.42.0"
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.spring") version "1.6.20"
}

group = "ru.timakden"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = VERSION_17
    targetCompatibility = VERSION_17
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.6.6")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.17.0")
    implementation("com.sun.xml.bind:jaxb-impl:3.0.2")
    implementation("com.h2database:h2:2.1.212")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
