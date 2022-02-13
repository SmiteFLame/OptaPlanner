package opta.planner.test.util.tsp

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.lookup.PlanningId
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
class Road{

    @PlanningId
    var id: Long = 0

    @PlanningVariable(valueRangeProviderRefs = ["center"])
    lateinit var from: Center

    @PlanningVariable(valueRangeProviderRefs = ["center"])
    lateinit var to: Center

    var weight: Int = 0

    constructor()

    constructor(id: Long, from: Center, to: Center, weight: Int){
        this.id =id
        this.from = from
        this.to = to
        this.weight = weight
    }
}