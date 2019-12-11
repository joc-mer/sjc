package sjc.planner.domain;

import java.util.Collections;
import java.util.Set;

public class Employe {
    private final boolean canDoTheSecondService;
    private final Set<Role> skills;

    public Employe(boolean canDoTheSecondService, Set<Role> skills) {
        this.canDoTheSecondService = canDoTheSecondService;
        this.skills = skills;
    }

    public boolean canDoTheSecondService() {
        return canDoTheSecondService;
    }
    
    public boolean canDo(Role function) {
        return skills.contains(function);
    }
    
    public Iterable<Role> allSkills() {
        return Collections.unmodifiableSet(skills);
    }
}
