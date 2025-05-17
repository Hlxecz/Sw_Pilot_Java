import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoadToBiodome07 {
    public static void main(String[] args) {
        if(!args[0].matches("[가-힣]+")){
            System.out.println("동물의 이름을 작성하여 주세요");
            return;
        }
        String ani[] = Arrays.stream(args[0].replaceAll("\\[|\\]","").split("[,\\s]+"))
                .toArray(String[]::new);

        //빈도수 계산
        Map<String, Integer> val = new HashMap<String,Integer>();
        for(String animal : ani){
            //getOrDefault -> animal 의 값이 있으면 animal value값 + 1 없으면 0 + 1
            val.put(animal,val.getOrDefault(animal,0) + 1);
        }

        sortValue(val);

    }

    private static void sortValue(Map<String,Integer> val){

    }

}
