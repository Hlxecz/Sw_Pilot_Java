package Bio04;

public class EnergyManager {
    private static int total = 0;

    public EnergyManager(int total) {
        EnergyManager.total = total;
    }

    public static int getTotal() {
        return EnergyManager.total;
    }

    public static void addTotal(int total) {
        EnergyManager.total += total;
    }

    public static void minTotal(int total) {
        EnergyManager.total -= total;
    }

    public static void TotalAmount(){
        System.out.println("남은 에너지 : " + total);
    }
}
