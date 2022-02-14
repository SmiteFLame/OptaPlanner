package opta.planner.test.controller

import opta.planner.test.planning.PlanningProblemImpl
import opta.planner.test.util.tsp.TSPProblem
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    val planningProblem: PlanningProblemImpl<TSPProblem>
) {

    @PostMapping("/tsp/solve")
    fun solve(@RequestBody problem: TSPProblem): TSPProblem {
        problem.setAnswerList()
        val solverJob = planningProblem.solve(problem)
        return planningProblem.getFinalBestSolution(solverJob)
    }

}