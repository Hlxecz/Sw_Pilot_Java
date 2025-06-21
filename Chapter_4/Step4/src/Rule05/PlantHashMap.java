package Rule05;

public class PlantHashMap<K, V> {
    private Entry<K, V>[] table = new Entry[16];

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next; // 체이닝을 위한 링크

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 해시 인덱스 계산
    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // 추가 또는 덮어쓰기
    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (true) {
                if (current.key.equals(key)) {
                    current.value = value; // 같은 키면 덮어쓰기
                    System.out.printf("'%s' 덮어쓰기: '%s'\n", key, value);
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = newEntry; // 리스트 끝에 추가
        }

        System.out.printf("'%s' 추가: '%s'\n", key, value);
    }

    // 검색
    public void get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                System.out.printf("'%s' 검색: '%s'\n", key, current.value);
                return;
            }else{
                 current = current.next;
            }
        }

        System.out.printf("'%s' 검색: 해당 식물이 존재하지 않습니다.\n", key);
    }

    // 삭제
    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next; // 첫 노드 삭제
                } else {
                    prev.next = current.next;    // 중간 또는 끝 노드 삭제
                }
                System.out.printf("'%s' 삭제: '%s'와 그 특징이 삭제되었습니다.\n", key, current.value);
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.printf("'%s' 검색: 해당 식물이 존재하지 않습니다.\n", key);
    }
}
