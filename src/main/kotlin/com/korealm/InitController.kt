package com.korealm

import javafx.animation.TranslateTransition
import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
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
import javafx.event.EventHandler
import javafx.stage.Stage
import javafx.util.Duration
import com.korealm.NumPadController as NumPad

/* I had no idea on how to instance all these fields in separated files, as Scene Builder asks for one Controller class only.
* Base on that, I decided to instance all the objects and initialize them here. After completing all, I'll try to separate the logic of each part of the app into their respective file.
* TODO: Implement the menu and the history button
*  CURRENTLY WORKING AT: HistorySidebar.kt
*/

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
    private lateinit var rootContainer: VBox
    private val lastOperation = LastChangeRequester(LastChangeRequester.Status.SYSTEM_MADE)
    private val historySidebar = HistorySidebar()

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
//        historyButton.setOnAction { alertOfNightlyBuild(stage) }

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
        equalsButton.setOnAction {
            if (NumPad.equalsButtonPressed(lastOperation, inputField, lastOperationLabel)) {
                // TODO: Correct this to add elements to the history
                historySidebar.addHistoryItem("%s\n\t= %s".format(lastOperationLabel.text, inputField.text))
            }

            setFocusOnInputField()
        }
        ceButton.setOnAction { NumPad.ceButtonPressed(inputField); setFocusOnInputField() }
        clearButton.setOnAction { NumPad.clearButtonPressed(inputField, lastOperationLabel); setFocusOnInputField() }
        eraseButton.setOnAction { NumPad.eraseButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        exponentialButton.setOnAction { NumPad.exponentialButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        sqrtButton.setOnAction { NumPad.sqrtButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        fractionButton.setOnAction { NumPad.divideButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        percentageButton.setOnAction { NumPad.percentageButtonPressed(lastOperation, inputField); setFocusOnInputField() }
        plusMinusButton.setOnAction { NumPad.plusMinusButtonPressed(lastOperation, inputField); setFocusOnInputField() }

        // Whenever the TextField handles a Keyboard Event, update the status of the last requester to user.
        inputField.textProperty().addListener { _, _, newValue ->
            if (newValue.isNotEmpty()) {
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }
        }

        inputField.addEventFilter(KeyEvent.KEY_PRESSED) { event ->
            if (event.code == KeyCode.ENTER) {
                if (NumPad.equalsButtonPressed(lastOperation, inputField, lastOperationLabel)) {
                    // TODO: Correct this
                    historySidebar.addHistoryItem("%s\n\t= %s".format(lastOperationLabel.text, inputField.text))
                }

                setFocusOnInputField()
                inputField.positionCaret(inputField.text.length)
            }
        }

        // ################################
        // ## HISTORY BUTTON SECTION ######
        // ################################
        // TODO: FIX
        historyButton.setOnAction { toggleHistorySidebar(rootContainer) }
    }

    fun lateInitializeSteps() {
        historySidebar.apply {
            translateXProperty().set(300.0) // Start off-screen
            prefHeightProperty().bind(rootContainer.heightProperty()) // Bind this sidebar to the height of the parent root
            isVisible = false
            isManaged = false
            translateX = 300.0 // Start off-screen

        }

        rootContainer.children.add(historySidebar) // Add this sidebar for once and all
    }

    fun setStage(stage: Stage) {
        this.stage = stage
    }

    fun setRootContainer(rootContainer: VBox) {
        this.rootContainer = rootContainer
    }

    fun setFocusOnInputField() {
        inputField.requestFocus()
        inputField.positionCaret(inputField.text.length) // Move caret to the end of the text.
    }

    private fun toggleHistorySidebar(rootContainer: VBox) {
        if (!historySidebar.isVisible) {
            historySidebar.isVisible = true
            historySidebar.isManaged = true
            val slideIn = TranslateTransition(Duration.millis(300.0), historySidebar)
            slideIn.fromX = 300.0
            slideIn.toX = 0.0
            slideIn.play()
        } else {
            val slideOut = TranslateTransition(Duration.millis(300.0), historySidebar)
            slideOut.fromX = 0.0
            slideOut.toX = 300.0
            slideOut.onFinished = EventHandler {
                historySidebar.isVisible = false
                historySidebar.isManaged = false
            }
            slideOut.play()
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