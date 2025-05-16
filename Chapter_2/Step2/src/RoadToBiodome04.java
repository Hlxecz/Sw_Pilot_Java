public class RoadToBiodome04 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("하나 이상의 정렬할 배열을 입력하시오.");
            return;
        }

        // 단일 배열 입력: 평균 + 중앙값 출력
        if (args.length == 1) {
            String input = args[0].replaceAll("\\[|\\]", "");
            String[] tokens = input.split(",\\s*");

            int[] numbers = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                numbers[i] = Integer.parseInt(tokens[i]);
            }

            // 선택 정렬
            sortValue(numbers);

            // 평균값
            averageValue(numbers);

            // 중앙값
            centerValue(numbers);

            System.out.println(); // 줄바꿈
        }
        // 두 개 이상 입력: 각 배열의 중앙값만 출력
        else {
            for (String arg : args) {
                String input = arg.replaceAll("\\[|\\]", "");
                String[] tokens = input.split(",\\s*");

                int[] numbers = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    numbers[i] = Integer.parseInt(tokens[i]);
                }

                // 선택 정렬
                sortValue(numbers);

                // 중앙값만 출력
                centerValue(numbers);
                System.out.println(); // 줄바꿈
            }
        }
    }

    // 선택 정렬 구현
    private static void sortValue(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    // 평균값 출력
    private static void averageValue(int[] numbers) {
        double sum = 0;
        for (int token : numbers) {
            sum += token;
        }
        System.out.print("평균값 : " + sum / numbers.length);
    }

    // 중앙값 출력
    public static void centerValue(int[] numbers) {
        if (numbers.length % 2 != 0) { // 홀수이면
            int index = (int) (((double) numbers.length / 2) - 0.5);
            System.out.print(" 중앙값 : " + numbers[index]);
        } else {
            double centerV = ((double) (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2);
            System.out.print(" 중앙값 : " + centerV);
        }
    }
}

