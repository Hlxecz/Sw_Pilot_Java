public class RoadToBiodome02 {
    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println("단어뒤 *는 회문입니다 !");
            String sen = String.join(" ", args);

            // 문자열 유효성 검사
            if (sen.length() < 2 || sen.length() > (int) Math.pow(10, 6)) {
                System.out.println("정해진 문자열의 길이는 2 ~ 10**6 까지입니다.");
                System.exit(0);
            } else if (!sen.matches("^[0-9a-zA-Z가-힣 ]+$")) {
                System.out.println("영문자, 숫자, 한글, 공백만 포함해야 합니다.");
                System.exit(0);
            }

            
            // 단어 단위로 나누기
            String[] sens = sen.split(" ");

            // 단어 역순 처리
            for (int i = sens.length - 1; i >= 0; i--) {
                String word = sens[i];
                boolean sameWord = true;
                
                //회문 검사
                for (int e = 0; e < word.length() / 2; e++) {
                    if (word.charAt(e) != word.charAt(word.length() - 1 - e)) {
                        sameWord = false;
                        break;
                    }
                }

                if (sameWord) {
                    System.out.print(word+"*");
                } else {
                    //회문 아니면 역순 출력
                    for (int j = word.length() - 1; j >= 0; j--) {
                        System.out.print(word.charAt(j));
                    }
                }

                System.out.print(" ");
            }

        } else {
            System.out.println("올바른 문장을 입력해주세요.");
        }

    }
}
