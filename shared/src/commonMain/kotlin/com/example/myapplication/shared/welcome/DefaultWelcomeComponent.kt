package com.example.myapplication.shared.welcome

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.example.myapplication.shared.getPlatformName
import com.example.myapplication.shared.welcome.WelcomeComponent.Model
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class DefaultWelcomeComponent(
    private val componentContext: ComponentContext,
    private val onFinished: () -> Unit,
) : WelcomeComponent, ComponentContext by componentContext {

    private val settings: Settings = Settings()

    // Consider preserving and managing the state via a store
    private val state = MutableValue(Model())
    override val model: Value<Model> = state

    override fun onUpdateGreetingText() {
        state.update { it.copy(greetingText = "Welcome from ${getPlatformName()}") }
        settings["isFirstRun"] = false
    }

    override fun onBackClicked() {
        onFinished()
    }
}
