package com.korealm

import javafx.application.Platform
import javafx.scene.control.Label
import javafx.scene.control.TextField
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException

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

        fun equalsButtonPressed(lastOperation: LastChangeRequester, inputField: TextField, lastOperationLabel: Label): Boolean {
            if (inputField.text.isBlank()) return false

            if (inputField.text.last() == '%') {
                inputField.text = inputField.text.dropLast(1)
                percentageButtonPressed(lastOperation, inputField)
            }

            val expression = inputField.text.replaceSuperscripts().replaceSqrtSymbol()
            val result: Double

            try {
                result = ExpressionBuilder(expression).build().evaluate()
            } catch (e: UnknownFunctionOrVariableException) {
                System.err.println("Unknown function or variable: ${e.message}")
                return false
            } catch (e: IllegalArgumentException) {
                System.err.println("Invalid function or variable: ${e.message}")
                return false
            } catch (e: ArithmeticException) {
                System.err.println("Impossible to compute.\nArithmetic exception: ${e.message}")
                inputField.clear()
                return false
            }

            lastOperationLabel.text = expression
            inputField.clear()
            inputField.text = if ((result % 1) != 0.0) "%.2f".format(result) else result.toInt().toString()
            lastOperation.state = LastChangeRequester.Status.USER_MADE

            return true
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

        private fun String.replaceSqrtSymbol(): String {
            var result = this
            result = result.replace("√", "sqrt")

            return result
        }

        fun sqrtButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE && inputField.text.isNotBlank()) {
                inputField.clear()
                return
            }

            inputField.appendText("√")
        }

        fun percentageButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (inputField.text.isBlank()) return

            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            val lastNumber = inputField.text.split('+', '-', '*', '/').last().trim()
            val percentageValue = lastNumber.toDoubleOrNull() ?: return

            val result = percentageValue / 100
            inputField.text = inputField.text.dropLast(lastNumber.length) + result.toString()
        }

        fun plusMinusButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            var text = inputField.text
            if (text.isBlank()) return

            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            val lastNumber = text.split('+', '-', '*', '/').last().trim()
            text = text.dropLast(lastNumber.length)

            // If there is only one number
            if (text.isBlank()) {
                text = "-$lastNumber"
            }

            // There is only one number AND it is negative
            if (text.last() == '-' && text.length == 1) {
                text = text.dropLast(1)
                text += lastNumber
            }

            // If there is an expression (more than one number [not digit, but number]), and it is possitive, change the sign
            if (text.last() == '+') {
                text = text.dropLast(1)
                text += "-$lastNumber"
            }

            // If the last sign is negative AND it is an expression
            if (text.last() == '-' && text.length > 1) {
                text = text.dropLast(1)
                text += "+$lastNumber"
            }

            inputField.text = text
        }
    }
}