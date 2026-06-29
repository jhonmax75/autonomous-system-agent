package agent.shared.models

data class PlanStep(

val tool: String,

val parameters: Map<String, Any>

)
