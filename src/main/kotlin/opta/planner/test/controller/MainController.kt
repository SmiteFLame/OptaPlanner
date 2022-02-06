package opta.planner.test.controller

import opta.planner.test.util.TSPProblem
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @PostMapping("/tsp/solve")
    fun solve(@RequestBody problem: TSPProblem){
        return
    }

}