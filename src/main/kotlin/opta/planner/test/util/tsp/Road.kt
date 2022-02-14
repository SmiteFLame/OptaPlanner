package opta.planner.test.util.tsp


class Road{

    var from: Center
    var to: Center
    var weight: Long = 0L

    constructor(){
        this.from = Center(0)
        this.to = Center(0)
    }

    constructor(from: Center, to: Center, weight: Long){
        this.from = from
        this.to = to
        this.weight = weight
    }
}