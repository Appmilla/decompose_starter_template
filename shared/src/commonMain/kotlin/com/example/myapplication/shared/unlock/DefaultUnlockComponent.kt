package com.example.myapplication.shared.unlock

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.example.myapplication.shared.getPlatformName

class DefaultUnlockComponent(
    private val componentContext: ComponentContext,
    private val onFinished: () -> Unit,
) : UnlockComponent, ComponentContext by componentContext {

    // Consider preserving and managing the state via a store
    private val state = MutableValue(UnlockComponent.Model())
    override val model: Value<UnlockComponent.Model> = state

    override fun onUpdateGreetingText() {
        state.update { it.copy(greetingText = "Unlock from ${getPlatformName()}") }
    }

    override fun onBackClicked() {
        onFinished()
    }
}
