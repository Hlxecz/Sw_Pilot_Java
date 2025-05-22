package Bio02;

public class Organism {
    private String name;        // 이름
    private String species;     // 종 (예: 동물, 식물)
    private String habitat;     // 주요 서식지
    private String characteristic; //특징
    private String lifeSpan; // 수명


    public Organism(String name, String species, String habitat,String characteristic, String lifeSpan) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.characteristic = characteristic;
        this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void displayInfo() {
        System.out.printf("이름 : %-8s 종 : %-8s 서식지 : %-8s 특징 : %-10s 수명 : %-5s\n",
                name, species, habitat, characteristic, lifeSpan);
    }

}
