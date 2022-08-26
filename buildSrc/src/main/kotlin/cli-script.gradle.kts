import BuildConstants.mordantVersion
import BuildConstants.cliktVersion

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    repositories {
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
    }
}

dependencies {
    implementation("com.github.ajalt.mordant:mordant:$mordantVersion")
    implementation("com.github.ajalt.clikt:clikt:$cliktVersion")
}