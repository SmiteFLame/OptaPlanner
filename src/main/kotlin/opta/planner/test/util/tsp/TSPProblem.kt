package opta.planner.test.util.tsp

import com.fasterxml.jackson.annotation.JsonProperty
import opta.planner.test.planning.PlanningProblem
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

@PlanningSolution
class TSPProblem : PlanningProblem {

    // 문제 해결중에 변경이 되지 않는 것
    @ValueRangeProvider(id = "center")
    @ProblemFactCollectionProperty
    lateinit var centerList :  List<Center>

    // 문제 해결중에 변경이 되는 것
    @PlanningEntityCollectionProperty
    lateinit var roadList: List<Road>

    constructor()

    constructor(centerList: List<Center>, roadList: List<Road>){
        this.centerList = centerList
        this.roadList = roadList
    }

    @PlanningScore
    lateinit var score: HardSoftScore
}