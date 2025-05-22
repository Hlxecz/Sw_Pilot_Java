package Bio03;

import java.util.ArrayList;
import java.util.Iterator;


public class LifeNest {
    private ArrayList<Organism> organismList;
    
    public LifeNest() {
        this.organismList = new ArrayList<>();
    }

    public ArrayList<Organism> getOrganismList() {
        return organismList;
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


    public Organism findList(String name) {
        for (Organism o : organismList) {
            if (o.getName().equals(name)) return o;
        }
        return null;
    }
}
