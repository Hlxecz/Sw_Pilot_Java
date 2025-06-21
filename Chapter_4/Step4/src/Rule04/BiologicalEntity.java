package Rule04;

import Rule04.Enum.*;

public class BiologicalEntity<T> {
    private String name;
    private BioType bioType;
    private T feature;

    public BiologicalEntity(String name, BioType bioType, T feature) {
        this.name = name;
        this.bioType = bioType;
        this.feature = feature;
        System.out.println(this.showInfo());
    }

    public String getName() {
        return name;
    }

    public BioType getBioType() {
        return bioType;
    }

    public T getFeature() {
        return feature;
    }

    public void setFeature(T feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return name;
    }

    public String showInfo(){
        return name + ", " + bioType.getLabel() + ", " + feature.toString();
    }
}
