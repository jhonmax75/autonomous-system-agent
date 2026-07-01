package agent.planner

import kotlin.test.Test
import kotlin.test.assertEquals

class PlannerImplTest {
    private val planner = PlannerImpl()

    @Test
    fun `createPlan returns empty plan for unknown objective`() {
        val plan = planner.createPlan("aprender kotlin")
        assertEquals("aprender kotlin", plan.goal)
        assertEquals(0, plan.steps.size)
    }

    @Test
    fun `createPlan creates audit step for analyze objective`() {
        val plan = planner.createPlan("analisar logs")
        assertEquals(1, plan.steps.size)
        assertEquals("audit", plan.steps.first().tool)
    }
}
