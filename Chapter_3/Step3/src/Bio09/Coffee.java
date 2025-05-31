package Bio09;

import Bio09.Enum.CoffeeType;
import Bio09.Enum.Size;

public class Coffee extends Menu {
    private CoffeeType coffeeType;
    private Size size;

    public Coffee(CoffeeType type, Size size) {
        super(type.getDisplayName(), type.getPrice() + size.getExtraCharge());
        this.coffeeType = type;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getName() + " (사이즈: " + size.getDisplayName() + ") - " + getPrice() + "원";
    }
}
