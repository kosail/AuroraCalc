package com.korealm

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView

// I had no idea on how to instanciate all these fields in separated files, as Scene Builder asks for one Controller class only.
// Base on that, I decided to instanciate all the objects and initialize them here, and after that separate the logic of each part of the app into their respective file.
// Even so... ugh, I'll be forced to make all vars public to be able to access them
class InitController {

    // #######################
    // ### Task bar section ##
    // #######################
    @FXML private lateinit var minimizeButton: Button;
    @FXML private lateinit var maximizeButton: Button;
    @FXML private lateinit var closeButton: Button;


    // #######################
    // ### Top bar section ###
    // #######################
    @FXML private lateinit var menuButton: Button;
    @FXML private lateinit var historyButton: Button;

    // #######################
    // ### Display section ###
    // #######################
    @FXML private lateinit var lastOperationLabel: Label;
    @FXML private lateinit var inputField: TextField;

    // #######################
    // ### GridPane section ##
    // #######################
    @FXML private lateinit var percentageButton: Button;
    @FXML private lateinit var ceButton: Button;
    @FXML private lateinit var clearButton: Button;
    @FXML private lateinit var eraseButton: Button;

    @FXML private lateinit var fractionButton: Button;
    @FXML private lateinit var exponentialButton: Button;
    @FXML private lateinit var sqrtButton: Button;

    @FXML private lateinit var oneButton: Button;
    @FXML private lateinit var twoButton: Button;
    @FXML private lateinit var threeButton: Button;
    @FXML private lateinit var fourButton: Button;
    @FXML private lateinit var fiveButton: Button;
    @FXML private lateinit var sixButton: Button;
    @FXML private lateinit var sevenButton: Button;
    @FXML private lateinit var eightButton: Button;
    @FXML private lateinit var nineButton: Button;

    @FXML private lateinit var zeroButton: Button;
    @FXML private lateinit var periodButton: Button;
    @FXML private lateinit var plusMinusButton: Button;

    @FXML private lateinit var equalsButton: Button;
    @FXML private lateinit var plusButton: Button;
    @FXML private lateinit var minusButton: Button;
    @FXML private lateinit var multiplyButton: Button;
    @FXML private lateinit var divideButton: Button;

    @FXML fun initialize() {
        // Section for setting the icons in the title bar buttons
        val minimizeIcon = Image(javaClass.getResource("icons/minimize.png").toExternalForm(), 24.0, 24.0, true, true)
        val maximizeIcon = Image(javaClass.getResource("icons/maximize.png").toExternalForm(), 24.0, 24.0, true, true)
        val closeIcon = Image(javaClass.getResource("icons/close.png").toExternalForm(), 24.0, 24.0, true, true)

        minimizeButton.graphic = ImageView(minimizeIcon);
        maximizeButton.graphic = ImageView(maximizeIcon);
        closeButton.graphic = ImageView(closeIcon);

        // Section for setting the icons in the menu and history buttons
        val menuIcon = Image(javaClass.getResource("icons/menu.png").toExternalForm(), 24.0, 24.0, true, true)
        val historyIcon = Image(javaClass.getResource("icons/history.png").toExternalForm(), 24.0, 24.0, true, true)

        menuButton.graphic = ImageView(menuIcon)
        historyButton.graphic = ImageView(historyIcon)
    }
}