package Bio09;

import Bio09.Enum.Sandwichingredient;

import java.time.LocalDate; // 일까지만 있으면 됨

public class SandWich extends Menu {
    private Sandwichingredient sandwichingredient;
    private LocalDate expiryDate;

    public SandWich(Sandwichingredient ingre) {
        super(ingre.getDisplayName(), ingre.getPrice());
        this.sandwichingredient = ingre;
        this.expiryDate = ingre.getExpiryDate();
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Sandwichingredient getSandwichingredient() {
        return sandwichingredient;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "원 " +
                "(재료: " + sandwichingredient.name() +
                ", 만료일: " + expiryDate + ")";
    }

}
