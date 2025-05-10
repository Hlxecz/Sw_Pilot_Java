public class HelloBiodome05 {
    public static void main(String[] args) {
        int g;
        int h;
        int[] val = findGHValue();

        g = val[0];
        h = val[1];


        System.out.println("g의값 : " + g + " h의 값 : " + h);
        System.out.println("(h * h + g) * (h << h) + (g << g) 의 값 : " + (h * h + g) * (h << h) + (g << g));
        // 보너스 수식: 다양한 연산자를 사용해 같은 결과값 42를 만드는 수식
        System.out.print("보너스 수식\ng < 2 ? ((g << 1) * (h << h)) * h + ((h << 2) + h) : 0 의 값 : ");
        System.out.println(g < 2 ? ((g << 1) * (h << h)) * h + ((h << 2) + h) : 0);

    }

    public static int[] findGHValue() {
        for (int g = 0; g < 16; g++) {
            for (int h = 0; h < 16; h++) {
                //((g & 1) >> g << 2) == 1 는 무조건 false
                if (((h + g) ^ h) == 1) { //첫번째 식
                    //((1 & 0) ^ 0) 는 어쩌피 0이라 false
                    if (((g % 2) << h >> g) == 2) { //두번째 식
                        return new int[]{g, h};
                    }
                }
            }
        }
        return new int[]{0, 0};
    }

}


