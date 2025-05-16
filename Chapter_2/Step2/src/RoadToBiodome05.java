public class RoadToBiodome05 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("두 개의 물 높이 배열을 입력하세요.");
            return;
        }

        // 두 배열 입력을 합치고 대괄호 제거
        String[] tokens  = String.join(" ", args).replaceAll("\\[|\\]", "").split("[,\\s]+");

        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {

            try {
                int value = Integer.parseInt(tokens[i]);
                if (value < 0 || value > 100) {
                    System.out.println("물 높이는 최소 0, 최대 100의 값을 가집니다. 다시 입력하세요.");
                    return;
                }
                numbers[i] = value;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값이 포함되어 있습니다. 다시 입력하세요.");
                return;
            }
        }

        // 퀵 정렬 수행
        quickSort(numbers, 0, numbers.length - 1);

        // 정렬 결과 출력
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // 퀵 정렬 메서드
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 파티션 함수
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    } // 현재까지 이해 공식 i 는 왼쪽 피벗 수보다 적은 수의
     //개수를 나타낸다 -1 부터 시작 0이면 재자리 교체
    /*그래서 i를 -1로 시작하는 이유
    i는 “피벗보다 작은 값이 들어가는 자리” 를 가리킴
    i는 처음에는 "아직 아무것도 작지 않았다"는 의미로 -1
    작은 값 발견될 때마다 i를 한 칸 증가시키고 swap
    마지막에 i+1 자리에 pivot을 넣으면, pivot 왼쪽은 다 작고, 오른쪽은 다 큼*/
}
