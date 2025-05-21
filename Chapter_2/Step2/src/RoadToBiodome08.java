import java.util.Arrays;

public class RoadToBiodome08 {
    static Integer[] MyQueue = new Integer[10];
    static int front = 0,
                rear = 0,
                size = 0;

    public static void main(String[] args) {
        for (String arg : args) {
            Enqueue(Integer.parseInt(arg));
        }
        while (!isEmpty()) {
            System.out.printf("자원 %d을 제공했습니다.\n", Dequeue());
        }
        System.out.println("모든 요청이 처리되었습니다.");
    }

    static void Enqueue(Integer value) { //삽입
        //배열 사이즈가 가득 찼을 때 10 늘어난 크기 복사
        if (size == MyQueue.length) {
            MyQueue = Arrays.copyOf(MyQueue, MyQueue.length + 10);
            System.out.printf("Queue의 크기가 %d으로 늘어났습니다.\n", MyQueue.length);
        }

        MyQueue[rear] = value;
        //선형 큐 단점 보완 -> 원형 큐 빈 공간 재사용
        rear = (rear + 1) % MyQueue.length;
        size++;
    }

    static Integer Dequeue() { //삭제
        if (isEmpty()) return null;
        Integer data = MyQueue[front];
        //선형 큐 단점 보완 -> 원형 큐 빈 공간 재사용
        front = (front + 1) % MyQueue.length;
        size--;
        return data;
    }

    static boolean isEmpty() {
        return size == 0;
    }

}

