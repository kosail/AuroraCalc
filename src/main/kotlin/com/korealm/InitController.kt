package com.korealm

import com.korealm.NumPadController.Companion.divideButtonPressed
import com.korealm.NumPadController.Companion.eightButtonPressed
import com.korealm.NumPadController.Companion.equalsButtonPressed
import com.korealm.NumPadController.Companion.eraseButtonPressed
import com.korealm.NumPadController.Companion.fiveButtonPressed
import com.korealm.NumPadController.Companion.fourButtonPressed
import com.korealm.NumPadController.Companion.minusButtonPressed
import com.korealm.NumPadController.Companion.multiplyButtonPressed
import com.korealm.NumPadController.Companion.nineButtonPressed
import com.korealm.NumPadController.Companion.oneButtonPressed
import com.korealm.NumPadController.Companion.periodButtonPressed
import com.korealm.NumPadController.Companion.plusButtonPressed
import com.korealm.NumPadController.Companion.sevenButtonPressed
import com.korealm.NumPadController.Companion.sixButtonPressed
import com.korealm.NumPadController.Companion.threeButtonPressed
import com.korealm.NumPadController.Companion.twoButtonPressed
import com.korealm.NumPadController.Companion.zeroButtonPressed
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import com.korealm.NumPadController as NumPad

// I had no idea on how to instance all these fields in separated files, as Scene Builder asks for one Controller class only.
// Base on that, I decided to instance all the objects and initialize them here. After completing all, I'll try to separate the logic of each part of the app into their respective file.

class InitController {
    // #######################
    // ### Task bar section ##
    // #######################
    @FXML private lateinit var minimizeButton: Button
    @FXML private lateinit var maximizeButton: Button
    @FXML private lateinit var closeButton: Button
    @FXML private lateinit var taskBarHBox: HBox
    private var windowXOffset: Double = 0.0
    private var windowYOffset: Double = 0.0

    // #######################
    // ### Top bar section ###
    // #######################
    @FXML private lateinit var menuButton: Button
    @FXML private lateinit var historyButton: Button

    // #######################
    // ### Display section ###
    // #######################
    @FXML private lateinit var lastOperationLabel: Label
    @FXML private lateinit var inputField: TextField

    // #######################
    // ### GridPane section ##
    // #######################
    @FXML private lateinit var percentageButton: Button
    @FXML private lateinit var ceButton: Button
    @FXML private lateinit var clearButton: Button
    @FXML private lateinit var eraseButton: Button

    @FXML private lateinit var fractionButton: Button
    @FXML private lateinit var exponentialButton: Button
    @FXML private lateinit var sqrtButton: Button

    @FXML private lateinit var oneButton: Button
    @FXML private lateinit var twoButton: Button
    @FXML private lateinit var threeButton: Button
    @FXML private lateinit var fourButton: Button
    @FXML private lateinit var fiveButton: Button
    @FXML private lateinit var sixButton: Button
    @FXML private lateinit var sevenButton: Button
    @FXML private lateinit var eightButton: Button
    @FXML private lateinit var nineButton: Button

    @FXML private lateinit var zeroButton: Button
    @FXML private lateinit var periodButton: Button
    @FXML private lateinit var plusMinusButton: Button

    @FXML private lateinit var equalsButton: Button
    @FXML private lateinit var plusButton: Button
    @FXML private lateinit var minusButton: Button
    @FXML private lateinit var multiplyButton: Button
    @FXML private lateinit var divideButton: Button

    // Miscellaneous for functionalities
    private lateinit var stage: Stage
    private lateinit var root: VBox
    private val lastOperation = LastChangeRequester(LastChangeRequester.Status.SYSTEM_MADE)


    @FXML fun initialize() {
        // #######################
        // ## ICONS SECTION ######
        // #######################
        // Section for setting the icons in the title bar buttons
        val minimizeIcon = Image(javaClass.getResource("icons/minimize.png").toExternalForm(), 24.0, 24.0, true, true)
        val maximizeIcon = Image(javaClass.getResource("icons/maximize.png").toExternalForm(), 24.0, 24.0, true, true)
        val closeIcon = Image(javaClass.getResource("icons/close.png").toExternalForm(), 24.0, 24.0, true, true)

        minimizeButton.graphic = ImageView(minimizeIcon)
        maximizeButton.graphic = ImageView(maximizeIcon)
        closeButton.graphic = ImageView(closeIcon)

        // Section for setting the icons in the menu and history buttons
        val menuIcon = Image(javaClass.getResource("icons/menu.png").toExternalForm(), 24.0, 24.0, true, true)
        val historyIcon = Image(javaClass.getResource("icons/history.png").toExternalForm(), 24.0, 24.0, true, true)

        menuButton.graphic = ImageView(menuIcon)
        historyButton.graphic = ImageView(historyIcon)


        // ###############################
        // ## BASE BEHAVIOR SECTION ######
        // ###############################
        // Section for adding events to the title bar buttons
        minimizeButton.setOnAction { stage.isIconified = true }
        maximizeButton.setOnAction { stage.isMaximized = !stage.isMaximized }
        closeButton.setOnAction { stage.close() }

        // To make the window draggable
        taskBarHBox.setOnMousePressed { event ->
            windowXOffset = event.sceneX
            windowYOffset = event.sceneY
        }

        taskBarHBox.setOnMouseDragged { event ->
            stage.x = event.screenX - windowXOffset
            stage.y = event.screenY - windowYOffset
        }

        // This as a reminder to myself of implement this in the future.
        menuButton.setOnAction { alertOfNightlyBuild(stage) }
        historyButton.setOnAction { alertOfNightlyBuild(stage) }

        // ###################################
        // ## BUTTONS LISTENERS SECTION ######
        // ###################################

        zeroButton.setOnAction { NumPad.zeroButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        oneButton.setOnAction { NumPad.oneButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        twoButton.setOnAction { NumPad.twoButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        threeButton.setOnAction { NumPad.threeButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        fourButton.setOnAction { NumPad.fourButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        fiveButton.setOnAction { NumPad.fiveButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        sixButton.setOnAction { NumPad.sixButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        sevenButton.setOnAction { NumPad.sevenButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        eightButton.setOnAction { NumPad.eightButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        nineButton.setOnAction { NumPad.nineButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        periodButton.setOnAction { NumPad.periodButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        plusButton.setOnAction { NumPad.plusButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        minusButton.setOnAction { NumPad.minusButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        multiplyButton.setOnAction { NumPad.multiplyButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        divideButton.setOnAction { NumPad.divideButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        equalsButton.setOnAction { NumPad.equalsButtonPressed(lastOperation, inputField, lastOperationLabel); setFocusOnInputField() }
        ceButton.setOnAction { NumPad.ceButtonPressed(inputField); setFocusOnInputField() }
        clearButton.setOnAction { NumPad.clearButtonPressed(inputField, lastOperationLabel); setFocusOnInputField() }
        eraseButton.setOnAction { NumPad.eraseButtonPressed(lastOperation, inputField); setFocusOnInputField() }

        // Add a focus listener to the inputField to avoid the default selection of the entire text inside the TextField when gaining focus
        inputField.focusedProperty().addListener { _, _, isFocused ->
            if (isFocused) {
                // Move the caret to the end of the text when the inputField gains focus
                inputField.positionCaret(inputField.text.length)
            }
        }

        // Add a listener because the app buttons are updating the value of lastOperation, but the key events are not.
        // Tbh I don't fully understand why this is happening, but apparently is something related to internals of JavaFX, that when triggered from keyboard the inputField values are updated by JavaFX instead of being by the methods I defined.
        inputField.textProperty().addListener { _, _, newValue ->
            if (newValue.isNotEmpty()) {
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }
        }
    }

    fun setStage(stage: Stage) {
        this.stage = stage
    }

    fun setFocusOnInputField() {
        inputField.requestFocus()
        inputField.positionCaret(inputField.text.length) // Move caret to the end of the text.
    }

    fun physicalKeyPadOnKeyPress(event: KeyEvent) {
        when (event.code) {
            KeyCode.DIGIT0 -> zeroButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT1 -> oneButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT2 -> twoButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT3 -> threeButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT4 -> fourButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT5 -> fiveButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT6 -> sixButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT7 -> sevenButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT8 -> eightButtonPressed(lastOperation, inputField)
            KeyCode.DIGIT9 -> nineButtonPressed(lastOperation, inputField)
            KeyCode.PERIOD -> periodButtonPressed(lastOperation, inputField)
            KeyCode.PLUS -> plusButtonPressed(lastOperation, inputField)
            KeyCode.MINUS -> minusButtonPressed(lastOperation, inputField)
            KeyCode.MULTIPLY -> multiplyButtonPressed(lastOperation, inputField)
            KeyCode.DIVIDE -> divideButtonPressed(lastOperation, inputField)
            KeyCode.EQUALS -> equalsButtonPressed(lastOperation, inputField, lastOperationLabel)
            KeyCode.BACK_SPACE -> eraseButtonPressed(lastOperation, inputField)
            KeyCode.ENTER -> {
                equalsButtonPressed(lastOperation, inputField, lastOperationLabel)
                setFocusOnInputField()
            }
            else -> System.err.println("Unknown physical key: ${event.code}")
        }
    }

    private fun alertOfNightlyBuild(stage: Stage) {
        val alertDialog = Alert(Alert.AlertType.INFORMATION)
        alertDialog.title = "In construction"
        alertDialog.headerText = "This function is still not implemented."
        alertDialog.initOwner(stage)
        alertDialog.show()
    }
}