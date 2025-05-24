import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome09 {
    //이동 방향 상 하 좌 우
    static int[][] xy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int N = args.length;              // 세로 (행)
        int M = args[0].length();         // 가로 (열)
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        ckRange(args,map); //유효성 검사 및 map 채우기

        bfs(visited, map ,N ,M); //bfs 검사
    }

    private static void bfs(boolean[][] visited, int[][] map, int N, int M) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{0,0,0}); // {x, y, 이동 거리}
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0], y = now[1], count = now[2];

            // 도착했을 경우
            if (x == N - 1 && y == M - 1) {
                System.out.println(count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                //상하좌우 한세트씩 꺼내오기
                int nx = x + xy[d][0];
                int ny = y + xy[d][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {  // map 범위 초과 검사
                    if (!visited[nx][ny] && map[nx][ny] == 1){ //방문 x 1인곳만 패스
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }
        System.out.println("입구에서 출구로 연결된 안전한 경로가 없습니다.");

    }


    private static void ckRange(String[] args, int[][] map) {
        if (args.length < 2) {
            System.out.println("2차원 배열이 아닙니다.");
            System.exit(0);
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                char ch = args[i].charAt(j);
                if (ch != '0' && ch != '1' && ch != '2') { //0 or 1 값 검사
                    System.out.println("입력값이 0 또는 1 또는 2가 아닙니다.");
                    System.exit(0);
                }
                //숫자 아스키 코드로 변환 {('1'은 49), ('0'은 48) - ('0'은 48)}을하면 숫자로 변경되서 저장된다.
                map[i][j] = ch - '0';
            }
        }

    }


}

//보너스 문제 2도 0으로 취급하여 1이아니면 안가기 때문에 알아서 피해간다 .


