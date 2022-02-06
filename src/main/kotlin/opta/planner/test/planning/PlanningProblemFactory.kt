package opta.planner.test.planning

import org.optaplanner.core.api.solver.SolverManager
import org.optaplanner.core.config.solver.SolverConfig
import org.optaplanner.core.config.solver.SolverManagerConfig
import org.springframework.stereotype.Component

@Component
class PlanningProblemFactory {

    fun <V : PlanningProblem> create(solverConfig: SolverConfig): PlanningProblemImpl<V> {
        val solverManager: SolverManager<V, String> = SolverManager.create(solverConfig, SolverManagerConfig())
        return PlanningProblemImpl(solverManager)
    }
}