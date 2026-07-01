package agent.runtime

import agent.shared.models.Plan
import agent.shared.models.PlanStep
import agent.shared.types.PolicyDecision

interface Planner {
    fun createPlan(objective: String): Plan
}

interface PolicyEngine {
    fun evaluate(step: PlanStep): PolicyDecision
}

interface Executor {
    fun execute(step: PlanStep): Any
}

interface Auditor {
    fun log(event: String, vararg data: Any)
}
