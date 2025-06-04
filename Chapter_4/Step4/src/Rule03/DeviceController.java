package Rule03;


import Rule03.Device.SmartDevice;
import Rule03.Inteface.Device;
import Rule03.Inteface.FeatureActivatable;


import java.util.List;

public class DeviceController {
    private List<Device> devicelist;

    public DeviceController(List<Device> devicelist) {
        this.devicelist = devicelist;
    }

    public void deviceConnection(Device device){
        devicelist.add(device);
        System.out.println("컨트롤러 기기가 연결되었습니다 : " + device.getModel());
    }

    public void deviceOn(String modelName) {
        devicelist.stream()
                .filter(device -> device.getModel().equals(modelName))
                .findFirst()
                .ifPresent(Device::powerOn);

        //if (result.isPresent()) {
        //    result.get().powerOn(); // 값이 있으면 꺼내서 사용
        //}
    }

    public void deviceOff(String modelName) {
        devicelist.stream()
                .filter(device -> device.getModel().equals(modelName))
                .findFirst()
                .ifPresent(Device::powerOff);
    }

    public void featureActivatable(String modelName) {
//        devicelist.stream()
//                .filter(device -> device instanceof FeatureActivatable)
//                .map(device -> (SmartDevice) device)
//                .filter(device -> device.getModel().equals(modelName))
//                .findFirst()
//                .ifPresentOrElse(
//                        FeatureActivatable::activateFeature,
//                        () -> System.out.println(modelName + " 스마트 기기를 찾을 수 없습니다.")
//                );
        for (Device device : devicelist) {
            if (device instanceof SmartDevice smartDevice &&
                    smartDevice.getModel().equals(modelName)) {
                smartDevice.activateFeature();
                return;
            }
        }
        System.out.println(modelName + " 스마트 기기를 찾을 수 없습니다.");
    }




    public void powerOffAllDevices(Device... devices) {
        System.out.println("====모든 기기 전원을 종료합니다====");
        for (int i = 0; i < devicelist.size(); i++) {
            Device device = devicelist.get(i);
            device.powerOff();
        }


    }
}

