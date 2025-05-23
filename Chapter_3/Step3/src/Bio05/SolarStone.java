package Bio05;

import Bio05.Interface.Chargeable;
import Bio05.Interface.EnergyGenerator;

public class SolarStone extends AncientArtifact implements EnergyGenerator , Chargeable {

    private int energy;

    protected SolarStone() {
        super("태양의 돌");
        this.energy = 0;
    }

    @Override
    void describe() {
        System.out.println("태양의 돌로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\n");
    }

    @Override
    public void generateEnergy() {
        System.out.println("태양의 돌이 에너지를 생성합니다.");
    }

    @Override
    public void charge(int amount) {
        System.out.println("태양의 돌에 " + amount + "만큼 에너지를 충전합니다.");
        energy+=amount;
    }

    @Override
    public void getChargeLevel() {
        System.out.println("태양의 돌에 총 "+energy+"만큼의 에너지가 충전되었습니다.");
    }

}
