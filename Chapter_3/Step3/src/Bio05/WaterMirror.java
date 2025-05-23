package Bio05;

import Bio05.Interface.Chargeable;
import Bio05.Interface.EnergyGenerator;
import Bio05.Interface.WeatherController;

public class WaterMirror extends AncientArtifact implements EnergyGenerator, WeatherController, Chargeable {
    private int energy;

    protected WaterMirror() {
        super("물의 거울");
        this.energy = 0;
    }

    @Override
    void describe() {
        System.out.println("물의 거울은 수증기를 모아 에너지를 생성하고 날씨를 조절합니다.\n");
    }

    @Override
    public void generateEnergy() {
        System.out.println("물의 거울을 이용해 수증기로 에너지를 생성했습니다!");
    }

    @Override
    public void controlWeather() {
        System.out.println("물의 거울이 습도의 영향으로 비와 눈을 내리게합니다.");
    }


    @Override
    public void charge(int amount) {
        System.out.println("물의 거울에 " + amount + "만큼 에너지를 충전합니다.");
        energy+=amount;
    }

    @Override
    public void getChargeLevel() {
        System.out.println("물의 거울에 총 "+energy+"만큼의 에너지가 충전되었습니다.");
    }
}
