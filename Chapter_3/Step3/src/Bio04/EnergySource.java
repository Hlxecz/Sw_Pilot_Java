package Bio04;

public abstract class EnergySource {
    private int energyAmount;

    public EnergySource(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    public void useEnergy() {
        
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    abstract void produceEnergy();
}
