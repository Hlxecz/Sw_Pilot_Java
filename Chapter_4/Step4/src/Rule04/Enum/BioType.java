package Rule04.Enum;

public enum BioType {
    ANIMAL("동물"), PLANT("식물"),MICROBE("미생물");

    private final String label;

    BioType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString(){
        return label;
    }
}
