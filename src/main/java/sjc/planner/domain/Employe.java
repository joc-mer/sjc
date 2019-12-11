package sjc.planner.domain;

import java.util.Collections;
import java.util.Set;

public class Employe {
    private final String identifier;
    private final boolean canDoTheSecondService;
    private final Set<Role> skills;

    public Employe(String identifier, boolean canDoTheSecondService, Set<Role> skills) {
        this.identifier = identifier;
        this.canDoTheSecondService = canDoTheSecondService;
        this.skills = skills;
    }

    public String getIdentifier() {
        return identifier;
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
