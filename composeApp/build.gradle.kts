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
        osx.deploymentTarget = "13.5"
        tvos.deploymentTarget = "16.6"
        watchos.deploymentTarget = "9.6"

        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }
    }
}


