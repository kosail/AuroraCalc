package com.korealm

import javafx.scene.control.Label
import javafx.scene.control.TextField
import net.objecthunter.exp4j.ExpressionBuilder

class NumPadController {
    companion object {
        fun zeroButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("0")
        }
        fun oneButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("1")
        }

        fun twoButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("2")
        }

        fun threeButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("3")
        }

        fun fourButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("4")
        }

        fun fiveButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("5")
        }

        fun sixButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("6")
        }

        fun sevenButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("7")
        }

        fun eightButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
            }

            inputField.appendText("8")
        }

        fun nineButtonPressed(lastOperation: LastChangeRequester, inputField: TextField) {
            if (lastOperation.state == LastChangeRequester.Status.SYSTEM_MADE) {
                inputField.clear()
                lastOperation.state = LastChangeRequester.Status.USER_MADE
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
            val expression = inputField.text
            if (expression.isBlank()) return
            if (!expression.last().isDigit()) return

            for (i in expression.lastIndex downTo 0) {
                if (expression[i].isLetter()) return // This will kill any support for the e number... but good enough for now.
            }

            val result = ExpressionBuilder(expression).build().evaluate()
            lastOperationLabel.text = expression
            inputField.clear()
            inputField.text = if ((result % 1) != 0.0) "%.2f".format(result) else Integer.toString(result.toInt())
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
    }
}