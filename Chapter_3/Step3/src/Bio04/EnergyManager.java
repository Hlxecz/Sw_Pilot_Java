package Bio04;

public class EnergyManager {

    public static void TotalEnergy(EnergySource... sources) {
        //가변인자 ... 몇개가 매개변수 몇개인지 지정 x -> 같은타입만 가능 -> 배열형태로 들어옴
        int Total= 0;
        for (EnergySource s : sources) {
            Total += s.getEnergyAmount();
        }
        System.out.println("남은 에너지:" + Total);
    }


}
