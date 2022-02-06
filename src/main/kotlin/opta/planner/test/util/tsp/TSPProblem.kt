package opta.planner.test.util.tsp

import opta.planner.test.planning.PlanningProblem
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

@PlanningSolution
class TSPProblem(
    @ProblemFactCollectionProperty val fact: List<Int>,
    @PlanningEntityCollectionProperty val entity: List<Int>
) : PlanningProblem {

    @PlanningScore
    lateinit var score: HardSoftScore
}