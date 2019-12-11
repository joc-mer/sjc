package sjc.planner.solver;

import sjc.planner.domain.Employe;
import sjc.planner.domain.Position;

public class Allocation {
    public final Position position;
    public final Employe employe;

    public Allocation(Position position, Employe employe) {
        this.position = position;
        this.employe = employe;
    }
}
