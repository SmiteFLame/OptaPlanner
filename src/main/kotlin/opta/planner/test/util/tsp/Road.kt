package opta.planner.test.util.tsp

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.lookup.PlanningId
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
data class Road(
    @PlanningId val id: Long,
    @PlanningVariable(valueRangeProviderRefs = ["test"]) val test: Test
)