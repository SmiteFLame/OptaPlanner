package opta.planner.test.util.tsp

import opta.planner.test.planning.PlanningProblem
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

@PlanningSolution
data class TSPProblem(
    @ProblemFactCollectionProperty val fact: List<Int>,
    @ValueRangeProvider(id = "test") val test: List<Test>,
    @PlanningEntityCollectionProperty val entity: List<Road>
) : PlanningProblem {

    @PlanningScore
    lateinit var score: HardSoftScore
}