plugins {
    kotlin("jvm") version "1.4.30"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.scoretwo"
version = "1.0-SNAPSHOT"
description = "An expansion that supports KotlinScript."

defaultTasks = mutableListOf("shadowJar")

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
    maven("http://repo.iroselle.com/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib"))
//    implementation("commons-cli:commons-cli:1.4")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jsr223:1.4.30")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.4.30")
    compileOnly("me.scoretwo:FastScript-common:1.0.1-SNAPSHOT")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    dependencies {
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib-common"))

//        include(dependency("commons-cli:commons-cli:1.4"))
        include(dependency("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-daemon-embeddable:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-reflect:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-scripting-common:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-scripting-compiler-embeddable:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-scripting-compiler-impl-embeddable:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-scripting-jsr223:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-scripting-jvm:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-scripting-jvm-host:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-script-runtime:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-script-util:1.4.30"))
        include(dependency("org.jetbrains.kotlin:kotlin-compiler:1.4.30"))
        include(dependency("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8"))
    }
    classifier = null
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.processResources {
    from("src/main/resources") {
        include("expansion.yml")
        expand(mapOf(
            "name" to rootProject.name,
            "version" to rootProject.version,
            "description" to rootProject.description
        ))
    }
}