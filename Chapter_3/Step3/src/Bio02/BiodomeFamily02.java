package Bio02;

public class BiodomeFamily02 {
    public static void main(String[] args) {
        LifeNest list = new LifeNest();
        //기본 문제
//        list.addList(new Organism("펭귄","동물","남극"));
//        list.addList(new Organism("코알라","동물","호주"));
//        list.addList(new Organism("선인장","식물","사막"));
//        list.addList(new Organism("페퍼민트","식물","정원"));
//        list.findAll();
//
//
//        list.remove("코알라");
//        list.remove("선인장");
//        list.update("펭귄","해변");
//        list.findAll();

        //보너스 문제
        list.addList(new Organism("코끼리","동물","습지대","지능이높다","60년"));
        list.addList(new Organism("라일락","식물","온대 지역","향기가 강하다","100년"));
        list.findAll();

        list.update("코끼리", "코가 길다");
        list.findAll();




    }
}
