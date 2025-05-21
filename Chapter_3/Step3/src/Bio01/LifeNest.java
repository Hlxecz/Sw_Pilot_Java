package Bio01;

import java.util.ArrayList;
import java.util.Iterator;

public class LifeNest {
    ArrayList<Organism> organismList;

    public LifeNest() {
        this.organismList = new ArrayList<>();
    }

    public void addList(Organism org){
        organismList.add(org);
        System.out.println("[LifeNest] "+org.getName()+"이 추가되었습니다.");

    }

    public void remove(String name){
        Iterator<Organism> iterator = organismList.iterator();
        while (iterator.hasNext()) {
            Organism o = iterator.next();
            if (o.getName().equals("코알라")) {
                iterator.remove();
                System.out.println("[LifeNest] "+o.getName()+"이 삭제되었습니다.");
                // 배열안에 값 지울때는 iterator사용
                // 그냥 지우게 되면 ConcurrentModificationException
            }
        }
    }

    public void findAll(){
        System.out.println("전체 동식물 목록 출력:");
        for(Organism list : organismList){
            list.displayInfo();
        }
    }

    public void searchOrganismByName(String name) {
        for(Organism list : organismList){
            if(list.getName().equals(name)){
                System.out.println(list.getName()+" (은/는) "+list.getSpecies()+"이며 "
                +list.getHabitat()+"에 서식합니다.");
            }
        }
    }
}
