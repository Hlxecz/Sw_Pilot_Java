package Bio04;

public class WindEnergy extends EnergySource{

    public WindEnergy() {
        super("풍력");
    }

    @Override
    void produceEnergy(int speed) {
        int energyAmount = speed / 5;
        addEnergyAmount(energyAmount);
        System.out.println(super.getSourceName() + "에너지를 " + energyAmount +" 생산했습니다.");
    }
}
