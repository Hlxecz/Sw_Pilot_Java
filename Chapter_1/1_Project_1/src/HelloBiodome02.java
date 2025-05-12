public class HelloBiodome02 {
    public static void main(String[] args) {

        if (args.length == 3) {
            // 3개 숫자 모두 1~30000 범위인지 확인
            boolean check = true;
            int[] values = new int[3];
            double[] fvals = new double[3];
            int sum = 0 ;

            for (int i = 0; i < args.length; i++) {
                //val 배열안의 문자열 값들 정수와 실수로 나눠담기
                int val = Integer.parseInt(args[i]);

                if (val > 0 && val < 30001) {
                    values[i] = val;
                    fvals[i] = val;
                    sum += values[i];
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                int solar = values[0];
                int wind = values[1];
                int geo = values[2];
                System.out.printf("태양광: %d, 풍력: %d, 지열: %d\n", solar, wind, geo);
                System.out.println("총 에너지 사용량은 " + sum + "입니다.");
                Percent(fvals,sum);
            } else {
                System.out.println("입력 값은 1 이상 30000 이하의 숫자여야 합니다.");
            }

        } else {
            System.out.println("태양광, 풍력, 지열 3가지 값을 입력하세요.");
        }

    }

    public static void Percent(double[] fvals,int sum){
        //비율 구하기
        //새로운 배열로 확장성 까지 고려 해봤음
        double[] ratio = new double[3];
        for (int i = 0; i < fvals.length; i++) {
            ratio[i] = fvals[i] / sum * 100;
        }
        //자바에서 프린트 % 할려면 %%
        //더블 타입 8자리 까지 나타내기 - 실수타입f
        System.out.printf("태양광 : %.8f%%, 풍력 : %.8f%%, 지열 : %.8f%%\n", ratio[0], ratio[1], ratio[2]);


    }

}
