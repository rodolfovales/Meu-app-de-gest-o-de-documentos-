plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

tasks.register("clean").configure {
    delete(rootProject.layout.buildDirectory)
}
