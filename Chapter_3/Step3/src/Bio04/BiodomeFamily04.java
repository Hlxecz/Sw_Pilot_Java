package Bio04;

public class BiodomeFamily04 {
    public static void main(String[] args) {
        EnergySource solar = new SolarEnergy();
        EnergySource wind = new WindEnergy();
        EnergySource geo = new GeoEnergy();

        System.out.println("====== 에너지 생산 ======");
        solar.produceEnergy(50);
        wind.produceEnergy(300);
        geo.produceEnergy(4);

        System.out.println("====== 에너지 사용 ======");
        solar.useEnergy(30);
        wind.useEnergy(30);
        geo.useEnergy(30);

        EnergyManager.TotalEnergy(solar, wind, geo);
        //static 메서드로 클래스 명으로 접근 가능
    }
}
