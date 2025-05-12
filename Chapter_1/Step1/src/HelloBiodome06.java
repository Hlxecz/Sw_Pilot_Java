import static java.lang.System.exit;

public class HelloBiodome06 {
    public static void main(String[] args) throws Exception{
        if(args.length == 2){
            String gene1 = args[0].toLowerCase();
            String gene2 = args[1].toLowerCase();
            
            //유전자 문자열 길이 체크
            rangeCheck(gene1,gene2);

            boolean check = true;

            // Math min 함수로  while 반복 회수 정하기
            int minValue = Math.min(gene1.length(),gene2.length());
            //Math 못쓰면 아래의 코드 사용
            //(gene1.length >  gene2.length) ? gene1.length : gene2.length; 

            //대문자 들어와도 소문자로 변경   아스키코드 32 빼고 더하고 방법도 있음.
            char[] one = gene1.toCharArray();
            char[] two = gene2.toCharArray();


            int i = 0;

            while (check) {
                if (i < minValue) {
                    if (one[i] != two[i]) {
                        System.out.println("일치하지 않습니다.");
                        //보너스 문제 부분적으로 포함하는지
                        valueContain(gene1,gene2);
                        check = false;
                    } else {
                        i++;
                    }
                } else {
                    // 길이까지 포함해서 완벽히 같으면 이 위치에 도달함
                    if (gene1.length() == gene2.length()) {
                        System.out.println("동일한 유전자 코드입니다.");
                    } else {
                        System.out.println("일치하지 않습니다.");
                        //보너스 문제 부분적으로 포함하는지
                        valueContain(gene1,gene2);
                    }
                    check = false;
                }
            }

        }else{
            System.out.println("두개의 유전자 코드를 입력해 주세요.");
        }
    }

    private static void valueContain(String gene1, String gene2) {
        if (gene1.contains(gene2)) {
            System.out.println(gene2 + "유전자가 부분적으로 " + gene1 + "유전자에 포함됩니다");
        } else if (gene2.contains(gene1)) {
            System.out.println(gene1 + "유전자가 부분적으로 " + gene2 + "유전자에 포함됩니다");
        } else {
            System.out.println("부분적으로 포함 되지 않습니다.");
        }
    }


    private static void rangeCheck(String gene1, String gene2){
        if(gene1.length() < 5 || gene1.length() > 20 || gene2.length() < 5 || gene2.length() > 20){
            System.out.println("유전자 정보는 최소 5개 이상의 뉴클레오타이드로 이루어져있으며, 최대 20개 입니다.");
            exit(0);
        }
    }

}
