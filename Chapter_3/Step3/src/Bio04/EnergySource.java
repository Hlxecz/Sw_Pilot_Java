package Bio04;

public abstract class EnergySource {
    private int energyAmount;
    private final String sourceName;

    public EnergySource(String sourceName) {
        this.sourceName = sourceName;
        this.energyAmount = 0;
    }

    public void useEnergy(int useEnergy) {
        if(EnergyManager.getTotal() >= useEnergy){
            System.out.println(sourceName + "에너지를 " + useEnergy +" 사용했습니다.");
            EnergyManager.minTotal(useEnergy);
        }else{
            System.out.println(sourceName + "에너지가 " + (useEnergy - EnergyManager.getTotal()) +" 만큼 에너지가 부족합니다.");
        }

    }

    public String getSourceName() {
        return sourceName;
    }

    abstract void produceEnergy(int E);

}
