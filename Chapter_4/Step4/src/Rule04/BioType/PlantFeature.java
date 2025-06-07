package Rule04.BioType;

public class PlantFeature {
    private String flowerColor;
    private String hasFruit;
    private String bloomingSeason;

    public PlantFeature(String flowerColor, String hasFruit, String bloomingSeason) {
        this.flowerColor = flowerColor;
        this.hasFruit = hasFruit;
        this.bloomingSeason = bloomingSeason;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public String getHasFruit() {
        return hasFruit;
    }

    public void setHasFruit(String hasFruit) {
        this.hasFruit = hasFruit;
    }

    public String getBloomingSeason() {
        return bloomingSeason;
    }

    public void setBloomingSeason(String bloomingSeason) {
        this.bloomingSeason = bloomingSeason;
    }

    @Override
    public String toString(){
        return flowerColor + ", " + hasFruit + ", " + bloomingSeason;
    }
}
