package Bio03;

public class Mammal extends Animal {
    private boolean warmBlooded;

    public Mammal(String name, String species, String habitat, String digestionType, String food, boolean warmBlooded) {
        super(name, species, habitat, digestionType, food);
        this.warmBlooded = warmBlooded;
    }

    public void giveBirth() {
        System.out.println(getName() + "이(가) 새끼를 낳습니다.");
    }

    public boolean isWarmBlooded() {
        return warmBlooded;
    }

    public void setWarmBlooded(boolean warmBlooded) {
        this.warmBlooded = warmBlooded;
    }
}
