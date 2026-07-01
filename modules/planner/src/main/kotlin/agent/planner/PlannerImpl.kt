package agent.planner

import agent.runtime.Planner
import agent.shared.models.Plan
import agent.shared.models.PlanStep

class PlannerImpl : Planner {
    override fun createPlan(objective: String): Plan {
        // Implementação simples de exemplo: cria um plano vazio ou com um passo genérico.
        val steps = when {
            objective.contains("analisar", ignoreCase = true) -> listOf(
                PlanStep(
                    tool = "audit",
                    parameters = mapOf(
                        "action" to "scan",
                        "target" to objective
                    )
                )
            )
            objective.contains("executar", ignoreCase = true) -> listOf(
                PlanStep(
                    tool = "executor",
                    parameters = mapOf(
                        "command" to objective
                    )
                )
            )
            else -> emptyList()
        }

        return Plan(goal = objective, steps = steps)
    }
}
