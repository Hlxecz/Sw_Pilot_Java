package Rule06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RuleOfBiodome06 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        Collections.addAll(list,
                "호랑이", "사자", "악어", "표범", "하이에나", "치타",
                "호랑이", "사자", "표범", "하이에나", "악어", "호랑이",
                "하이에나", "치타", "호랑이", "코뿔소", "사자", "악어",
                "표범", "하이에나", "치타", "호랑이", "사자", "악어",
                "표범", "하이에나", "치타", "호랑이", "사자", "악어",
                "표범", "하이에나", "치타", "호랑이", "사자", "악어",
                "하이에나", "치타", "호랑이", "사자", "표범", "호랑이",
                "사자", "악어", "하이에나", "치타", "표범", "하이에나",
                "치타", "코뿔소", "호랑이"
        );

        AnimalFrequencyAnalyzer ani = new AnimalFrequencyAnalyzer(list);
        ani.printMostAnimal();
        ani.printAnimalCount();
        System.out.println(ani.getUniqueAnimal());

    }

}




