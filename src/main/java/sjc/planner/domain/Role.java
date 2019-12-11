package sjc.planner.domain;

public enum Role {
    Cook(false),
    Pastry(true),
    Waiter(true),
    Busser(true);
    
    public final boolean mandatoryPresenceAtTheSecondService;

    private Role(boolean mandatoryPresenceAtTheSecondService) {
        this.mandatoryPresenceAtTheSecondService = mandatoryPresenceAtTheSecondService;
    }
}
