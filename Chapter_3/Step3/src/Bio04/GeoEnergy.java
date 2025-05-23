package Bio04;

public class GeoEnergy extends EnergySource{

    public GeoEnergy() {
        super("지열");
    }

    @Override
    void produceEnergy(int temperature) {
        int energyAmount = (temperature * 5) + 20;
        EnergyManager.addTotal(energyAmount);
        System.out.println(super.getSourceName() + "에너지를 " + energyAmount +" 생산했습니다.");
    }
}
