package Bio03;

public class BiodomeFamily03 {
    public static void main(String[] args) {
        LifeNest list = new LifeNest();

//        list.addList(new Animal("펭귄","동물","남극","육식","물고기"));
//        list.addList(new Animal("코알라","동물","호주","초식","유칼립투스"));
//        list.addList(new Plant("선인장","식물","사막","11월","열매있음"));
//        list.addList(new Plant("페퍼민트","식물","정원","7월","열매없음"));
//        list.findAll();
//        list.remove("코알라");
//        list.remove("선인장");
//        list.findAll();

        //보너스
        list.addList(new Mammal("사자", "포유류", "사바나", "육식", "고기", true));
        list.addList(new Bird("독수리", "조류", "산악", "육식", "쥐", 2.1));
        list.addList(new Fish("연어", "어류", "강", "잡식", "플랑크톤", 4));

        list.findAll();

        for(Organism o : list.getOrganismList()){
            if(o instanceof Mammal m){
                m.giveBirth();
            }else if(o instanceof Bird b){
                b.fly();
            } else if (o instanceof Fish f) {
                f.swim();
            }
        }
    }
}
