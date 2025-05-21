import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome09_ABS {
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Queue<int[]> q = new LinkedList<>();
        int n = args.length, m = args[0].length();
        String[][] map = new String[n][m];

        for (int i = 0; i < args.length; i++) {
            map[i] = args[i].split("");
            for (String s : map[i]) {
                System.out.print(s+ " ");
            }
            System.out.println();
        }


        q.offer(new int[]{0, 0, 0, 4});
        // x, y , count , direction
        //기본값을 4로 준이유는 0 1 2 3 이 상하좌우 인데 아직 이동이 없기 때문에 아무의미없는 4로 주었습니다.
        //이유는 아래에서

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0], cy = current[1], count = current[2], direction = current[3];


            if (cx == n - 1 && cy == m -1) {
                System.out.println("answer = "+count);
                System.exit(0);
            }

            for (int i = 0; i <4 ; i++) {
                int nx = cx + move[i][0], ny = cy + move[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                        map[nx][ny].equals("0") || Math.abs(direction - i) == 1) continue; // 37번 라인 해석
                q.offer(new int[]{nx, ny, count +1, i});
            }
        }
    }
}
//37 번 라인
//Math.abs(direction - i) == 1) continue;
//que는 앞에서 부터 값을 가져오기 때문에
// 코드를 보면 상 하 좌 우 를 가져 옵니다.
// 여기서 !! 중요포인트 ***
// 상 - 하 / 좌 - 우 둘다 절댓값이 1 인걸 알 수 있습니다.
// 이전의 역전되는 값이 들어온다면 abs 절대값으로 확인하여
// 굳이 방문 배열 없이도 continue를 통해서 que 에 담지 않고 진행 할 수 있는 방법이 생깁니다.
// 이렇게 된다면 다시 왔던길을 되돌아 갈 수 없기 때문에
// 앞의 RoadToBiodome09 코드 보다 간단하게 구현 가능합니다.