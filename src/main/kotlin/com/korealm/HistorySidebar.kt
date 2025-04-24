package com.korealm

import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.input.MouseEvent

class HistorySidebar : VBox() {
    private val items: ObservableList<String> = FXCollections.observableArrayList()

    init {
        // Set up the VBox properties
        alignment = Pos.TOP_LEFT
        padding = Insets(0.0)
        minHeight = 700.0
        minWidth = 200.0
        prefHeight = 700.0
        prefWidth = 200.0
        isVisible = false
        styleClass.add("historySidebar")
        stylesheets.add(javaClass.getResource("/com/korealm/styles/dark-theme.css")?.toExternalForm())

        // Configuring the ObservableArrayList
        items.addListener(ListChangeListener { change ->
            while (change.next()) {
                if (change.wasAdded()) {
                    for (item in change.addedSubList) {
                        val label = Label().apply {
                            text = item
                            styleClass.add("historyItem")
                            minWidth = 200.0
                            maxWidth = Double.MAX_VALUE
                            prefWidth = this@HistorySidebar.prefWidth
//                            maxWidthProperty().bind(this@HistorySidebar.maxWidthProperty().subtract(6.0))
                            isWrapText = true

                            // When the element is clicked, then sets the inputField text to this label text
                            addEventFilter(MouseEvent.MOUSE_CLICKED) { event ->
                                val result: Pair<String, String> = extractResultFromHistory(text)
                                onHistoryItemClick?.invoke(result)
                            }
                        }

                        setMargin(label, Insets(0.0, 130.0, 0.0, 0.0))
                        children.add(label)
                    }
                }
            }
        })
    }

    fun addHistoryItem(item: String) = items.add(item)

    private fun extractResultFromHistory(historyText: String): Pair<String,String> {
        return Pair(
            first = historyText.substringBefore("=").trim(),
            second = historyText.substringAfter("=").trim()
        )
    }

    var onHistoryItemClick: ((Pair<String,String>) -> Unit)? = null

}
