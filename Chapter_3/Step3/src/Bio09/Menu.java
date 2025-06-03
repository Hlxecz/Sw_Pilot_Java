package Bio09;

public class Menu {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "원";
    }

}
