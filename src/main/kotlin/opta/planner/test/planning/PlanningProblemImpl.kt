package opta.planner.test.planning

import org.optaplanner.core.api.solver.SolverManager
import org.springframework.beans.factory.annotation.Autowired

class PlanningProblemImpl<V : PlanningProblem>{
    @Autowired
    lateinit var solverManager : SolverManager<V, String>
    

}