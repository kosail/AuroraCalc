package com.korealm

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.input.MouseEvent

class MenuSidebar : VBox() {
    var onDarkModeToggle: (() -> Unit)? = null
    var onAboutClick: (() -> Unit)? = null

    init {
        // Set up the VBox properties (same as history sidebar)
        alignment = Pos.TOP_LEFT
        padding = Insets(3.0)
        minHeight = 700.0
        minWidth = 200.0
        prefHeight = 700.0
        prefWidth = 200.0
        isVisible = false
        styleClass.add("menuSidebar")
        stylesheets.add(javaClass.getResource("/com/korealm/styles/dark-theme.css")?.toExternalForm())

        // Menu Title
        val title = Label("Menu").apply {
            styleClass.add("menuTitle")
        }

        // Dark Mode Toggle Button
        val darkModeButton = Button("Dark Mode Toggle").apply {
            styleClass.add("menuButton")
            setOnAction { onDarkModeToggle?.invoke() }
        }

        // About Button
        val aboutButton = Button("About").apply {
            styleClass.add("menuButton")
            setOnAction { onAboutClick?.invoke() }
        }

        children.addAll(title, darkModeButton, aboutButton)
    }
}