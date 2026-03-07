package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioShortInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamInfoWithScenario
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FilterTeamScenariosUseCaseTest {

    private lateinit var useCase: FilterTeamScenariosUseCase

    @Before
    fun setUp() {
        useCase = FilterTeamScenariosUseCase()
    }

    @Test
    fun `completed scenarios should be in completedScenarios list`() {
        // Given
        val team = createTeam(
            scenarios = listOf(
                createScenario(number = 1, isCompleted = true),
                createScenario(number = 2, isCompleted = true),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertEquals(2, result.completedScenarios.size)
        assertTrue(result.activeScenarios.isEmpty())
        assertTrue(result.blockedScenarios.isEmpty())
    }

    @Test
    fun `scenario without requirements should be active`() {
        // Given
        val team = createTeam(
            scenarios = listOf(
                createScenario(number = 1, requirements = ""),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertEquals(1, result.activeScenarios.size)
        assertEquals(1, result.activeScenarios.first().scenarioNumber)
        assertTrue(result.blockedScenarios.isEmpty())
    }

    @Test
    fun `scenario with met requirements should be active`() {
        // Given
        val team = createTeam(
            teamAchievement = "Achievement1, Achievement2",
            scenarios = listOf(
                createScenario(number = 1, requirements = "Achievement1"),
                createScenario(number = 2, requirements = "Achievement1, Achievement2"),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertEquals(2, result.activeScenarios.size)
        assertTrue(result.blockedScenarios.isEmpty())
    }

    @Test
    fun `scenario with unmet requirements should be blocked`() {
        // Given
        val team = createTeam(
            teamAchievement = "Achievement1",
            scenarios = listOf(
                createScenario(number = 1, requirements = "Achievement2"),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertTrue(result.activeScenarios.isEmpty())
        assertEquals(1, result.blockedScenarios.size)
        assertEquals(1, result.blockedScenarios.first().scenarioNumber)
    }

    @Test
    fun `scenario with partially met requirements should be blocked`() {
        // Given
        val team = createTeam(
            teamAchievement = "Achievement1",
            scenarios = listOf(
                createScenario(number = 1, requirements = "Achievement1, Achievement2"),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertTrue(result.activeScenarios.isEmpty())
        assertEquals(1, result.blockedScenarios.size)
    }

    @Test
    fun `global achievements should also unlock scenarios`() {
        // Given
        val team = createTeam(
            teamAchievement = "",
            globalAchievement = "GlobalAchievement",
            scenarios = listOf(
                createScenario(number = 1, requirements = "GlobalAchievement"),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertEquals(1, result.activeScenarios.size)
        assertTrue(result.blockedScenarios.isEmpty())
    }

    @Test
    fun `mixed team and global achievements should work together`() {
        // Given
        val team = createTeam(
            teamAchievement = "TeamAch",
            globalAchievement = "GlobalAch",
            scenarios = listOf(
                createScenario(number = 1, requirements = "TeamAch, GlobalAch"),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertEquals(1, result.activeScenarios.size)
        assertTrue(result.blockedScenarios.isEmpty())
    }

    @Test
    fun `empty achievements should make all scenarios with requirements blocked`() {
        // Given
        val team = createTeam(
            teamAchievement = "",
            globalAchievement = "",
            scenarios = listOf(
                createScenario(number = 1, requirements = "SomeRequirement"),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertTrue(result.activeScenarios.isEmpty())
        assertEquals(1, result.blockedScenarios.size)
    }

    @Test
    fun `should correctly partition mixed scenarios`() {
        // Given
        val team = createTeam(
            teamAchievement = "Achievement1",
            scenarios = listOf(
                createScenario(number = 1, isCompleted = true),
                createScenario(number = 2, requirements = "Achievement1"),
                createScenario(number = 3, requirements = "Achievement2"),
                createScenario(number = 4, requirements = ""),
            )
        )

        // When
        val result = useCase(team)

        // Then
        assertEquals(1, result.completedScenarios.size)
        assertEquals(1, result.completedScenarios.first().scenarioNumber)

        assertEquals(2, result.activeScenarios.size)
        assertTrue(result.activeScenarios.any { it.scenarioNumber == 2 })
        assertTrue(result.activeScenarios.any { it.scenarioNumber == 4 })

        assertEquals(1, result.blockedScenarios.size)
        assertEquals(3, result.blockedScenarios.first().scenarioNumber)
    }

    private fun createTeam(
        teamAchievement: String = "",
        globalAchievement: String = "",
        scenarios: List<ScenarioShortInfo> = emptyList(),
    ) = TeamInfoWithScenario(
        teamId = 1,
        name = "Test Team",
        teamAchievement = teamAchievement,
        globalAchievement = globalAchievement,
        reputation = 0,
        prosperity = 0,
        scenario = scenarios,
    )

    private fun createScenario(
        number: Int,
        requirements: String = "",
        isCompleted: Boolean = false,
    ) = ScenarioShortInfo(
        scenarioNumber = number,
        scenarioName = "Scenario $number",
        scenarioRequirements = requirements,
        isCompleted = isCompleted,
        location = "Location $number",
    )
}
