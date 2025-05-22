plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
}

group = "org.jetbrains.kotlin.lorem-ipsum"
version = "1.0-SNAPSHOT"

kotlin {
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Kotlin lorem-ipsum module with cocoapods dependencies"

        // We don't need a podspec for a module dependency
        noPodspec()

        pod("LoremIpsum") {
            version = "~> 1.0"
        }
    }

    sourceSets.all {
        languageSettings {
            optIn("kotlinx.cinterop.ExperimentalForeignApi")
        }
    }
}