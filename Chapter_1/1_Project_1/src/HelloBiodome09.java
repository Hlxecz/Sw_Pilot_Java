public class HelloBiodome09 {
    public static void main(String[] args) {
        // 1. 입력값 유효성 검사
        if (args.length < 1 || args.length > 2) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        int n = 0; //나무 높이
        char special = '*'; // 2번째 인자 기본용

        try {
            n = Integer.parseInt(args[0]); // 나무 높이
            if (n < 3 || n > 100) {
                System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        if (args.length == 2) {
            special = args[1].charAt(0); // 두번째 인자의 첫문자만 아스키코드로 저장
        }

        // 2. 나무 본체 출력
        printTree(n, special);

        // 3. 기둥 출력
        printTrunk(n);
    }

    // 본체 그리기
    static void printTree(int n, char special) {
        for (int i = 1; i <= n; i++) {
            // (1) 공백: 왼쪽 여백 (n - i개)
            for (int j = 0; j < n - i; j++) System.out.print(" ");

            // (2) 왼쪽 별: (i - 1)개
            for (int j = 0; j < i - 1; j++) System.out.print("*");

            // (3) 가운데 특수문자 또는 별
            System.out.print(special);

            // (4) 오른쪽 별: (i - 1)개
            for (int j = 0; j < i - 1; j++) System.out.print("*");

            // (5) 줄바꿈
            System.out.println();
        }
    }

    // 기둥 출력 (가운데 정렬된 | 한 개)  n번째 자리
    static void printTrunk(int n) {
        for (int i = 0; i < n - 1; i++) System.out.print(" ");
        System.out.println("|");
    }
}
