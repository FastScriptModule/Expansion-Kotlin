plugins {
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.scoretwo"
version = "1.0-SNAPSHOT"

defaultTasks = mutableListOf("publishToMavenLocal")

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
    maven("http://repo.iroselle.com/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("commons-cli:commons-cli:1.4")
    implementation("org.jetbrains.kotlin:kotlin-script-util:1.4.21")
    implementation("org.jetbrains.kotlin:kotlin-compiler:1.4.21")
    compileOnly("me.scoretwo:FastScript-common:1.0.1-SNAPSHOT")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    dependencies {
        exclude(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
        exclude(dependency("org.jetbrains.kotlin:kotlin-stdlib-common"))

        include(dependency("commons-cli:commons-cli:1.4"))
        include(dependency("org.jetbrains.kotlin:kotlin-script-util:1.4.21"))
        include(dependency("org.jetbrains.kotlin:kotlin-compiler:1.4.21"))
    }
    classifier = null
}