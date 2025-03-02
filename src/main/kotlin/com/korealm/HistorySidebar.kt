package com.korealm

import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.VBox

/*
* TODO: Current status of the History Sidebar
* CURRENTLY WORKING AT: Styling of history sidebar
*/

class HistorySidebar : VBox() {
    private val items: ObservableList<String> = FXCollections.observableArrayList()

    init {
        // Set up the VBox properties
        alignment = javafx.geometry.Pos.TOP_RIGHT
        minHeight = 700.0
        minWidth = 200.0
        prefHeight = 700.0
        prefWidth = 200.00
        isVisible = false
        styleClass.add("historySidebar")
        stylesheets.add(javaClass.getResource("/com/korealm/styles/sidebar.css")?.toExternalForm())

        // Configuring the ObservableArrayList
        items.addListener(ListChangeListener { change ->
            while (change.next()) {
                if (change.wasAdded()) {
                    for (item in change.addedSubList) {
                        val label = Label().apply {
                            text = item
                            styleClass.add("historyItem")
                            maxWidth = Double.MAX_VALUE
                            isWrapText = true
                            alignment = Pos.CENTER_RIGHT
                        }
                        children.add(label)
                    }
                }
            }
        })
    }

    fun addHistoryItem(item: String) = items.add(item)
}
