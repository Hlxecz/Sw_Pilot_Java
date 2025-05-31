package Bio09.Enum;

public enum DrinkType {
    CAMOMILE("캐모마일", 3000),
    ORANGE_JUICE("오렌지 쥬스", 3500),
    WATER("물", 1000);

    private final String displayName;
    private final int price;

    DrinkType(String displayName, int price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return displayName + ": " + price + "원";
    }
}
