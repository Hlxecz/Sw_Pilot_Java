import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoadToBiodome01 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("배열 형태의 문자열 하나만 입력해 주세요.");
            return;
        }

        // input 대괄호 제거
        // 쉽표 기준 뒤에 공백도 다제거
        // a,    b,  c -> [a,b,c]
        String[] tokens = args[0].replaceAll("\\[|\\]","").split(",\\s*");

        List<Integer> list = new ArrayList<>();

        try {
            for (String token : tokens) {
                int value = Integer.parseInt(token);

                //값 유효성 범위 검사
                if (value < 0 || value > 1000) {
                    System.out.println("파동수의 최소값은 0이며 최대값은 1000입니다.");
                    System.exit(0);
                }else{
                    list.add(value);
                }

            }
        }catch(NumberFormatException e){
            System.out.println("숫자만 입력 가능합니다.");
        }

        boolean found = false;
        for (int val : list) {
            //Collections.frequency -> list 안에 val 이 몇번 등장하는지를 반환
            if (Collections.frequency(list, val) == 1) {
                System.out.println("1번 등장하는 값 : " + val + " ");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("1번만 등장하는 값이 없습니다.");
        }


    }
}

// 보너스과제 k번씩 반복되고 하나의 요소만 1번 등장할때도 사용할 수 있는 일반화된 기능구현
// Collections.frequency 를 통해 1 반환하는것을 구현 했기 때문에 통과