import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.compose")
    kotlin("jvm")
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://androidx.dev/storage/compose-compiler/repository")
}

dependencies {
    implementation(compose.desktop.currentOs)
    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class) implementation(compose.material3)
    implementation("br.com.devsrsouza.compose.icons.jetbrains:feather:1.0.0")
    implementation("br.com.devsrsouza.compose.icons.jetbrains:tabler-icons:1.0.0")
}