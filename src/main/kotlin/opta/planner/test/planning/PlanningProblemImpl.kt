package opta.planner.test.planning

import org.optaplanner.core.api.solver.SolverJob
import org.optaplanner.core.api.solver.SolverManager
import java.util.*

class PlanningProblemImpl<V : PlanningProblem>(var solverManager: SolverManager<V, String>) {

    fun solve(problem: V): SolverJob<V, String> {
        val problemId = UUID.randomUUID().toString()
        return solverManager.solve(problemId, problem)
    }

    fun getFinalBestSolution(solverJob: SolverJob<V, String>): V {
        val solution: V;
        try {
            solution = solverJob.finalBestSolution
        } catch (e: Exception) {
            throw IllegalStateException("Solving failed. ", e)
        }
        return solution
    }

}