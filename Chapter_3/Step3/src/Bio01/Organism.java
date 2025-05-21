package Bio01;

public class Organism {
    private String name;        // 이름
    private String species;     // 종 (예: 동물, 식물)
    private String habitat;     // 주요 서식지

    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void displayInfo(){
        System.out.printf("이름 : %-8s 종 : %-8s 서식지 : %-8s\n", name, species, habitat);

    }
}
