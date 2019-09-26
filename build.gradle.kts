import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVer by extra { "1.1.51" }
    val junitPlatformVer by extra { "1.0.1" }

    val shadowPluginVer = "2.0.1"

    repositories {
        jcenter()
        mavenCentral()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:$shadowPluginVer")
    }
}

apply {
    plugin("com.github.johnrengelman.shadow")
}
plugins {
    kotlin("jvm") version "1.3.50"
}

group = "org.tage.sample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/spekframework/spek-dev")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    // include JUnit 5 assertions
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")

    // include Spek 2 library
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.0-alpha.1")

    // include JUnit 5 test engine
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")

    // include Spek 2 JUnit test engine
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.0-alpha.1")
}

// configure test task to use Spek 2 test engine with JUnit
tasks.test {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "interpreter.Repl")
    }

    from (arrayOf(configurations.compile.get().files.map { if ( it.isDirectory ) it else zipTree(it) }) )
}
