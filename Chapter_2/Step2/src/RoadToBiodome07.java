import java.util.*;

public class RoadToBiodome07 {
    public static void main(String[] args) {
        if (!args[0].matches("[가-힣]+")) {
            System.out.println("동물의 이름을 작성하여 주세요");
            return;
        }
        String ani[] = Arrays.stream(args[0].replaceAll("\\[|\\]", "").split("[,\\s]+"))
                .toArray(String[]::new);

        //빈도수 계산
        Map<String, Integer> val = new HashMap<String, Integer>();
        for (String animal : ani) {
            //getOrDefault -> animal 의 값이 있으면 animal value값 + 1 없으면 0 + 1
            val.put(animal, val.getOrDefault(animal, 0) + 1);
        }
        sortValue(val);
    }


    private static void sortValue(Map<String, Integer> val) {
        // Map → Entry 배열로 변환
        Map.Entry<String, Integer>[] entries = val.entrySet().toArray(new Map.Entry[0]);

        // 선택 정렬 수행
        for (int i = 0; i < entries.length - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < entries.length; j++) {
                int freqCompare = entries[j].getValue().compareTo(entries[maxIdx].getValue());

                if (freqCompare > 0 || (freqCompare == 0 &&
                        entries[j].getKey().compareTo(entries[maxIdx].getKey()) < 0)) {
                    maxIdx = j;
                }
            }

            // swap
            Map.Entry<String, Integer> temp = entries[i];
            entries[i] = entries[maxIdx];
            entries[maxIdx] = temp;
        }

        // 정렬된 결과 출력
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
