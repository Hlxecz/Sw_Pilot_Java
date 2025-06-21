package Rule06;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalFrequencyAnalyzer {
    private Map<String, Integer> animalCountMap ;
    private Set<String> uniqueAnimal;

    public AnimalFrequencyAnalyzer(List list) {
        this.animalCountMap = new HashMap<>();
        this.uniqueAnimal = new HashSet<>(list);
        analyze(list);
    }

    private void analyze(List<String> list){
        for (String animal : list){
            animalCountMap.put(animal,animalCountMap.getOrDefault(animal,0)+1);
        }
    }

    public void printAnimalCount() {
        Map<Integer,List<String>> groups = animalCountMap.entrySet().stream()
                .collect(Collectors.groupingBy
                        (Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList())));
    }

    public void printMostAnimal(){
        System.out.println(
                "가장 많이 발견된 동물: " +
                        animalCountMap.entrySet().stream()
                                .filter(entry -> entry.getValue().equals(
                                      Collections.max(animalCountMap.values())
                                ))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.joining(", "))
        );

    }


    public String getUniqueAnimal() {
        return String.join(", ",uniqueAnimal);
    }
}
