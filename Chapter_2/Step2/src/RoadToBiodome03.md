# RoadToBiodome03.md

## 작성자: 장형준

---

## ✨ 목차

1. 시간 복잡도란?
2. Big-O 표기법의 개념 및 예시
3. RoadToBiodome01 시간 복잡도 분석
4. RoadToBiodome02 시간 복잡도 분석
5. 병목 현상 분석 및 최적화 방안
6. 보너스 과제: 최적화 비교 분석

---

## 1. ⏱️ 시간 복잡도란?

시간 복잡도는 **알고리즘이 입력 크기에 따라 얼마나 많은 연산을 수행하는지**를 나타내는 지표다. 프로그램의 실행 시간을 수학적으로 표현할 수 있게 해 주며, 최악, 평균, 최선의 실행 시간 중 보통 "최악의 시간"을 기준으로 표현한다.

### 필요성:

- 효율적인 알고리즘 선택
- 성능 개선
- 대규모 데이터 처리 판단

---

## 2. 🔄 Big-O 표기법 개요

Big-O 표기법은 입력 크기 `n`이 증가할 때 **수행 시간의 상한을 나타내는 표현**이다.

### 🌟 대표적인 Big-O 예시

| 표현 | 의미 | 예시 |
| --- | --- | --- |
| O(1) | 상수 시간 | 배열의 특정 인덱스 접근 |
| O(log n) | 로그 시간 | 이진 탐색 |
| O(n) | 선형 시간 | 한 번씩 전체 탐색 |
| O(n log n) | 선형 로그 | 병합 정렬 |
| O(n^2) | 이차 시간 | 이중 for문 |

---

## 3. RoadToBiodome01 시간 복잡도 분석

### 핵심 로직 요약

- 문자열을 정리하여 숫자 리스트로 변환
- `Collections.frequency()`를 이용해 특정 숫자가 **몇 번 나왔는지** 체크

### 주요 반복문:

```java
for (int val : list) {
    if (Collections.frequency(list, val) == 1)

```

### 복잡도 분석

- `Collections.frequency(list, val)`는 내부적으로 `list`를 **전체 순회**하기 때문에 O(n)
- 바깥 for문도 `n`회 반복 → **O(n^2)**

### 병목 포인트

- 중첩 루프가 `O(n^2)`을 초래함

### 🔧 개선 방안

- `Map<Integer, Integer>`를 사용하여 등장 횟수를 O(n)으로 미리 세자

### 개선 예시 (핵심만):

```java
Map<Integer, Integer> countMap = new HashMap<>();
for (int val : list) {
    countMap.put(val, countMap.getOrDefault(val, 0) + 1);
}
// 이후 1회 등장한 값 찾기

```

- **개선된 시간 복잡도: O(n)**

---

## 4. RoadToBiodome02 시간 복잡도 분석

### 핵심 로직 요약

- 입력 문자열을 띄어쓰기 기준으로 나누고
- 각 단어가 회문인지 검사 → 회문이면 그대로 출력, 아니면 역순 출력

### 주요 루프:

```java
for (int i = sens.length - 1; i >= 0; i--) {
    for (int e = 0; e < word.length() / 2; e++) {
        if (word.charAt(e) != word.charAt(word.length() - 1 - e))

```

### 복잡도 분석

- `n`: 단어 수, `k`: 단어 평균 길이
- 회문 검사: O(k) → 단어 수만큼 반복 → **O(nk)** = O(N) (전체 문자 수 기준)
- 회문이 아닌 경우 역순 출력도 O(k)

### 병목 없음

- 입력 길이 자체가 최대 10^6이므로, **O(N)**은 충분히 효율적임

---

## 5. 🚧 병목 현상 및 최적화 방안

| 문제 | 병목 위치 | 원인 | 해결책 |
| --- | --- | --- | --- |
| 문제01 | `Collections.frequency` | 중복 순회 발생 | HashMap으로 대체 |
| 문제02 | 없음 | 회문 검사/역출력 모두 O(k) | 이미 최적화된 구조 |

---

## 6. 🎉 보너스 과제: 시간 복잡도 최적화 비교

### 문제01 기존: O(n^2)

- 중첩 탐색으로 인해 느림

### 문제01 개선: O(n)

- HashMap으로 단일 루프 처리 → 대폭 향상

### 문제02: O(n)

- 단어 단위로 문자열 길이만큼만 처리 → 변경 불필요

---

## 📅 참고자료

- https://www.bigocheatsheet.com/
- https://visualgo.net/en
- https://www.geeksforgeeks.org/collections-frequency-java/

---

**✅ 요약**

- 시간 복잡도는 알고리즘 효율성을 판단하는 중요한 도구
- 문제01은 최적화 여지가 컸고, 문제02는 구조적으로 효율적이었음


---

**✅ 궁금한점**

<details>
<summary> ** 왜 Big-O 표기에서 상수(예: 2)는 생략하는가? ** </summary>

### 예: `O(2n)`은 왜 `O(n)`으로 쓰는가?

> Big-O는 "입력 크기(n)가 커질 때 시간이 어떻게 증가하는가"를 나타내는 성장률이야.
> 

상수 2는 **성장 속도에 영향을 거의 안 줌**.

### 예시 비교:

- `O(n)`이면 n이 1,000일 때 → 1,000번 연산
- `O(2n)`이면 n이 1,000일 때 → 2,000번 연산
    
    → 차이는 있지만, n이 커질수록 **둘 다 선형으로 커짐**
    

🔗 그래서 Big-O는 **상수 곱, 낮은 차수는 무시**:

- `O(100n)` → `O(n)`
- `O(n + 10)` → `O(n)`
- `O(2n + 3)` → `O(n)`
  
- 📌 핵심: **“성장 패턴”만 본다**

</details>

<details>
<summary> ** RoadToBiodome02 -> HashMap Ex ** </summary>

### 개선 방식 (빠름):

### 1. 먼저 등장 횟수를 **한 번에 다 센다**

```java
Map<Integer, Integer> countMap = new HashMap<>();
for (int val : list) {
    countMap.put(val, countMap.getOrDefault(val, 0) + 1); 
    //HashMap.getOrDefault(key, 기본값)
    //"해당 key가 있으면 value를 가져오고, 없으면 내가 준 기본값을 대신 줘!"
```

- `getOrDefault(val, 0)` → 해당 숫자가 없으면 0을 기본값으로 넣고 +1
- `HashMap`은 이 과정이 O(1)에 가깝기 때문에 전체가 **O(n)**

### 2. 그리고 1번 등장한 숫자만 출력

```java
for (int val : list) {
    if (countMap.get(val) == 1) {
        System.out.println("1번 등장한 값: " + val);
        break;
    }

```

---

## ✅정리

| 방식 | 설명 | 시간 복잡도 |
| --- | --- | --- |
| `Collections.frequency()` | 리스트를 계속 뒤져서 등장 횟수 셈 | O(n²) |
| `HashMap` | 등장 횟수를 한 번에 다 세고 필요할 때 바로 꺼냄 | O(n) |

---

## 🧪 예시 입력

```java
입력: [4, 5, 6, 4, 6]
→ 5는 한 번만 등장
```

### `HashMap` 내부 상태:

```java
{4=2, 5=1, 6=2}
```

→ `5`가 `1`이니까 출력!

</details>
