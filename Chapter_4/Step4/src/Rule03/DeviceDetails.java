package Rule03;


import Rule03.Enum.Brand;

public class DeviceDetails {
    private final String model;
    private final String brand;

    public DeviceDetails(String model) {
        this.model = model;
        this.brand = Brand.DOMETECH.getBrand();
    }

    public String getModel() { return model; }
    public String getBrand() { return brand; }
}
