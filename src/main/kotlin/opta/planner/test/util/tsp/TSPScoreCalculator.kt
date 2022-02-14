package opta.planner.test.util.tsp

import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator

class TSPScoreCalculator : EasyScoreCalculator<TSPProblem, HardSoftLongScore> {

    override fun calculateScore(solution: TSPProblem?): HardSoftLongScore {
        if (solution == null) {
            throw Exception("ERROR")
        }

        // 1. 사이클을 만들 수 있는 지 확인
        val size = solution.centerList.size
        val start = solution.startCenter.centerId

        val visited = Array(size) { false }
        var now = start
        for (i in 0 until size) {
            if (visited[now]) {
                return HardSoftLongScore.ofHard(Long.MIN_VALUE)
            }
            visited[now] = true
            now = solution.answerList[now].to.centerId
        }

        if(now != start){
            return HardSoftLongScore.ofHard(Long.MIN_VALUE)
        }

        // 2.각각이 길이 있는 지 확인
        val map = HashMap<Center, HashMap<Center, Road>>()
        solution.roadList.forEach { road ->
            map.putIfAbsent(road.from, HashMap())
            if(map[road.from]!!.containsKey(road.to)){
                if(road.weight < map[road.from]!![road.to]!!.weight){
                    map[road.from]!![road.to] = road
                }
            } else{
                map[road.from]!![road.to] = road
            }
        }
        var answer = 0L

        solution.answerList.forEach { centerTo ->
            if(!map.containsKey(centerTo.from) || !map[centerTo.from]!!.containsKey(centerTo.to)){
                return HardSoftLongScore.ofHard(Long.MIN_VALUE)
            }
            answer += map[centerTo.from]!![centerTo.to]!!.weight
        }

        println(answer)

        return HardSoftLongScore.of(0L, -answer)
    }
}
