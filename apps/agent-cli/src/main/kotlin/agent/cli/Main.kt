package agent.cli

import agent.planner.PlannerImpl
import agent.runtime.AgentRuntime
import agent.runtime.PolicyEngine
import agent.runtime.Executor
import agent.runtime.Auditor
import agent.shared.models.PlanStep
import agent.shared.types.PolicyDecision

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Agent CLI starter")

        val planner = PlannerImpl()

        val policy = object : PolicyEngine {
            override fun evaluate(step: PlanStep): PolicyDecision = PolicyDecision(true, "ok")
        }

        val executor = object : Executor {
            override fun execute(step: PlanStep): Any = mapOf("status" to "ok")
        }

        val auditor = object : Auditor {
            override fun log(event: String, vararg data: Any) {
                println("AUDIT: $event - ${data.joinToString()}")
            }
        }

        val runtime = AgentRuntime(planner, policy, executor, auditor)
        runtime.run("analisar logs de sistema")
    }
}
