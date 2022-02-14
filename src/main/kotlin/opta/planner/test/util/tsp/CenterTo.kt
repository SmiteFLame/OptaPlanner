package opta.planner.test.util.tsp

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
class CenterTo {

    var from: Center

    @PlanningVariable(valueRangeProviderRefs = ["centerList"])
    var to: Center

    constructor(){
        this.from = Center(0)
        this.to = Center(0)
    }

    constructor(from: Int) {
        this.from = Center(from)
        this.to = Center(from)
    }
}