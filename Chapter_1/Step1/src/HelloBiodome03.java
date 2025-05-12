/*
제약사항
사용자 입력은 Command Line Arguments 을 이용해 받는다.

Scanner , BufferedReader 를 사용할 수 없다.

Java 기본 제공 Math 패키지를 사용할 수 없다.

보너스 과제
계산된 건강지수 H 값을 소수점 셋째 자리에서 반올림하여 출력한다.

Math 패키지 사용할 수 없다.

for 와 while 반복문을 사용할 수 없다
 */


import static java.lang.System.exit;

class HelloBiodome03 {
    static final double PIE = 3.14;
    static final double BEO = 0.415;

    public static void main(String[] args) {
        double hum , tem, oxy = 0.0;
        //습도 , 온도, 산소
        double humC;
        //계산된 습도
        double absVal;
        //절대값 변수
        double treeH;
        //건강지수

        if(args.length == 3){
            //문자인지 확인 하는법
            try {
                tem= Double.parseDouble(args[0]);
                hum = Double.parseDouble(args[1]);
                oxy = Double.parseDouble(args[2]);

                //습도 구하기 메서드
                humC = humSqrt(hum);
                //습도 온도 절대값 메서드
                absVal = absValues(humC,tem);
                // 나무 건강지수 계산하는 수식
                treeH = TreeValue(absVal,oxy);

                System.out.printf("%.1f[온도], %.1f[습도], %.1f[산소농도]\n",tem,hum,oxy);
                System.out.printf("생명지수 H = %.2f" ,((int)(treeH * 100 + 0.5)) / 100.0);
                //반올림 식 2번째 자리까지 반올림이 필요하니까 .을 2자리 이동시킴(*100) 0.5 를 더해서 소수점 자리의 수가 5보다 크면
                //1이 올라간다 그다음 정수형으로 소숫점 자르고 다시 / 100 하면 반올림이 된다.
            }catch(NumberFormatException e){
                System.out.println("문자를 입력하셨습니다.\n[온도][습도][산소농도]숫자로 입력하세요.");
                exit(0);
            }

        }
        else{
            System.out.println("값이 3개 모두 입력 되지 않았습니다.\n[온도][습도][산소농도다시 입력하여 주세요.\n");
        }


    }

    private static double TreeValue(double absVal, double oxy) {
        return (BEO * absVal + (oxy/(PIE*PIE)));
    }

    private static double absValues(double hum, double tem) {
        double result = hum - tem;
        return (result < 0) ? -result : result;
    }

    // main 메서드에서 호출 합니다
    // main 메서드는  static 메서드이기 때문에 호출 하는 메서드도 정적인 메서드가 되어야지
    // main 에서 호출 할 수 있게됩니다 그렇기 대문에  humcal도 static으로 선언되어야 객체 생성 없이 직접 호출할 수 있다.

    public static double humSqrt(double hum){

            //바밀로니아 알고리즘
            double guess = hum / 2;

            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;
            guess = (guess + hum / guess) / 2;

        return guess;
    }
    
    //재귀함수 참고 -> 바밀로니아 같은 식 반복 줄이기
    /*private static double squareRoot = 1.0;

    static void root(double value) {
        if (squareRoot == (squareRoot + (value / squareRoot)) / 2) return;
        squareRoot = (squareRoot + (value / squareRoot)) / 2;
        root(value);
    } */

}
