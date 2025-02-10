package com.korealm

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.stage.StageStyle

class Main : Application() {
    override fun start(stage: Stage) {
        println(javaClass.getResource(""))
        val loader = FXMLLoader(javaClass.getResource("main.fxml"))
        val root: VBox = loader.load()
        val scene = Scene(root)

        val controller: InitController = loader.getController()
        controller.setStage(stage)

        // Setting the title and icon of the app even tho the frame/title bar will be disabled and manually implemented
        stage.title = "Calculator"
        stage.icons.add(Image(javaClass.getResourceAsStream("icons/calc.png")))
        stage.initStyle(StageStyle.UNDECORATED)

        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(Main::class.java)
}