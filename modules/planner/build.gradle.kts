plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":modules:runtime"))
    implementation(project(":modules:shared"))
    testImplementation(kotlin("test"))
}
