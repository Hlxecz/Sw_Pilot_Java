import java.util.Arrays;

//보너스 과제 30이상만 계산 출력
//.filter(n -> n > 30)
// 16 21 라인에 필터로 30이상만 배열형태로 만들면 된다.

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
                    //.filter(n -> n >= 30) 보너스 과제
                    .toArray();

            int[] numbers2 = Arrays.stream(args[1].replaceAll("\\[|\\]", "").split(",\\s*"))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    //.filter(n -> n >= 30) 보너스 과제
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
            double aV = averValue(numbers1, numbers2, n, m);
            System.out.println(args[0] + " " + args[1]);
            System.out.printf("Mean : %.1f " , aV);
            //double 타입의 printf 는 자동으로 반올림해준다
            System.out.print("Median : " + cV);

        } catch (NumberFormatException e) {
            System.out.println(" 0 ~ 100 사이의 숫자만 담은 배열을 두개 입력하세요 .");
            System.exit(0);
        }

    }

    private static double averValue(int[] numbers1, int[] numbers2, int n, int m){
        int sumLen = n + m;
        int sum = 0;

        for(int number : numbers1){
            sum += number;
        }

        for(int number : numbers2){
            sum += number;
        }

        return (double) sum / sumLen;
    }

    private static double centerValue(int[] numbers1, int[] numbers2, int n, int m) {
        int sumLen = n + m;
        int mid1 = (sumLen - 1) / 2; //중간값 인덱스
        int mid2 = sumLen / 2;       //짝수일때 왼쪽값의  오른쪽 값 인덱스

        int i = 0, j = 0, count = 0;
        int val1 = 0, value = 0;

        while (count <= mid2) {
            // numbers1에서 꺼낼 수 있는 값이 남아있고,
            //그리고 numbers2가 끝났거나,
            //아니면 numbers1[i] 값이 numbers2[j]보다 작으면 → numbers1[i]를 꺼낸다.
            if (i < n && (j >= m || numbers1[i] <= numbers2[j])) {
                value = numbers1[i++];
            } else {
                value = numbers2[j++];
            }

            // 짝수의 값을 구하기 위해서
            if (count == mid1) val1 = value;
            count++;
        }

        return (sumLen % 2 == 0) ? (val1 + value) / 2.0 : val1;
    }

}




