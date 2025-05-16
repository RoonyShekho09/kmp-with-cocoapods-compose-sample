package org.jetbrains.kotlin.compose.sample

import cocoapods.LoremIpsum.LoremIpsum

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun greetWithPod(): String {
        return LoremIpsum.sentence().orEmpty()
    }
}