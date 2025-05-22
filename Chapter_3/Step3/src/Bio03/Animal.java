package Bio03;

public class Animal extends Organism{
    private String food; //먹이
    private String diges; //소화방식

    public Animal(String name, String species, String habitat, String food, String diges) {
        super(name, species, habitat);
        this.food = food;
        this.diges = diges;
    }

    @Override
    public void displayInfo() {
        System.out.printf("이름 : %-8s 종 : %-8s 서식지 : %-8s 먹이 : %-8s 소화방식 : %-5s\n",
                super.getName(), super.getSpecies(), super.getHabitat(), food, diges);
    }
}
