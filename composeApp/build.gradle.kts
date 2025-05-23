plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinCocoapods)
}

group = "org.jetbrains.kotlin.compose.sample"
version = "1.0-SNAPSHOT"

kotlin {
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Kotlin sample project with CocoaPods Compose dependencies"
        homepage = "https://github.com/Kotlin/kotlin-with-cocoapods-compose-sample"

        podfile = project.file("../iosApp/Podfile")

        ios.deploymentTarget = "16.6"

        /*
         * https://youtrack.jetbrains.com/issue/KT-41830/
         * Only link against pods the library (lorem-ipsum) depends on.
         */
        pod("GoogleSignIn") {
            version = "8.0.0"
            linkOnly = true
            extraOpts += listOf("-compiler-option", "-fmodules")
        }

        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(projects.loremIpsum)
        }

        all {
            languageSettings {
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
            }
        }
    }
}


