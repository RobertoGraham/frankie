plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin:3.5.3")
    implementation("com.gradleup.shadow:com.gradleup.shadow.gradle.plugin:8.3.8")
}
