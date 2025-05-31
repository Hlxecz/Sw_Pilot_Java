package Bio09;

public class OrderItem {
    private Menu menu;
    private int quantity;

    public OrderItem(Menu menu) {
        this.menu = menu;
        this.quantity = 1;
    }

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    public String toString() {
        return menu.getName() + " - " + quantity + "개: " + getTotalPrice() + "원";
    }
}
