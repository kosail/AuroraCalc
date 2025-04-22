package com.korealm

import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.input.MouseEvent

/*
* TODO: Current status of the History Sidebar
* CURRENTLY WORKING AT: The label's history element is not showing now... man
*/

class HistorySidebar : VBox() {
    private val items: ObservableList<String> = FXCollections.observableArrayList()

    init {
        // Set up the VBox properties
        alignment = Pos.TOP_RIGHT
        padding = Insets(3.0)
        minHeight = 700.0
        minWidth = 200.0
        prefHeight = 700.0
        prefWidth = 200.0
//        maxWidth = 250.0
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
                            prefWidthProperty().bind(this@HistorySidebar.prefWidthProperty())
                            maxWidth = 250.0 // test
//                            maxWidthProperty().bind(this@HistorySidebar.maxWidthProperty())
                            isWrapText = true
                            alignment = Pos.CENTER_RIGHT

                            // TODO: When the element is clicked, then sets the inputField text to this label text
                            addEventFilter(MouseEvent.MOUSE_CLICKED) { event ->
                                val result: Pair<String, String> = extractResultFromHistory(text)
                                onHistoryItemClick?.invoke(result)
                            }
                        }

                        children.add(label)
                    }
                }
            }
        })
    }

    fun addHistoryItem(item: String) = items.add(item)

    private fun extractResultFromHistory(historyText: String): Pair<String,String> {
        return Pair<String,String>(
            first = historyText.substringBefore("=".trim()),
            second = historyText.substringAfter("=").trim()
        );
    }

    var onHistoryItemClick: ((Pair<String,String>) -> Unit)? = null

}
