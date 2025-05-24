package Bio06;

import Bio06.Enum.AnimalType;

import java.util.LinkedList;
import java.util.List;

public class BiodomeFamily06 {
    public static void main(String[] args) throws Exception {
        List<Animal> animals = new LinkedList<>();

        animals.add(new Animal("제니", AnimalType.ofKorean("원숭이"), 4));
        animals.add(new Animal("고먀", AnimalType.ofKorean("코끼리"), 4));
        animals.add(new Animal("타이", AnimalType.ofKorean("호랑이"), 9));
        animals.add(new Animal("로아", AnimalType.ofKorean("코뿔소"), 5));
        animals.add(new Animal("바비", AnimalType.ofKorean("사슴"), 7));

        safeSorted.sorted(animals);


        System.out.print("안전한 순서: [ ");
        for (Animal a : animals) {
            System.out.print(a+" ");
        }
        System.out.println(" ]");
    }
}

