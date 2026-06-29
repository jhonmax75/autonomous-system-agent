package agent.shared.models

data class Plan(

val goal: String,

val steps: List<PlanStep>

)
