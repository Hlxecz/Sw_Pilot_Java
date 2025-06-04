package Rule03.Device;

import Rule03.DeviceDetails;
import Rule03.Enum.Brand;
import Rule03.Inteface.Device;
import Rule03.Inteface.FeatureActivatable;

public class SmartDevice implements Device , FeatureActivatable{
    private final DeviceDetails details;
    private boolean isOn;
    private String feature;
    public SmartDevice(String model, String feature) {
        this.details = new DeviceDetails(model);
        this.feature = feature;
        System.out.println("스마트 기기가 생성되었습니다 : " + details.getModel() + ", " + details.getBrand() + ", " + feature);
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println(details.getModel() + " 전원을 켰습니다.");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println(details.getModel() + " 전원을 껐습니다.");
    }


    public void displayInfo() {
        System.out.print("모델명: " + details.getModel());
        System.out.println(" 브랜드: " + details.getBrand());
    }

    @Override
    public String getModel() {
        return details.getModel();
    }

    @Override
    public void activateFeature() {
        if (!isOn) {
            throw new IllegalArgumentException(getModel() + "의 전원이 꺼져있습니다");
        }
        if (feature == null || feature.isBlank()) {
            throw new IllegalStateException(getModel() + "의 고급 기능이 설정되어 있지 않습니다");
        }
        System.out.println(feature + " 기능을 활성화 시켰습니다.");
    }
}
