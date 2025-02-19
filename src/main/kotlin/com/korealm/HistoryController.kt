package com.korealm

import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import javafx.scene.control.Button
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem

class HistoryController {
    // I'm not sure if this would be the correct way to do this, as it is not following the dependency injection design... but welp
    private val contextMenu: ContextMenu = ContextMenu()
    private val items: ObservableList<String> = FXCollections.observableArrayList()

    // Make the ObservableList the one that updates the ContextMenu on any change
    init {
        items.addListener(ListChangeListener { change ->
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved() || change.wasUpdated()) {
                    contextMenu.items.clear()

                    for (item in items) {
                        contextMenu.items.add(MenuItem(item))
                    }
                }
            }
        })
    }

    fun addHistoryItem(item: String) {
        items.add(item)
    }

    fun show(button: Button) {
        contextMenu.show(button, button.scene.window.x, button.scene.window.y)
    }
}