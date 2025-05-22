package Bio03;

public class Fish extends Animal {
    private int finsCount; //지느러미수

    public Fish(String name, String species, String habitat, String digestionType, String food, int finsCount) {
        super(name, species, habitat, digestionType, food);
        this.finsCount = finsCount;
    }

    public void swim() {
        System.out.println(getName() + "이(가) 헤엄칩니다!");
    }

    public int getFinsCount() {
        return finsCount;
    }

    public void setFinsCount(int finsCount) {
        this.finsCount = finsCount;
    }
}
