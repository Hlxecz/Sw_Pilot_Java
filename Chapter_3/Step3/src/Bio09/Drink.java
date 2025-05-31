package Bio09;

import Bio09.Enum.DrinkType;
import Bio09.Enum.Size;

public class Drink extends Menu {
    private DrinkType type;
    private Size size;

    public Drink(DrinkType type, Size size) {
        super(type.getDisplayName(), type.getPrice() + size.getExtraCharge());
        this.type = type;
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
