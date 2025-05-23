package Bio04;

public abstract class EnergySource {
    private int energyAmount;
    private final String sourceName;

    public EnergySource(String sourceName) {
        this.sourceName = sourceName;
        this.energyAmount = 0;
    }

    public void useEnergy(int useEnergy) {
        if(energyAmount >= useEnergy){
            System.out.println(sourceName + "에너지를 " + useEnergy +" 사용했습니다.");
            minEnergyAmount(useEnergy);
        }else{
            System.out.println(sourceName + "에너지가 " + (useEnergy - energyAmount) +" 만큼 에너지가 부족합니다.");
        }

    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void addEnergyAmount(int energyAmount) {
        this.energyAmount += energyAmount;
    }

    public void minEnergyAmount(int energyAmount) {
        this.energyAmount -= energyAmount;
    }

    abstract void produceEnergy(int E);

}
