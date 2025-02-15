package com.korealm

import javafx.application.Platform
import javafx.scene.control.Label
import javafx.scene.control.TextField
import net.objecthunter.exp4j.ExpressionBuilder

class NumPadController {
    companion object {
        fun zeroButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (inputField.text.isEmpty()) return

            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            // Add the number in a more pretty way to the user. This adds unnecessary complexity, but makes things eye-appealing
            if (inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁰")
                return
            }

            inputField.appendText("0")
        }

        fun oneButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("¹")
                return
            }

            inputField.appendText("1")
        }

        fun twoButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("²")
                return
            }

            inputField.appendText("2")
        }

        fun threeButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("³")
                return
            }

            inputField.appendText("3")
        }

        fun fourButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁴")
                return
            }

            inputField.appendText("4")
        }

        fun fiveButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁵")
                return
            }

            inputField.appendText("5")
        }

        fun sixButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁶")
                return
            }

            inputField.appendText("6")
        }

        fun sevenButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁷")
                return
            }

            inputField.appendText("7")
        }

        fun eightButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁸")
                return
            }

            inputField.appendText("8")
        }

        fun nineButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            if (inputField.text.isNotBlank() && inputField.text.last() == '^') {
                eraseButtonPressed(lastOperation, inputField)
                inputField.appendText("⁹")
                return
            }

            inputField.appendText("9")
        }

        fun periodButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE || inputField.text.isEmpty()) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
                inputField.appendText("0.")
                return
            }

            inputField.appendText(".")
        }

        fun plusButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            lastOperation.state = LastChangeRequester.Status.USER_MADE
            inputField.appendText("+")
        }

        fun minusButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            lastOperation.state = LastChangeRequester.Status.USER_MADE
            inputField.appendText("-")
        }

        fun multiplyButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            lastOperation.state = LastChangeRequester.Status.USER_MADE
            inputField.appendText("*")
        }

        fun divideButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            lastOperation.state = LastChangeRequester.Status.USER_MADE
            inputField.appendText("/")
        }

        fun equalsButtonPressed(lastOperation: LastChangeRequester, inputField: TextField, lastOperationLabel: Label) {
            val expression = inputField.text.replaceSuperscripts()
            if (expression.isBlank()) return
            if (expression.last().isLetter()) return

            for (i in expression.lastIndex downTo 0) {
                if (expression[i].isLetter()) return // This will kill any support for the e number... but good enough for now.
            }

            val result = ExpressionBuilder(expression).build().evaluate()
            lastOperationLabel.text = expression
            inputField.clear()
            inputField.text = if ((result % 1) != 0.0) "%.2f".format(result) else result.toInt().toString()
            lastOperation.state = LastChangeRequester.Status.USER_MADE
        }

        fun ceButtonPressed(inputField: TextField) { inputField.clear() }

        fun clearButtonPressed(inputField: TextField, lastOperationLabel: Label) {
            inputField.clear()
            lastOperationLabel.text = ""
        }

        fun eraseButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (inputField.text.isBlank()) return
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                return
            }

            inputField.text = inputField.text.substring(0, inputField.text.length - 1)
        }

        fun exponentialButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (inputField.text.isBlank()) return

            lastOperation.state = LastChangeRequester.Status.USER_MADE

            // Use Platform.runLater to ensure the TextField is updated before checking the last character
            Platform.runLater {
                // Check if the last character is already '^'
                if (inputField.text.isNotEmpty() && inputField.text.last() == '^') {
                    // Remove the last '^' character
                    eraseButtonPressed(lastOperation, inputField)
                } else {
                    // Append '^' to the inputField
                    inputField.appendText("^")
                }
            }
        }

        private fun String.replaceSuperscripts(): String {
            val superScriptList: List<String> = listOf("⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹")
            var result = this // Start with the original string

            // Iterate over each superscript and replace it with the corresponding "^number"
            for (i in superScriptList.indices) {
                result = result.replace(superScriptList[i], "^$i")
            }

            return result
        }
    }
}