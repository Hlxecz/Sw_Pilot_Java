import static java.lang.System.exit;

public class HelloBiodome07 {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("염기서열이 입력되지 않았습니다.");
            exit(0);
        }

        // 입력 전체를 하나의 문자열로 합쳐서 처리함
        String input = String.join(" ", args).toUpperCase();

        // 보너스문제: 공백 여러 개 → 공백 1개로 정리  ->   \\s 는 는 정규 표현식에서 공백 문자(띄어쓰기, 탭, 줄 바꿈 등) +는 1개이상
        input = input.replaceAll("\\s+", " ");

        String result = checkDNA(input);

        // 만약 compressDNA에서 null을 반환하면 → 문자 오류
        if (result == null) {
            System.out.println("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");
        } else {
            System.out.println("염기서열은 : " + result);
        }
    }

    public static String checkDNA(String input) {
        String dna = "CYJEH";
        String result = ""; //String을 배열로 사용할 수 있다.
        int count = 1;

        for (int i = 1; i <= input.length(); i++) {
            //이전 문자 확인 prev (0부터 시작)
            char prev = input.charAt(i - 1);

            // 공백이고, 허용 문자아니면 null 반환
            if (dna.indexOf(prev) == -1 && prev != ' ') {
                return null;
            }
            
            //마지막 단어 전까지 돌아가기 / 현재의 문자와 이전의 문자의 비교 같다면 카운트 ++
            if (i < input.length() && input.charAt(i) == prev) {
                count++;
            } else {
                //아니면 string에 추가
                result += prev;
                if (count > 1) {
                    result += count;
                }
                count = 1;
            }
        }

        return result;
    }
}
