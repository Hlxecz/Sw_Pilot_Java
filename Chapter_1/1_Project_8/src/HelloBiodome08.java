import java.util.Arrays;
import static java.util.Comparator.comparing;

public class HelloBiodome08 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("한 문장만 입력하세요.");
            return;
        }

        String input = args[0];
        String regex = "^[a-z?]+$";

        if (!input.matches(regex) || input.length() > 100) {
            System.out.println("입력은 소문자와 물음표만, 최대 100자까지 허용됩니다.");
            return;
        }

        String[] dictionary = {
                "hello", "where", "this", "biodome", "help", "tree", "new", "is",
                "problem", "please", "need", "we", "isn’t", "there", "a", "your",
                "any", "thanks", "the", "for", "solution", "can", "?"
        };

        //sort 정렬 결과를 return 받지 않아도 되고, dic 자체가 바뀜
        //comparing 타입 length길이별 .내림차순()
        Arrays.sort(dictionary, comparing(String::length).reversed());

        String result = splitSentence(input, dictionary);
        System.out.println(result);
    }

    public static String splitSentence(String input, String[] dictionary) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        boolean endsWithQuestion = input.endsWith("?");

        // 마지막 ? 따로 떼어두고 분석
        String workingInput = endsWithQuestion ? input.substring(0, input.length() - 1) : input;

        while (index < workingInput.length()) {
            boolean matched = false;

            for (String word : dictionary) {
                int len = word.length();
                if (index + len <= workingInput.length()) {
                    String val = workingInput.substring(index, index + len);
                    if (val.equals(word)) {
                        result.append(word).append(" ");
                        index += len;
                        matched = true;
                        break;
                    }
                }
            }

            if (!matched) {
                int start = index;
                while (index < workingInput.length()) {

                    boolean foundNext = false;

                    for (String word : dictionary) {
                        int len = word.length();

                        if (index + len <= workingInput.length()) {
                            String sub = workingInput.substring(index, index + len);
                            if (sub.equals(word)) {
                                foundNext = true;
                                break;
                            }
                        }
                    }
                    if (foundNext) break;
                    index++;
                }
                result.append(workingInput.substring(start, index)).append(" ");
            }
        }

        // 공백 제거 -> 문장길이의 젤 끝값이 공백이면 -1로 한단어 줄임
        if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            //setLength()는 문자열 길이를 조절 할 수 있다.
            result.setLength(result.length() - 1);
        }


        // 끝 처리
        if (endsWithQuestion) {
            result.append("?");
        } else {
            result.append(".");
        }

        return result.toString();
    }
}

//canwebelieveinyou?
//사전: can, we, you, ? 있음. believein 없음.
//
//can → 매치됨 → 추가됨
//
//we → 매치됨 → 추가됨
//
//believein → 매치 안됨 → 이 while문 진입
//
//index는 6이고 start = 6
//
//believein을 계속 탐색하다가
//
//you라는 사전 단어가 index=15에서 발견됨
//
//그러면 workingInput.substring(6, 15) → "believein" 추가됨