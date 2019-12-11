package sjc.planner.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RestaurantServiceProblem {
    private final Map<Role, List<Position>> positionsByRole;
    private final Map<Role, List<Employe>> employesByRole;

    public RestaurantServiceProblem(Iterable<Position> positions, Iterable<Employe> employes) {
        this.positionsByRole = StreamSupport.stream(positions.spliterator(), false).collect(Collectors.groupingBy(p -> p.job));
        this.employesByRole = buildEmployesByRoleIndex(employes);
    }

    private static Map<Role, List<Employe>> buildEmployesByRoleIndex(Iterable<Employe> employes) {
        Map<Role, List<Employe>> ret = new HashMap<>();
        
        for (Employe e : employes) {
            for (Role skill : e.allSkills()) {
                ret.compute(skill, (sk, list) -> { 
                        if (list == null) return new LinkedList<Employe>(){{add(e);}}; 
                        else list.add(e); return list;
                    }
                );
            }
        }
        
        return ret;
    }
    
    public List<Position> getPositionsForRole(Role r) {
        return Collections.unmodifiableList(positionsByRole.get(r));
    }
    
    public List<Employe> getAllEmployesWithSkill(Role skill) {
        return employesByRole.get(skill);
    }
}
