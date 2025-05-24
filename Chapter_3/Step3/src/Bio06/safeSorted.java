package Bio06;

import java.util.LinkedList;
import java.util.List;

public class safeSorted {
    public static void sorted(List<Animal> list) {
        List<Animal> deers = new LinkedList<>();
        Animal tiger = null;
        List<Animal> frontList = new LinkedList<>();
        List<Animal> babyElephants = new LinkedList<>() ;

        for (Animal a : list) {
            if (a.getName().equals("사슴")) {
                deers.add(a); //여러마리 사슴
            } else if (a.getName().equals("호랑이")) {
                tiger = a;
            } else if (a.getName().equals("코끼리") && a.getAge() <= 5) {
                babyElephants.add(a); //여러마리 코끼리
            } else {
                frontList.add(a); // 원숭이, 코뿔소 등
            }
        }

        list.clear();
        list.addAll(frontList);           // 일반 동물 먼저
        if (tiger != null) list.add(tiger); // 호랑이
        list.addAll(babyElephants);       // 코끼리(5살 이하)
        list.addAll(deers);; // 사슴은 무조건 맨 끝
    }
}

