package agent.shared.contracts

interface Tool {

val name: String

suspend fun execute(
    input: Map<String, Any>
): Any

}
