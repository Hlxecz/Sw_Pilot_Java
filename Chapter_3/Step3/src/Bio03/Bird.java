package Bio03;

public class Bird extends Animal {
    private double wingSpan;

    public Bird(String name, String species, String habitat, String digestionType, String food, double wingSpan) {
        super(name, species, habitat, digestionType, food);
        this.wingSpan = wingSpan;
    }

    public void fly() {
        System.out.println(getName() + "이(가) 날아갑니다!");
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}
