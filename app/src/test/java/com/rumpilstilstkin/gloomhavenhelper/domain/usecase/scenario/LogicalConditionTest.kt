package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.LogicalCondition
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LogicalConditionTest {
    @Test
    fun `single achievement check`() {
        val condition = LogicalCondition("Ancient Technology")

        assertTrue(condition.evaluate(setOf("Ancient Technology")))
        assertFalse(condition.evaluate(setOf("City Rule: Militaristic")))
    }

    @Test
    fun `logical AND with spaces`() {
        val condition = LogicalCondition("City Rule: Militaristic && The Merchant's Fleets")

        // Оба есть -> true
        assertTrue(condition.evaluate(setOf("City Rule: Militaristic", "The Merchant's Fleets")))
        // Одного нет -> false
        assertFalse(condition.evaluate(setOf("City Rule: Militaristic")))
    }

    @Test
    fun `logical OR check`() {
        val condition = LogicalCondition("Achievement A || Achievement B")

        assertTrue(condition.evaluate(setOf("Achievement A")))
        assertTrue(condition.evaluate(setOf("Achievement B")))
        assertFalse(condition.evaluate(setOf("Achievement C")))
    }

    @Test
    fun `logical NOT check`() {
        val condition = LogicalCondition("!Global Achievement")

        // Достижения нет -> условие выполнено (true)
        assertTrue(condition.evaluate(setOf("Something Else")))
        // Достижение есть -> условие провалено (false)
        assertFalse(condition.evaluate(setOf("Global Achievement")))
    }

    @Test
    fun `complex priority check - NOT and AND`() {
        // !A && B должно читаться как (!A) && B
        val condition = LogicalCondition("Предложение дрейка && !Помощь дрейку")

        assertTrue(condition.evaluate(setOf("Предложение дрейка"))) // A нет, B есть -> true
        assertFalse(condition.evaluate(setOf("Предложение дрейка", "Помощь дрейку"))) // A есть -> false
    }

    @Test
    fun `parentheses priority check`() {
        // (A || B) && C
        val condition = LogicalCondition("(A || B) && C")

        assertTrue(condition.evaluate(setOf("A", "C")))
        assertTrue(condition.evaluate(setOf("B", "C")))
        assertFalse(condition.evaluate(setOf("A", "B"))) // С нет -> false
    }

    @Test
    fun `empty or blank condition`() {
        val condition = LogicalCondition("")
        assertTrue(condition.evaluate(setOf("Any")))
    }

    @Test
    fun `complex Gloomhaven scenario requirement`() {
        val raw = "(City Rule: Militaristic || !The Merchant's Fleets) && Ancient Technology"
        val condition = LogicalCondition(raw)

        val currentAchievements = setOf("Ancient Technology")
        // Пояснение: (false || !false) && true -> (false || true) && true -> true
        assertTrue(condition.evaluate(currentAchievements))

        val blockedAchievements = setOf("Ancient Technology", "The Merchant's Fleets")
        // (false || !true) && true -> (false || false) && true -> false
        assertFalse(condition.evaluate(blockedAchievements))
    }
}