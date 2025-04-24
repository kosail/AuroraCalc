package com.korealm

import javafx.animation.TranslateTransition
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
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import javafx.util.Duration
import java.io.InputStream
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
    @FXML private lateinit var rootContainer: StackPane
    private lateinit var stage: Stage
    private val lastOperation = LastChangeRequester(LastChangeRequester.Status.SYSTEM_MADE)

    private val historySidebar = HistorySidebar()
    private val menuSidebar = MenuSidebar()

    private var theme = "dark" // Default to dark mode
    @FXML private lateinit var gridPaneNumPad: GridPane

    @FXML fun initialize() {
        // Setting the icons in the title bar buttons
        updateIconTheme(theme)
        gridPaneNumPad.padding = Insets(0.0,5.0,8.0,5.0) // Adding some padding at the bottom 'cuz for some reason it has none.

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

        // Whenever the TextField handles a Keyboard Event, update the status of the last requester to user-made.
        inputField.textProperty().addListener { _, _, newValue ->
            if (newValue.isNotEmpty()) {
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }
        }

        inputField.addEventFilter(KeyEvent.KEY_PRESSED) { event ->
            if (event.code == KeyCode.ENTER) {
                if (NumPad.equalsButtonPressed(lastOperation, inputField, lastOperationLabel)) {
                    historySidebar.addHistoryItem("%s\n\t= %s".format(lastOperationLabel.text, inputField.text))
                }

                setFocusOnInputField()
                inputField.positionCaret(inputField.text.length)
            }
        }

        // ###########################################
        // #### HISTORY AND MENU BUTTONS SECTION #####
        // ###########################################
        historyButton.setOnAction { toggleHistorySidebar(rootContainer) }
        menuButton.setOnAction { toggleMenuSidebar(rootContainer) }

        // The code below is to be able to close the history sidebar in alternative ways, since it does not have any closing button
        rootContainer.addEventFilter(KeyEvent.KEY_PRESSED) { event ->
            if (event.code == KeyCode.ESCAPE) {
                if (historySidebar.isVisible) toggleHistorySidebar(rootContainer)

                if (menuSidebar.isVisible) toggleMenuSidebar(rootContainer)
            }
        }

        rootContainer.addEventFilter(MouseEvent.MOUSE_PRESSED) { event ->
            if (historySidebar.isVisible && !historySidebar.boundsInParent.contains(event.x, event.y)) {
                toggleHistorySidebar(rootContainer)
            }

            if (menuSidebar.isVisible && !menuSidebar.boundsInParent.contains(event.x, event.y)) {
                toggleMenuSidebar(rootContainer)
            }
        }

    }

    fun lateInitializeSteps() {
        // ##### HISTORY SIDEBAR SECTION ######
        historySidebar.apply {
            translateX = rootContainer.width // Start off-screen on the right side of the app
            isVisible = false
            isManaged = false
            prefHeightProperty().bind(rootContainer.heightProperty()) // Bind this sidebar to the height of the parent root

            // Handle clicks on history items
            onHistoryItemClick = { result ->
                inputField.text = result.second
                lastOperationLabel.text = result.first
                toggleHistorySidebar(rootContainer) // Close the sidebar after selecting
                setFocusOnInputField()
            }
        }

        // ##### MENU SIDEBAR SECTION ######
        menuSidebar.apply {
            translateX = -prefWidth // Start off-screen on the left side of the app
            isVisible = false
            isManaged = false
            prefHeightProperty().bind(rootContainer.heightProperty())

            onDarkModeToggle = { toggleDarkMode() }
            onAboutClick = { showAboutPopup() }
        }

        rootContainer.children.addAll(historySidebar, menuSidebar)
    }

    fun setStage(stage: Stage) {
        this.stage = stage
    }

    fun setFocusOnInputField() {
        inputField.requestFocus()
        inputField.positionCaret(inputField.text.length) // Move the caret to the end of the text.
    }

    // TODO: There is a bug here. The menu is showing up half cutted. I have no idea where the issue is.
    private fun toggleHistorySidebar(rootContainer: StackPane) {
        if (!historySidebar.isVisible) {
            historySidebar.isVisible = true
            historySidebar.isManaged = true
            val slideIn = TranslateTransition(Duration.millis(300.0), historySidebar)
            slideIn.fromX = rootContainer.width
            slideIn.toX = rootContainer.width * 0.3
            slideIn.play()
        } else {
            val slideOut = TranslateTransition(Duration.millis(300.0), historySidebar)
            slideOut.fromX = rootContainer.width * 0.3
            slideOut.toX = rootContainer.width
            slideOut.onFinished = EventHandler {
                historySidebar.isVisible = false
                historySidebar.isManaged = false
            }
            slideOut.play()
            setFocusOnInputField()
        }
    }

    private fun toggleMenuSidebar(rootContainer: StackPane) {
        if (!menuSidebar.isVisible) {
            // Close history sidebar if open
            if (historySidebar.isVisible) {
                toggleHistorySidebar(rootContainer)
            }

            menuSidebar.isVisible = true
            menuSidebar.isManaged = true
            val slideIn = TranslateTransition(Duration.millis(300.0), menuSidebar)
            slideIn.fromX = -menuSidebar.prefWidth // Start from left off-screen
            slideIn.toX = menuSidebar.translateX * 0.8 // Slide in to left edge
            slideIn.play()
        } else {
            val slideOut = TranslateTransition(Duration.millis(300.0), menuSidebar)
            slideOut.fromX = menuSidebar.translateX * 0.7
            slideOut.toX = -menuSidebar.prefWidth
            slideOut.onFinished = EventHandler {
                menuSidebar.isVisible = false
                menuSidebar.isManaged = false
            }
            slideOut.play()
            setFocusOnInputField()
        }
    }

    private fun toggleDarkMode() {
        theme = if (theme == "dark") "light" else "dark"
        val css = javaClass.getResource("styles/$theme-theme.css")?.toExternalForm()

        listOf(rootContainer, gridPaneNumPad, historySidebar, menuSidebar).forEach {
            it.stylesheets.clear()
            it.stylesheets.add(css)
        }

        menuSidebar.updateThemeText(theme)
        updateIconTheme(theme)
        toggleMenuSidebar(rootContainer) // Close after selection
    }

    private fun updateIconTheme(theme: String) {
        val minimizeIcon = Image(javaClass.getResource("icons/minimize_$theme.png")?.toExternalForm(), 24.0, 24.0, true, true)
        val maximizeIcon = Image(javaClass.getResource("icons/maximize_$theme.png")?.toExternalForm(), 24.0, 24.0, true, true)
        val closeIcon = Image(javaClass.getResource("icons/close_$theme.png")?.toExternalForm(), 24.0, 24.0, true, true)

        minimizeButton.graphic = ImageView(minimizeIcon)
        maximizeButton.graphic = ImageView(maximizeIcon)
        closeButton.graphic = ImageView(closeIcon)

        // Section for setting the icons in the menu and history buttons
        val menuIcon = Image(javaClass.getResource("icons/menu_$theme.png")?.toExternalForm(), 24.0, 24.0, true, true)
        val historyIcon = Image(javaClass.getResource("icons/history_$theme.png")?.toExternalForm(), 24.0, 24.0, true, true)

        menuButton.graphic = ImageView(menuIcon)
        historyButton.graphic = ImageView(historyIcon)
    }

    private fun showAboutPopup() {
        /* I'm handling the input stream to the AboutDialog class from here because for some reason that I really can't understand, the program is able to get the image from here, but not from the constructor of the AboutDialog class.
        * No matter what I do, it just does not work.
        * TODO: Search wth is happening there. Is it related to the modules and permissions system (module-info.java)?
        *  It doesn't make sense. I already tried adding "opens com.korealm.images to javafx.graphics" to module-info.java but it doesn't work at all.
        *
        *  Pdt: I really hate NullPointerExceptions from JavaFX all around in Kotlin, because that's the way in which JavaFX was built. And on top of it, JavaFX traces are not that intuitive. Born to $$$$ forced to debug weird NullPointerExceptions.
        */
        val imagePath: InputStream = javaClass.getResourceAsStream("images/me.png")
        val aboutDialog = AboutDialog(stage, imagePath)

        // The custom CSS of the dialog. It was not injected in the class init, but here
        theme = if (theme == "dark") "dark" else "light"
        aboutDialog.dialogPane.stylesheets.add(
            javaClass.getResource("styles/$theme-theme.css")?.toExternalForm()
        )

        toggleMenuSidebar(rootContainer) // Close the menu before showing the popup
        aboutDialog.showAndWait()
    }
}