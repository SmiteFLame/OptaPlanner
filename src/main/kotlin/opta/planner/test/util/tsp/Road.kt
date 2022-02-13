package opta.planner.test.util.tsp

import com.fasterxml.jackson.annotation.JsonProperty
import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.lookup.PlanningId
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
data class Road(
    @PlanningId
    @JsonProperty(required = false)
    val id: Long,
    @PlanningVariable(valueRangeProviderRefs = ["center"])
    val from: Center,
    @PlanningVariable(valueRangeProviderRefs = ["center"])
    val to: Center,
    val weight: Int,
)