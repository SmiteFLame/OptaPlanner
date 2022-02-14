package opta.planner.test.util.tsp

import org.optaplanner.core.api.score.buildin.hardsoftbigdecimal.HardSoftBigDecimalScore
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator
import java.math.BigDecimal

class TSPScoreCalculator : EasyScoreCalculator<TSPProblem, HardSoftBigDecimalScore> {
    override fun calculateScore(solution: TSPProblem?): HardSoftBigDecimalScore {
        if (solution == null) {
            throw Exception("ERROR")
        }
        val size = solution.centerList.size
        val dp = Array(size) { Array((1 shl size) - 1) { Int.MAX_VALUE } }

        val roadArray = Array(size) { Array(size) { Int.MAX_VALUE } }

        solution.roadList.forEach{ road ->
            roadArray[road.from.centerId][road.to.centerId] = road.weight
        }

        val start = solution.startCenter.centerId

        fun dfs(now: Int, visit: Int): Int {
            if (visit == (1 shl size) - 1) {
                return roadArray[now][start]
            }

            if(dp[now][visit] != Int.MAX_VALUE){
                return dp[now][visit]
            }

            for (i in 0 until size) {
                if ((visit and (1 shl i)) == 0 && roadArray[now][i] != 0) {
                    dp[now][visit] = dp[now][visit].coerceAtMost(dfs(i, (visit or (1 shl i))) + roadArray[now][i])
                }
            }
            return dp[now][visit]
        }

        dfs(start, 1)


        return return HardSoftBigDecimalScore.ofHard(BigDecimal.valueOf(Long.MIN_VALUE))
    }
}
