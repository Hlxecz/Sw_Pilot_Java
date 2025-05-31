package Bio09.Enum;

public enum CoffeeType {
    BLEND("블렌드 커피", 4000),
    DARK("다크 커피", 4500),
    DECAF("디카페인 커피", 4200);

    private final String displayName;
    private final int price;

    CoffeeType(String displayName, int price) {
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
