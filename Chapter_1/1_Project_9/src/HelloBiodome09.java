public class HelloBiodome09 {
    public static void main(String[] args) {
        if (args.length > 0 && args.length < 3) {
            int star = Integer.parseInt(args[0]);

            if (star > 2 && star < 101) {

                // 좌
                for (int i = 1; i <= star; i++) {
                    for (int j = 0; j < star - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();



                }

                // 우
                for (int i = 1; i <= star; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }


            } else {
                System.out.println("별의 범위는 3 ~ 100 까지입니다.");
            }
        } else {
            System.out.println("최대 두 개의 인자만 넣을 수 있습니다.");
        }
    }
}
