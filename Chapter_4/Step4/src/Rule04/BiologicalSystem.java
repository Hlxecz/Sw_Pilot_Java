package Rule04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class BiologicalSystem<T> {
    private Stack<T> stack;

    public BiologicalSystem() {
        this.stack = new Stack<>();
        System.out.println("생물정보 시스템이 생성되었습니다.");
    }

    public void add(T item) {
        stack.push(item);
        System.out.println("새로운 생물이 등록되었습니다: " + item);
    }

    public void delete() {
        if (!stack.isEmpty()) {
            T removed = stack.pop();
            System.out.println("생물이 삭제 되었습니다: " + removed.toString());
        }
    }

    public void show() {
        if (!stack.isEmpty()) {
            T latest = stack.peek();
            System.out.println("최신 등록 생물: " + latest.toString());
        }
    }

    public void clear() {
        stack.clear();
        System.out.println("모든 정보를 삭제했습니다.");
    }

    public void isEmpty() {
        if (stack.isEmpty()) {
            System.out.println("생물 정보 리스트는 비어있습니다.");
        } else {
            System.out.println("생물 정보 리스트가 비어있지 않습니다.");
        }
    }

    public void sortByName() {
        if (stack.isEmpty()) {
            System.out.println("정렬할 생물이 없습니다.");
            return;
        }

        List<T> list = new ArrayList<>(stack);
        list.sort(Comparator.comparing(e -> ((BiologicalEntity<?>) e).getName()));

        stack.clear();
        for(T s : list){
            stack.push(s);
        }
        System.out.println("이름순으로 정렬이 완료되었습니다.");
    }
}


