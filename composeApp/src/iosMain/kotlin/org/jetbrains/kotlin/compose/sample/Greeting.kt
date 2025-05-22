package org.jetbrains.kotlin.compose.sample

import org.jetbrains.kotlin.lorem.Ipsum

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun greetWithDependency(): String {
        return Ipsum().sentence()
    }
}