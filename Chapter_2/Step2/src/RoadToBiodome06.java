import java.util.Arrays;


public class RoadToBiodome06 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("2개의 배열을 입력해주세요");
            return;
        }

        try {
            //정수형 배열로 변환
            int[] numbers1 = Arrays.stream(args[0].replaceAll("\\[|\\]", "").split(",\\s*"))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int[] numbers2 = Arrays.stream(args[1].replaceAll("\\[|\\]", "").split(",\\s*"))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            //유효성 검사 anyMatch 하나라도 범위를 벗어나면 true 반환해서 종료     all, none, any 3가지 존재
            if (Arrays.stream(numbers1).anyMatch(n -> n < 0 || n > 100) ||
                    Arrays.stream(numbers2).anyMatch(n -> n < 0 || n > 100)) {
                System.out.println("0~100 범위를 벗어난 값이 있습니다.");
                System.exit(0);
            }
            //배열 크기
            int n = numbers1.length;
            int m = numbers2.length;

            double cV = centerValue(numbers1, numbers2, n, m);


        } catch (NumberFormatException e) {
            System.out.println(" 0 ~ 100 사이의 숫자만 담은 배열을 두개 입력하세요 .");
            System.exit(0);
        }

    }

    private static double centerValue(int[] numbers1, int[] numbers2, int n, int m) {
        if (n + m % 2 == 0) {

        }
        else{

        }
        return 0; // 더블 반환 대기
    }
}




