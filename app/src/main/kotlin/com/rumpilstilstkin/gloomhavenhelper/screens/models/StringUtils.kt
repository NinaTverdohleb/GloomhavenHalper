package com.rumpilstilstkin.gloomhavenhelper.screens.models

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.LogicalCondition

fun LogicalCondition.toHumanReadable(): String {
    if (rpnQueue.isEmpty()) return "Условий нет"

    val stack = mutableListOf<String>()

    for (token in rpnQueue) {
        when (token) {
            "!" -> {
                val operand = stack.removeAt(stack.size - 1)
                if (operand.startsWith("Достижение получено: ")) {
                    stack.add(operand.replace("Достижение получено: ", "Не получено достижение: "))
                } else {
                    stack.add("Не получено достижение: $operand")
                }
            }
            "&&" -> {
                val r = stack.removeAt(stack.size - 1)
                val l = stack.removeAt(stack.size - 1)
                stack.add("($l и $r)")
            }
            "||" -> {
                val r = stack.removeAt(stack.size - 1)
                val l = stack.removeAt(stack.size - 1)
                stack.add("($l или $r)")
            }
            else -> {
                stack.add("Достижение получено: $token")
            }
        }
    }

    return stack.firstOrNull()?.removeSurrounding("(", ")") ?: ""
}