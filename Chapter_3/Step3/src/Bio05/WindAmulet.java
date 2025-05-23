package Bio05;

import Bio05.Interface.WeatherController;

public class WindAmulet extends AncientArtifact implements WeatherController {

    protected WindAmulet() {
        super("바람의 부적");
    }

    @Override
    void describe() {
        System.out.println("바람의 부적으로 저기압, 고기압, 강풍 등을 감지해 주변 공기의 흐름을 이용해 날씨를 조절합니다.\n");
    }

    @Override
    public void controlWeather() {
        System.out.println("바람의 부적이 날씨를 조절합니다.");
    }
}


