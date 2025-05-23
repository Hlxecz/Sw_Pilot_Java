package Bio05;

import Bio05.Interface.Chargeable;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        Sorcerer ariel = new Sorcerer("아리엘");

        SolarStone solar = new SolarStone();
        WindAmulet wind = new WindAmulet();
        WaterMirror water = new WaterMirror();
        System.out.println();

        ariel.addArtifact(solar,wind,water);

        ariel.useArtifact(water);

        //보너스 문제
        System.out.println();

        solar.charge(50);
        water.charge(30);
        solar.charge(10);

        System.out.println();

        solar.getChargeLevel();
        water.getChargeLevel();

        System.out.println();
        Chargeable.showChargingTips();
    }
}
