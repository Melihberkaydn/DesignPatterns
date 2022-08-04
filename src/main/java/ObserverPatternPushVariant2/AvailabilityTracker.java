package ObserverPatternPushVariant2;

public class AvailabilityTracker {

    private boolean becomeAvailable = false;
    private PEV pev;

    public AvailabilityTracker(PEV pev, boolean becomeAvailable) {
        this.becomeAvailable = becomeAvailable;
        this.pev = pev;
    }

    public boolean isBecomeAvailable() {
        return becomeAvailable;
    }

    public PEV getPev() {
        return pev;
    }
}
