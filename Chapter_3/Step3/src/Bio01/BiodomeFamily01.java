package Bio01;

public class BiodomeFamily01 {
    public static void main(String[] args) {
        LifeNest list = new LifeNest();
        list.addList(new Organism("펭귄","동물","남극"));
        list.addList(new Organism("코알라","동물","호주"));
        list.addList(new Organism("선인장","식물","사막"));
        list.addList(new Organism("페퍼민트","식물","정원"));
        list.findAll();
        
        list.remove("펭귄");
        list.findAll();

        //보너스과제
        list.searchOrganismByName("선인장");
    }
}
