package Bio05.Interface;

public interface Chargeable {
    void charge(int amount);
    void getChargeLevel();

    static void showChargingTips() {
        System.out.println("에너지를 효율적으로 충전하려면 마법사의 기분이 좋아야합니다.");
    }

}
