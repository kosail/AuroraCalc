package com.korealm

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class MenuSidebar : VBox() {
    var onDarkModeToggle: (() -> Unit)? = null
    var onAboutClick: (() -> Unit)? = null
    private lateinit var themeChangerButton: Button

    init {
        // Set up the VBox properties (same as history sidebar)
        alignment = Pos.TOP_RIGHT
        padding = Insets(15.0)
        minHeight = 700.0
        minWidth = 200.0
        prefHeight = 700.0
        prefWidth = 200.0
        isVisible = false
        styleClass.add("menuSidebar")
        stylesheets.add(javaClass.getResource("/com/korealm/styles/dark-theme.css")?.toExternalForm())

        // Menu Title
        val title = Label("Aurora Calculator").apply {
            styleClass.add("menuTitle")
            padding = Insets(0.0, 0.0, 15.0, 15.0)
        }

        // Dark Mode Toggle Button
        themeChangerButton = Button("Light mode").apply {
            styleClass.add("menuButton")
            setOnAction { onDarkModeToggle?.invoke() }
        }

        // About Button
        val aboutButton = Button("About").apply {
            styleClass.add("menuButton")
            setOnAction { onAboutClick?.invoke() }
        }

        listOf(themeChangerButton, aboutButton).forEach {
            setMargin(it, Insets(0.0, 0.0, 10.0, 140.0))
        }

        children.addAll(title, themeChangerButton, aboutButton)
    }

    fun updateThemeText(theme: String) {
        themeChangerButton.text = if (theme == "light") "Dark Mode" else "Light Mode"
    }
}