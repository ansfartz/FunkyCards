package com.ansfartz.funkycards.model

class Card(
    val text: String,
    val type: Type
) {

    enum class Type {
        PROMPT,
        RESPONSE
    }
}