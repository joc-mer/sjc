package sjc.planner.solver;

import sjc.planner.domain.RestaurantServiceProblem;

public interface Solver {
    
    Iterable<Allocation> solve(RestaurantServiceProblem problem);
    
}
