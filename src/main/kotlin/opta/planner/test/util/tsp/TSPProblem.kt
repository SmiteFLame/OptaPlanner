package opta.planner.test.util.tsp

import opta.planner.test.planning.PlanningProblem
import org.optaplanner.core.api.domain.solution.*
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore

@PlanningSolution
class TSPProblem : PlanningProblem {

    @ProblemFactProperty
    var startCenter: Center

    // 문제 해결중에 변경이 되지 않는 것
    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "centerList")
    var centerList: List<Center>

    // 문제 해결중에 변경이 되지 않는 것
    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = " roadList")
    var roadList: List<Road>

    // 문제 해결중에 변경이 되는 것
    @PlanningEntityCollectionProperty
    var answerList: ArrayList<CenterTo>

    @PlanningScore
    lateinit var score: HardSoftLongScore

    constructor() {
        this.startCenter = Center(0)
        this.centerList = ArrayList()
        this.roadList = ArrayList()
        this.answerList = ArrayList()
        setAnswerList()
    }

    constructor(startCenter: Center, centerList: List<Center>, roadList: List<Road>) {
        this.startCenter = startCenter
        this.centerList = centerList
        this.roadList = roadList
        this.answerList = ArrayList()
        setAnswerList()
    }

    fun setAnswerList() {
        this.answerList = ArrayList()

        for (i in centerList.indices) {
            answerList.add(CenterTo(centerList[i].centerId))
        }
    }

}