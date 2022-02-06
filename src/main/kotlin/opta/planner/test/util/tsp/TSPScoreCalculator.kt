package opta.planner.test.util.tsp

import org.optaplanner.core.api.score.buildin.hardsoftbigdecimal.HardSoftBigDecimalScore
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator

class TSPScoreCalculator : EasyScoreCalculator<TSPProblem, HardSoftBigDecimalScore> {
    override fun calculateScore(solution: TSPProblem?): HardSoftBigDecimalScore {
        TODO("Not yet implemented")
    }
}