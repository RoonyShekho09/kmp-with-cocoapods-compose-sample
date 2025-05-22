package org.jetbrains.kotlin.lorem

import cocoapods.LoremIpsum.LoremIpsum

class Ipsum {

    fun name(): String {
        return LoremIpsum.name().orEmpty()
    }

    fun sentence(): String {
        return LoremIpsum.sentence().orEmpty()
    }

    fun word(): String {
        return LoremIpsum.word().orEmpty()
    }
}