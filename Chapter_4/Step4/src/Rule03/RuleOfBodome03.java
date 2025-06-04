package Rule03;

import Rule03.Device.GeneralDevice;
import Rule03.Device.SmartDevice;
import Rule03.Inteface.Device;

import java.util.ArrayList;
import java.util.List;

public class RuleOfBodome03 {
    public static void main(String[] args) {

        List<Device> deviceList = new ArrayList<>();
        DeviceController controller = new DeviceController(deviceList);


        GeneralDevice doorOpener = new GeneralDevice("도어 오프너");
        SmartDevice smartMirror = new SmartDevice("자동 거울", "기분을 인식해 옷을 추천하는 기능");


        controller.deviceConnection(doorOpener);
        controller.deviceConnection(smartMirror);


        controller.deviceOn("자동 거울");


        controller.featureActivatable("자동 거울");


        controller.deviceOn("도어 오프너");


        controller.powerOffAllDevices();
    }
}
