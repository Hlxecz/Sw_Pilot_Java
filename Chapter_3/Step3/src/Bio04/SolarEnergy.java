package Bio04;

public class SolarEnergy extends EnergySource {

    public SolarEnergy() {
        super("태양광");
    }

    @Override
    void produceEnergy(int Time) {
        int energyAmount = Time / 10;
        EnergyManager.addTotal(energyAmount);
        System.out.println(super.getSourceName() + "에너지를 " + energyAmount + " 생산했습니다.");
    }
}
