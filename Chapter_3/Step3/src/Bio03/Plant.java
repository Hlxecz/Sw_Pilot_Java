package Bio03;

public class Plant extends Organism {
    private String season; //개화
    private String fruit; //열매 유무

    public Plant(String name, String species, String habitat, String season, String fruit) {
        super(name, species, habitat);
        this.season = season;
        this.fruit = fruit;
    }

    @Override
    public void displayInfo() {
        System.out.printf("이름 : %-8s 종 : %-8s 서식지 : %-8s 개화시기 : %-8s %-5s\n",
                super.getName(), super.getSpecies(), super.getHabitat(), season, fruit);
    }
}


