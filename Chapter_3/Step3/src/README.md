# ✨ 3주차 Java 객체지향 프로그래밍 정리

> 클래스 설계부터 상속, 다형성, 캡슐화, 컬렉션 구조 활용, 시간 API까지 자바 객체지향의 핵심을 단계별로 학습했습니다.

---

<details>
<summary>🟢 과정 3_1 | OOP 객체 지향</summary>

- 클래스, 인스턴스, 필드, 메서드 개념 이해
- 생성자와 객체 생성 흐름 학습
- `Organism`, `LifeNest` 클래스로 동식물 관리 시스템 구현

**🧠 키워드**: 클래스, 인스턴스, 생성자, 메서드, 리스트

</details>

---

<details>
<summary>🟢 과정 3_2 | Getter & Setter / 접근제한자</summary>

- `private`으로 필드 보호 → `getter/setter`로 값 접근
- 외부에서 직접 접근하지 못하게 캡슐화 구현

**🧠 키워드**: private, public, 캡슐화, 정보은닉, getter, setter

</details>

---

<details>
<summary>🟢 과정 3_3 | 상속 & 오버라이딩 개념</summary>

- `Organism` → `Animal`, `Plant`로 상속 구조 설계
- 공통된 메서드 `displayInfo()`를 오버라이딩하여 다형성 구현

**🧠 키워드**: extends, @Override, 상속(Inheritance), 다형성

</details>

---

<details>
<summary>🟢 과정 3_4 | 추상화 / 추상메서드 / 가변인자</summary>

- `abstract class`로 공통 설계 정의
- `produceEnergy()`는 각 에너지마다 다르게 구현
- 가변 인자(`...`)로 여러 에너지원 관리

**🧠 키워드**: 추상클래스, 추상메서드, 가변인자(varargs)

</details>

---

<details>
<summary>🧠 인터페이스 vs 추상클래스 차이 정리</summary>

| 항목 | Interface | Abstract Class |
|------|-----------|----------------|
| 키워드 | `interface` | `abstract class` |
| 목적 | 동작 명세 | 공통 기능 설계 |
| 다중 상속 | ✅ 가능 | ❌ 불가 |
| 필드 선언 | 상수만 가능 | 일반 필드 가능 |
| 생성자 | ❌ 없음 | ✅ 있음 |
| 사용 예 | `Flyable`, `Comparable` | `Animal`, `Shape` |

</details>

---

<details>
<summary>🟢 과정 3_5 | 다형성 / 인터페이스 활용</summary>

- `AncientArtifact` 추상 클래스 + `EnergyGenerator`, `WeatherController` 인터페이스 설계
- `instanceof`로 능력 확인 및 실행
- 유물마다 다른 능력을 가지며 다형성으로 호출

**🧠 키워드**: 다형성, 인터페이스, instanceof, 업캐스팅

</details>

---

<details>
<summary>🟢 과정 3_6 | ArrayList vs LinkedList 특징</summary>

- `ArrayList`: 인덱스 접근 빠름, 중간 삽입/삭제 느림
- `LinkedList`: 접근 느림, 삽입/삭제 유리
- 구조 차이와 시간복잡도 비교

**🧠 키워드**: List, 자료구조, O(1), O(n), 연결리스트

</details>

---

<details>
<summary>🧠 enum, 생성자, 인터페이스 구현 정리</summary>

- `enum`은 상수 집합 이상으로 필드, 생성자, 메서드 포함 가능
- `enum`도 인터페이스 구현 가능

```java
public enum AnimalType {
    TIGER("호랑이"), MONKEY("원숭이");

    private final String name;
    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

</details>

---

<details>
<summary>🟢 과정 3_7 | 클래스 관계 / 상속 / 다형성</summary>

- `Member` 클래스 상속 → 운영진, 일반, 신규 멤버로 구분
- 인터페이스 구현으로 연습 세션 개설/연기/취소 기능 분리
- `ChronoUnit.DAYS.between()` 으로 날짜 차이 계산

**🧠 키워드**: 상속, 오버로딩, 인터페이스, 날짜 API

</details>

---

<details>
<summary>🟢 과정 3_8 | 오버로딩 vs 오버라이딩 / ChronoUnit / enum</summary>

- 오버로딩: 같은 이름 다른 매개변수
- 오버라이딩: 상속 후 메서드 재정의
- `ChronoUnit`은 시간 단위를 enum으로 표현 (DAYS, HOURS 등)
- `ChronoUnit.getDuration()`, `between(t1, t2)` 등 시간 처리

**🧠 키워드**: enum, TemporalUnit, Duration, 시간 단위 비교

</details>

---

<details>
<summary>🟡 과정 3_9 | DateTimeFormatter 날짜 형식변경</summary>

- `LocalDateTime`을 `"yyyy-MM-dd HH:mm:ss"` 포맷으로 변환
- 출력 시 사용자 친화적으로 표시 가능

```java
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
System.out.println(date.format(fmt));
```

**🧠 키워드**: 날짜 포맷, DateTimeFormatter

</details>

---
