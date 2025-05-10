import static java.lang.System.exit;


class HelloBiodome04 {
    static final double PIE = 3.14;
    static final double BEO = 0.415;
asdfasfsaf
    public static void main(String[] args) {
        double hum , tem, oxy = 0.0; //습도 , 온도, 산소s
        boolean check;


        if(args.length == 3){
            //문자인지 확인 하는법
            try {
                tem= Double.parseDouble(args[0]);
                hum = Double.parseDouble(args[1]);
                oxy = Double.parseDouble(args[2]);

                check = rangeCheck(tem,hum,oxy);
                if(!check){
                    System.out.println("검토 결과에 따른 결과(안전/확인필요)");
                    exit(0);
                }
                else{
                    calculateAndPrint(tem,hum,oxy);
                }


            }catch(NumberFormatException e){
                System.out.println("문자를 입력하셨습니다.\n[온도][습도][산소농도]숫자로 입력하세요.");
                exit(0);
            }

        }
        else{
            System.out.println("값이 3개 모두 입력 되지 않았습니다.\n[온도][습도][산소농도] 다시 입력하여 주세요.\n");
        }


    }
    private static void calculateAndPrint(double tem, double hum, double oxy) {
        //계산된 습도
        double humC = humSqrt(hum);
        //절대값 변수
        double absVal = absValues(humC, tem);
        //건강지수
        double treeH = TreeValue(absVal, oxy);

        System.out.printf("%.1f[온도], %.1f[습도], %.1f[산소농도]\n", tem, hum, oxy);
        System.out.printf("생명지수 H = %.2f", ((int)(treeH * 100 + 0.5)) / 100.0);
    }



    private static boolean rangeCheck(double tem, double hum, double oxy) {
        int cnt = 0;
        boolean Ck = true;

        if (10.0 >= tem || tem > 27.5) { // 4
            System.out.println("온도값이 정상 범위를 벗어났습니다.");
            cnt += 4;
            Ck = false;
        }
        if (40.0 > hum || hum > 60.0) { // 2
            System.out.println("습도값이 정상 범위를 벗어났습니다.");
            cnt += 2;
            Ck = false;
        }
        if(19.5 >= oxy || oxy >=23.5){ // 1
            System.out.println("산소 농도값이 정상 범위를 벗어났습니다.");
            cnt += 1;
            Ck = false;
        }

        switch (cnt){
            case 6:
                System.out.println("온도와 습도는 동시에 정상범위를 벗어날 수 없습니다.");
                exit(0);
                break;
            case 0:
                System.out.println("생명의 나무는 안정적인 상태입니다.");
                break;
        }

        return Ck;
    }

    private static double TreeValue(double absVal, double oxy) {
        return (BEO * absVal + (oxy/(PIE*PIE)));
    }

    private static double absValues(double hum, double tem) {
        //절대값 계산
        double result = hum - tem;
        return (result < 0) ? -result : result;
    }


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
}
