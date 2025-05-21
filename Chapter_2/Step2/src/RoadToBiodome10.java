import java.util.Stack;

public class RoadToBiodome10 {
    static boolean[] visited = new boolean[100]; //방문 여부
    static boolean[][] realationShip = new boolean[100][100]; // 관계 여부
    static boolean[] exist = new boolean[100]; //존재 여부

    public static void main(String[] args) {
        ckRange(args);
        for (int i = 0; i < args.length; i++) {
            String[] genes = args[i].split(",");
            if (genes.length != 2) throw new IllegalArgumentException("잘못된 입력 형식입니다.");

            int value = ckValue(genes[0]);
            int value2 = ckValue(genes[1]);

            //역순도 같다.
            realationShip[value - 1][value2 - 1] = true;
            realationShip[value2 - 1][value - 1] = true;

            //존재여부
            exist[value - 1] = true;
            exist[value2 - 1] = true;
        }

        int cnt = 0;
        for (int i = 0; i < exist.length; i++) {
            if (!visited[i] && exist[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.printf("%d 가지의 연관관계가 있습니다.",cnt);
    }


    private static void dfs(int flower) {
        Stack<Integer> stack = new Stack<>();
        visited[flower] = true;
        stack.push(flower);

        while (!stack.empty()) {
            int rene = stack.pop();

            for (int i = 0; i < exist.length; i++) {
                if (!visited[i] && realationShip[rene][i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }

        }

    }


    private static int ckValue(String s) {
        int value = 0;
        try {
            value = Integer.parseInt(s);
            if (value < 1 || value > 101) {
                System.out.println("식물 유전자의 값은 0~100 사이값 입니다.");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("문자를 입력하셨습니다.");
            System.exit(0);
        }
        return value;
    }


    static void ckRange(String[] args) {
        if (args.length < 1) {
            System.out.println("1개 이상의 유전 정보를 가지고 오세요");
            System.exit(0);
        }
    }

}
