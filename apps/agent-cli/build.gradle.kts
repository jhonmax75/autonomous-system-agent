plugins {
    application
    kotlin("jvm")
}

application {
    // mainClass will be set via Kotlin object
}

dependencies {
    implementation(project(":modules:shared"))
    implementation(project(":modules:runtime"))
    implementation(project(":modules:planner"))
}
