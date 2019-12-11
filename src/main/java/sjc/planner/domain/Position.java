package sjc.planner.domain;

public class Position implements Comparable<Position> {

    public final int id;
    public final Role job;

    public Position(int id, Role job) {
        this.id = id;
        this.job = job;
    }

    @Override
    public int compareTo(Position o) {
        return o.id - this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
