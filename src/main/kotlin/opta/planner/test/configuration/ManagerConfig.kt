package opta.planner.test.configuration

import opta.planner.test.planning.PlanningProblemFactory
import opta.planner.test.planning.PlanningProblemImpl
import opta.planner.test.util.tsp.CenterTo
import opta.planner.test.util.tsp.Road
import opta.planner.test.util.tsp.TSPProblem
import opta.planner.test.util.tsp.TSPScoreCalculator
import org.optaplanner.core.config.score.director.ScoreDirectorFactoryConfig
import org.optaplanner.core.config.solver.SolverConfig
import org.optaplanner.core.config.solver.termination.TerminationConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ManagerConfig {

    @Autowired
    lateinit var factory: PlanningProblemFactory

    @Bean
    fun tspProblemManager(): PlanningProblemImpl<TSPProblem>{
        val solverConfig = SolverConfig()
            .withSolutionClass(TSPProblem::class.java)
            .withEntityClasses(CenterTo::class.java)
            .withScoreDirectorFactory(ScoreDirectorFactoryConfig()
                .withEasyScoreCalculatorClass(TSPScoreCalculator::class.java))
            .withTerminationConfig(TerminationConfig().withSecondsSpentLimit(5L))

        return factory.create(solverConfig)
    }
}