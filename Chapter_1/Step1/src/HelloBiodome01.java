//javac HelloBiodome01.java 바이트 코드로 변경
//java -cp . HelloBiodome01 형준 자바
// 클래스 이름뒤 변수가 C언어랑은 다르게 자바는 주소가 들어가지 않기 때문에
// args[0]번째 부터 들어갑니다
// [형준,자바] -> "형준 자바" 님 ! 스프링와트에 오신것 환영합니다 !

public class HelloBiodome01 {
    public static void main(String[] args) {
        System.out.print("이름을 입력해주세요 : ");

        if(args.length > 0) {
            String name = String.join(" ",args);
            System.out.printf(" \"%s\" 님 ! 스프링와트에 오신것 환영합니다 !",name);
        }





        woejfowejnf
        else{
            System.out.println("\n한 글자 이상 입력해주세요.");
            }
        }
    }


