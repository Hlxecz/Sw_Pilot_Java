package Rule04.BioType;

public class MicrobeFeature {
    private String environment;
    private String metabolism;

    public MicrobeFeature(String environment, String metabolism) {
        this.environment = environment;
        this.metabolism = metabolism;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getMetabolism() {
        return metabolism;
    }

    public void setMetabolism(String metabolism) {
        this.metabolism = metabolism;
    }

    @Override
    public String toString(){
        return environment + ", " + metabolism;
    }
}
