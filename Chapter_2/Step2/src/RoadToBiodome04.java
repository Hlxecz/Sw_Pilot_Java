public class RoadToBiodome04 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("하나 이상의 정렬할 배열을 입력하시오.");
            return;
        }

        String input = args[0].replaceAll("\\[|\\]", "");
        String[] tokens = input.split(",\\s*");

        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        // 변환 작업 끝

        //정렬 시작
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            // 스왑 swap
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }

        //평균값
        averageValue(numbers);
        //중앙값
        centerValue(numbers);

    }

    private static void averageValue(int[] numbers) {
        double sum = 0;
        for(int token : numbers){
            sum += token;
        }
        System.out.print("평균값 : " + sum/numbers.length);
    }


    public static void centerValue(int[] numbers){
        if(numbers.length % 2 != 0){ //홀수이면
            int index = (int)(((double) numbers.length / 2) - 0.5);
            System.out.print(" 중앙값 : " + numbers[index]);
        }else{
            double centerV = ((double) (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2);
            System.out.print(" 중앙값 : " + centerV );
        }
    }

}
