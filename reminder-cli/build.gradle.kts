
plugins {
    kotlin("jvm")
    `default-project-script`
    `cli-script`
}

dependencies {
    implementation(project(":${rootProject.name}-app"))
}

application.mainClass.set("dev.nyon.reminder.cli.MainKt")