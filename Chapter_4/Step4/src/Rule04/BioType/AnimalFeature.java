package Rule04.BioType;


public class AnimalFeature {
    private String behavior;
    private String species;
    private String lifespan;

    public AnimalFeature(String behavior, String species, String lifespan) {
        this.behavior = behavior;
        this.species = species;
        this.lifespan = lifespan;

    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    @Override
    public String toString(){
        return behavior + ", " + species + ", " + lifespan;
    }
}
