package Bio09.Enum;

import java.time.LocalDate;

public enum Sandwichingredient {
    VEGETABLE("야채 샌드위치", 5000, LocalDate.of(2123, 10, 10)),
    HAM("햄 샌드위치", 6000, LocalDate.of(2123, 10, 11)),
    CHEESE("치즈 샌드위치", 5500, LocalDate.of(2122, 1, 6));  // 만료 지난 샘플

    private final String displayName;
    private final int price;
    private final LocalDate expiryDate;

    Sandwichingredient(String displayName, int price, LocalDate expiryDate) {
        this.displayName = displayName;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return displayName + ": " + price + "원 (만료일: " + expiryDate + ")";
    }
}
