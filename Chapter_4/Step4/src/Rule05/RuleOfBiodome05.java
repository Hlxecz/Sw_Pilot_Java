package Rule05;

public class RuleOfBiodome05 {
    public static void main(String[] args) {
        PlantHashMap<String, String> map = new PlantHashMap<>();

        // 기본 데이터 추가
        map.put("장미", "장미는 관상용으로 많이 재배되는 화초 중 하나이다.");
        map.put("해바라기", "해바라기는 태양을 따라 움직이는 것으로 알려져 있다.");
        map.put("민들레", "민들레는 약용으로도 사용되는 풀이다.");

        // 해시 충돌 실험용 키 추가 (같은 인덱스로 갈 가능성 높음)
        map.put("0-42L", "체이닝 실험용 키 1번");
        map.put("0-43-", "체이닝 실험용 키 2번");

        // 검색 테스트
        map.get("장미");
        map.get("해바라기");
        map.get("0-42L");
        map.get("0-43-");

        // 삭제 테스트
        map.remove("민들레");
        map.remove("0-42L");

        // 인덱스 확인
        System.out.println("'장미' 인덱스: " + map.getIndex("장미"));
        System.out.println("'해바라기' 인덱스: " + map.getIndex("해바라기"));
        System.out.println("'0-42L' 인덱스: " + map.getIndex("0-42L"));
        System.out.println("'0-43-' 인덱스: " + map.getIndex("0-43-"));
    }
}
