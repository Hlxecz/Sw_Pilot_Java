package Bio02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LifeNest {
    private ArrayList<Organism> organismList;
    private Scanner scanner;

    public LifeNest() {
        this.organismList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addList(Organism org) {
        organismList.add(org);
        System.out.println("[" + this.getClass().getSimpleName() + "] " + org.getName() + "이 추가되었습니다.");
    }

    public void remove(String name) {
        Iterator<Organism> iterator = organismList.iterator();
        while (iterator.hasNext()) {
            Organism o = iterator.next();
            if (o.getName().equals(name)) {
                iterator.remove();
                System.out.println("[LifeNest] " + o.getName() + "이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 이름의 동식물을 찾을 수 없습니다.");
    }

    public void findAll() {
        System.out.println("전체 동식물 목록 출력:");
        for (Organism list : organismList) {
            list.displayInfo();
        }
    }

    public void update(String name, String changeValue) {
        Organism target = findList(name);
        if (target == null) {
            System.out.println("해당 이름의 동식물을 찾을 수 없습니다.");
            return;
        }

        System.out.println("1.이름 2.종 3.서식지 4.특징 5.수명 수정할 것 고르시오");
        int num = Integer.parseInt(scanner.nextLine());
        String field = "";

        switch (num) {
            case 1 -> { target.setName(changeValue); field = "이름"; }
            case 2 -> { target.setSpecies(changeValue); field = "종"; }
            case 3 -> { target.setHabitat(changeValue); field = "서식지"; }
            case 4 -> { target.setCharacteristic(changeValue); field = "특징"; }
            case 5 -> { target.setLifeSpan(changeValue); field = "수명"; }
            default -> {
                System.out.println("잘못된 번호입니다.");
                return;
            }
        }

        System.out.printf("[%s] %s의 %s가 변경되었습니다.%n",
                this.getClass().getSimpleName(), target.getName(), field);
    }

    public Organism findList(String name) {
        for (Organism o : organismList) {
            if (o.getName().equals(name)) return o;
        }
        return null;
    }
}
