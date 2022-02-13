package opta.planner.test.util.tsp

import org.optaplanner.core.api.score.buildin.hardsoftbigdecimal.HardSoftBigDecimalScore
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator
import java.math.BigDecimal

class TSPScoreCalculator : EasyScoreCalculator<TSPProblem, HardSoftBigDecimalScore> {
    override fun calculateScore(solution: TSPProblem?): HardSoftBigDecimalScore {
        return HardSoftBigDecimalScore.ofHard(BigDecimal.ONE)
    }
}