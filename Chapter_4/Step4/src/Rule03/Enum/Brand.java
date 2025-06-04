package Rule03.Enum;

public enum Brand {
    DOMETECH("DOMETech");

    private final String brand;

    Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
