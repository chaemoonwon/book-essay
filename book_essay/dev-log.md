# 📘 독후감 생성 프로그램 개발 일지

## 🗓️ 진행 단계

* 0단계: 사용자 입력 기반 콘솔 프로그램 구현
* 1단계: 랜덤 질문 생성 기능 추가
* 2단계: 질문 선택 기능 구현
* 3단계: 입력 검증 및 안정성 개선

---

## 🎯 프로젝트 목표

사용자의 독서 내용을 기반으로
질문 → 생각 → 독후감 형태의 글을 생성하는 프로그램 개발

---

## 🧩 구현 기능

### 1. 사용자 입력

* 책 제목 입력
* 답변 입력

### 2. 질문 자동 생성

* List를 사용하여 질문 목록 구성
* Random을 활용하여 질문 선택

---

### 3. 독후감 생성 로직

* 입력값 기반 문자열 조합
* 질문 + 답변을 활용한 문장 생성

---

## 🧠 배운 점

* Scanner를 활용한 입력 처리
* List와 Random 활용
* 입력 → 처리 → 출력 구조 이해

---

## ⚠️ 개선할 점

* 질문 선택 기능 부족
* 코드가 main에 집중됨

---

## 🚀 다음 목표

* 질문 3개 생성 후 선택 기능 구현
* 중복 없는 랜덤 질문 생성

---

## 🗓️ 2단계: 질문 선택 기능 구현

### 🧩 구현 내용

* 질문 리스트를 생성 후 `Collections.shuffle()`로 랜덤 섞기
* 3개의 질문을 사용자에게 출력
* 사용자 입력을 통해 질문 선택 기능 구현

### 💡 핵심 코드

```java
Collections.shuffle(questions);
int choice = scanner.nextInt();
String question = questions.get(choice - 1);
```

### 🧠 배운 점

* `Collections.shuffle()`을 활용한 랜덤 처리
* 사용자 입력 기반 흐름 제어
* `nextInt()`와 `nextLine()` 차이 이해 (버퍼 문제)

### ⚠️ 개선할 점

* 입력값 검증 필요 (잘못된 번호 입력 시 오류 발생 가능)
* 코드가 main에 집중되어 있음 → 메서드 분리 필요

### 🚀 다음 목표

* 입력값 검증 처리 (예외 처리)
* 기능별 메서드 분리
* 객체 구조 설계 시작 (Book, Question 등)

---

## 🗓️ 3단계: 입력 검증 및 안정성 개선

### 🧩 구현 내용
* 사용자 입력 범위 검증 (1 ~ N)
* 잘못된 입력 시 반복 입력 처리
* nextInt() 이후 버퍼 문제 해결

### 🧠 배운 점
* 입력값 검증의 중요성
* Scanner 입력 버퍼 구조 이해
* 반복문을 활용한 안정적인 입력 처리

### ⚠️ 개선할 점
* 숫자가 아닌 입력 처리 필요 (예외 처리)
* 코드가 main에 집중됨 → 구조 분리 필요

### 🚀 다음 목표
* try-catch를 활용한 예외 처리
* 메서드 분리 (구조 개선)
* 객체 설계 시작

## 🗓️ 4단계: 메서드 분리 및 구조 개선

### 🧩 구현 내용

* 사용자 입력 기능을 메서드로 분리 (`inputBook`, `inputAnswer`)
* 질문 생성, 선택, 독후감 생성 로직을 각각 메서드로 분리
* main 메서드는 전체 흐름만 담당하도록 구조 개선

---

## 🧠 배운 점

* 기능 단위로 코드를 나누는 방법 이해
* return을 활용한 데이터 흐름 설계
* main은 "조립", 메서드는 "기능" 역할이라는 개념 학습

---

## ⚠️ 개선할 점

* 모든 메서드가 Main 클래스에 존재 → 역할 분리 필요
* UI(출력)와 로직이 일부 섞여 있음

---

## 🚀 다음 목표

* Service 클래스 분리 (EssayService)
* Controller / Service 구조로 리팩토링
* 객체 기반 설계 시작

---

## 🗓️ 5단계: Service 클래스 분리

### 🧩 구현 내용

* EssayService 클래스 생성
* 기존 Main에 있던 비즈니스 로직을 Service로 이동
* Main은 입력 및 흐름 제어만 담당하도록 수정

---

## 🧠 배운 점

* Controller / Service 역할 분리 개념 이해
* 객체 지향 구조의 필요성 체감
* 유지보수 가능한 코드 구조 설계 경험

---

## ⚠️ 개선할 점

* 출력(UI)과 로직이 아직 일부 섞여 있음
* 객체 모델 설계 필요

---

## 🚀 다음 목표

* 객체 설계 (Book, Essay 클래스)
* Spring 구조로 확장
* AI 연동 준비

---

---

## 🗓️ 6단계: Result 객체 기반 질문 선택 구조 개선

### 🧩 구현 내용

* 기존 `String` 또는 `null` 반환 방식에서 `QuestionResult` 객체 반환 방식으로 개선
* 질문 선택 성공/실패 상태를 `QuestionStatus` enum으로 분리
* `QuestionResult`를 불변 객체로 설계
* 성공 결과와 실패 결과 생성을 정적 팩토리 메서드로 분리
* `Main`에서는 `null`이 아닌 `status`를 기준으로 성공/실패 판단

---

## 🔍 기존 구조의 문제점

기존 질문 선택 로직은 실패 시 `null`을 반환했다.

```java
String question = service.selectQuestion(questions, choice);
```

이 방식은 다음 문제가 있었다.

* 성공과 실패의 의미가 명확하지 않음
* `null`을 잘못 사용하면 `"null"`이 포함된 독후감이 생성될 수 있음
* 실패 이유를 표현하기 어려움
* Main이 Service 내부 검증 규칙을 과도하게 알아야 할 가능성이 있음

---

## ✅ 개선 방향

기존 구조를 다음과 같이 개선했다.

```text
기존:
String 또는 null 반환

개선:
QuestionResult 반환
```

`QuestionResult`는 질문 선택 결과를 표현하는 객체이다.

```text
QuestionResult
- status
- question
```

`QuestionStatus`는 질문 선택 상태를 표현한다.

```text
QuestionStatus
- SUCCESS
- INVALID_RANGE
```

---

## 🧠 Result 객체를 도입한 이유

질문 선택 결과는 단순히 질문 문자열 하나만으로 표현하기 어렵다.

성공했는지, 실패했는지, 성공했다면 어떤 질문이 선택되었는지를 함께 표현해야 한다.

따라서 다음과 같이 상태와 데이터를 함께 반환하는 구조로 개선했다.

```text
성공:
status = SUCCESS
question = 선택된 질문

실패:
status = INVALID_RANGE
question = null
```

이 구조를 통해 `null` 자체로 실패를 판단하지 않고, 명확한 상태값으로 흐름을 제어할 수 있게 되었다.

---

## 🧱 QuestionResult 설계

`QuestionResult`는 처리 결과를 나타내는 객체이므로 생성 후 값이 변경될 필요가 없다.

따라서 불변 객체로 설계했다.

적용한 설계 기준은 다음과 같다.

```text
- 필드는 private final
- 생성자는 private
- setter는 만들지 않음
- success(), invalidRange() 정적 팩토리 메서드로만 객체 생성
```

### 설계 의도

```text
SUCCESS 상태라면 question이 반드시 존재해야 한다.
INVALID_RANGE 상태라면 question은 존재하지 않아야 한다.
```

이를 통해 상태와 데이터가 모순되는 객체 생성을 방지한다.

예를 들어 다음과 같은 잘못된 상태를 막을 수 있다.

```java
new QuestionResult(QuestionStatus.SUCCESS, null);
```

---

## 🏭 정적 팩토리 메서드 사용

객체 생성 의도를 명확히 하기 위해 생성자를 직접 호출하지 않고 정적 팩토리 메서드를 사용했다.

```java
QuestionResult.success(question);
QuestionResult.invalidRange();
```

### 장점

* 성공 결과와 실패 결과 생성을 명확히 구분할 수 있음
* 객체 생성 의도가 코드에 드러남
* 잘못된 상태의 객체 생성을 방지할 수 있음
* Main이 Result 내부 생성 규칙을 알 필요가 없어짐

---

## ⚠️ 예외 처리 기준

`QuestionResult.success(null)`은 사용자의 잘못된 입력이 아니라 개발자가 잘못된 인자를 전달한 상황이다.

따라서 `INVALID_RANGE`로 처리하지 않고, `IllegalArgumentException`으로 막는다.

```java
public static QuestionResult success(String question) {
    if (question == null) {
        throw new IllegalArgumentException("question must not be null.");
    }
    return new QuestionResult(QuestionStatus.SUCCESS, question);
}
```

정리하면 다음과 같다.

```text
사용자 입력 실패:
INVALID_RANGE 반환

개발자 코드 실수:
IllegalArgumentException 발생
```

---

## 🔁 Main 입력 흐름 개선

기존에는 질문이 `null`인지 확인하면서 반복을 제어했다.

개선 후에는 `QuestionResult`의 `status`를 기준으로 흐름을 제어한다.

```text
1. 사용자가 번호 입력
2. 숫자인지 확인
3. 숫자라면 Service에 choice 전달
4. Service가 QuestionResult 반환
5. status가 SUCCESS이면 question 저장 후 반복 종료
6. status가 INVALID_RANGE이면 오류 메시지 출력 후 반복 계속
```

숫자가 아닌 입력은 `scanner.hasNextInt()`로 먼저 검사한다.

```text
숫자가 아닌 입력:
scanner.nextLine()으로 잘못된 입력 제거
"숫자를 입력하세요." 출력
```

---

## 🔢 choice와 index 분리

이번 리팩터링에서 `choice`와 `index` 개념을 명확히 분리했다.

```text
choice:
사용자가 입력하는 번호, 1부터 시작

index:
List에 접근하기 위한 번호, 0부터 시작
```

변환은 Service 내부에서만 수행한다.

```java
private int selectIndex(int choice) {
    return choice - 1;
}
```

이를 통해 Main은 내부 index 구조를 알 필요 없이 사용자 입력값인 `choice`만 다루게 되었다.

---

## 🧠 배운 점

* `null` 반환보다 Result 객체를 사용하는 것이 성공/실패 의미를 명확히 표현할 수 있다.
* Main은 입력과 흐름 제어를 담당하고, Service는 검증과 선택 로직을 담당해야 한다.
* choice와 index를 분리하면 사용자 입력과 내부 구현을 명확히 구분할 수 있다.
* Result 객체는 처리 결과이므로 불변 객체로 설계하는 것이 자연스럽다.
* 정적 팩토리 메서드를 사용하면 객체 생성 의도를 명확하게 표현할 수 있다.
* 사용자 입력 실패와 개발자 코드 실수를 구분해서 처리해야 한다.

---

## ⚠️ 개선할 점

* Main에 입력/출력 코드가 아직 남아 있음
* 질문이 단순 문자열로 관리되고 있음
* 질문 목록 출력 책임이 Main에 있음
* Result 상태가 아직 `SUCCESS`, `INVALID_RANGE`로만 제한되어 있음

---

## 🚀 다음 목표

* 입력 전용 클래스 분리
* 출력 전용 클래스 분리
* `Question` 객체 생성
* `Essay` 객체 생성
* MVC 구조로 확장
* Spring Controller / Service / DTO 구조로 확장 준비

---
