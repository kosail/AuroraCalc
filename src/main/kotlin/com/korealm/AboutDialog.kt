package com.korealm

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.control.DialogPane
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import javafx.stage.Stage
import java.io.InputStream

class AboutDialog(owner: Stage, imagePath: InputStream): Dialog<Void>() {
    init {
        initOwner(owner) // Specify how is the parent or what will be this alert in relation to when displayed
        title = "About Aurora Calculator"
        headerText = null
        graphic = null

        dialogPane.styleClass.add("about-dialog")

        // Now the contents
        val content = VBox(10.0).apply {
            alignment = Pos.CENTER
            padding = Insets(20.0)

            // Picture
            val photo = ImageView(Image(imagePath)).apply {
                fitWidth = 250.0
                fitHeight = 250.0
                isPreserveRatio = true
            }

            // Name and description
            val nameLabel = Label("kosail").apply {
                styleClass.add("about-name")
            }

            val description = Label("""
                CS student & Kotlin developer
                Creator of korealm project
                With love, from Honduras.
                2025.
            """.trimIndent()).apply {
                styleClass.add("about-description")
                alignment = Pos.CENTER
                textAlignment = TextAlignment.CENTER
                maxWidth = 300.0
                isWrapText = true
            }

            // App info
            val appInfo = Label("""
                Aurora Calculator
                A simple, sleek and modern calculator.
                Version 1.0 Alpha
                © 2025 Korealm
            """.trimIndent()).apply {
                styleClass.add("about-app-info")
            }

            children.addAll(photo, nameLabel, description, appInfo)
        }

        dialogPane.content = content
        dialogPane.buttonTypes.add(ButtonType("Close"))
    }
}