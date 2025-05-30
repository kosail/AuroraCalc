package com.korealm

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import javafx.stage.StageStyle

class Main : Application() {
    override fun start(stage: Stage) {
        val loader = FXMLLoader(javaClass.getResource("main.fxml"))
        val root: StackPane = loader.load()
        val scene = Scene(root)

        val controller: InitController = loader.getController()
        controller.setStage(stage)
        controller.lateInitializeSteps()

        // Setting the title and icon of the app even tho the frame/title bar will be disabled and manually implemented
        stage.title = "Calculator"
        stage.icons.add(Image(javaClass.getResourceAsStream("icons/calc.png")))
        stage.initStyle(StageStyle.UNDECORATED)

        stage.scene = scene
        stage.show()

        controller.setFocusOnInputField() // Fix that I came with to maintain the focus ALWAYS in the text field, and thus the enter key will always trigger the equals button (to show results)
    }
}

fun main() {
    Application.launch(Main::class.java)
}