package com.example.myapplication.shared.unlock

import com.arkivanov.decompose.value.Value

interface UnlockComponent {
    val model: Value<Model>

    fun onUpdateGreetingText()
    fun onBackClicked()

    data class Model(
        val greetingText: String = "Unlock from Decompose!",
    )
}
