package sjc.planner.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServiceProblem {
    private final Map<Role, Integer> positions;
    private final Map<Role, List<Employe>> employesByRole;

    public ServiceProblem(Map<Role, Integer> positions, List<Employe> employes) {
        this.positions = Map.copyOf(positions);
        this.employesByRole = buildEmployesByRoleIndex(employes);
    }

    private static Map<Role, List<Employe>> buildEmployesByRoleIndex(List<Employe> employes) {
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
    
    public int countPositionForRole(Role r) {
        return positions.get(r);
    }
    
    
}
