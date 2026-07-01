package agent.runtime

import agent.shared.models.Plan
import agent.shared.models.PlanStep
import agent.shared.types.PolicyDecision

class AgentRuntime(
    private val planner: Planner,
    private val policy: PolicyEngine,
    private val executor: Executor,
    private val auditor: Auditor
) {

    fun run(objective: String) {

        auditor.log("START", objective)

        val plan = planner.createPlan(objective)
        auditor.log("PLAN_CREATED", plan)

        for (step in plan.steps) {

            auditor.log("STEP_START", step)

            val decision = policy.evaluate(step)

            if (!decision.allowed) {
                auditor.log("STEP_DENIED", step)
                continue
            }

            val result = executor.execute(step)

            auditor.log("STEP_EXECUTED", step, result)
        }

        auditor.log("END", objective)
    }
}
