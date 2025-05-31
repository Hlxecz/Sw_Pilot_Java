package Bio09.Enum;

public enum Size {
    SHORT("숏", 0),
    TALL("톨", 500),
    VENTI("벤티", 1000);

    private final String displayName;
    private final int extraCharge;

    Size(String displayName, int extraCharge) {
        this.displayName = displayName;
        this.extraCharge = extraCharge;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getExtraCharge() {
        return extraCharge;
    }
}
