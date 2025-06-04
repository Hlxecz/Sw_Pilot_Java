package Rule03.Device;

import Rule03.DeviceDetails;
import Rule03.Inteface.Device;

public class GeneralDevice implements Device {
    private final DeviceDetails details;
    private boolean isOn;

    public GeneralDevice(String model) {
        this.details = new DeviceDetails(model);
        System.out.println("일반 기기가 생성되었습니다 : " + details.getModel() + ", " + details.getBrand());
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

    public boolean isOn() {
        return isOn;
    }
    @Override
    public String getModel() {
        return details.getModel();
    }
}
