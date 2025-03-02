package com.korealm

import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox
import javafx.scene.layout.Priority

/*
* TODO: Current status of the History Sidebar
*  It works in the sense that I fixed all the issues and it is now instantiating and initializing well. However, for some reason it initializes visible instead of hid.
* Another issue is that it is not adding the history elements to the ObservableList, and thus they are not showing.
*
* CURRENTLY WORKING AT: Visibility of each history element
*/

class HistorySidebar : VBox() {
    private val historyScrollPane: ScrollPane
    private val historyContainer: VBox
    private val items: ObservableList<String> = FXCollections.observableArrayList()

    init {
        // Set up the VBox properties
        alignment = javafx.geometry.Pos.TOP_RIGHT
        minHeight = 700.0
        minWidth = 200.0
        prefHeight = 700.0
        prefWidth = 200.0
        stylesheets.add(javaClass.getResource("styles/sidebar.css")?.toExternalForm())
        isVisible = false

        // Create the ScrollPane
        historyScrollPane = ScrollPane().apply {
            prefHeight = 200.0
            prefWidth = 200.0
            setVgrow(this, Priority.ALWAYS)
        }

        // Create the inner VBox (historyContainer)
        historyContainer = VBox().apply {
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            minHeight = Double.NEGATIVE_INFINITY
            minWidth = Double.NEGATIVE_INFINITY
            prefHeight = 700.0
            prefWidth = 200.0
            isVisible = false
        }

        // Set the content of the ScrollPane
        historyScrollPane.content = historyContainer

        // Add the ScrollPane to the VBox
        children.add(historyScrollPane)

        // Configuring the ObservableArrayList
        items.addListener(ListChangeListener { change ->
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved() || change.wasUpdated()) {
                    // TODO: CORRECT THIS SHIT (THE LINES BELOW)
                    for (item in items) {
                        val label = Label().apply {
                            text = item
                        }

                        historyContainer.children.add(label)
                    }
                }
            }
        })
    }

    fun addHistoryItem(item: String) = items.add(item)
}
