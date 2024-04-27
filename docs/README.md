# 2차 리뷰 후 개선 방향
- [x] 가변 객체로 변경, setter 삭제
- [ ] start 메소드 책임 줄이기

---
# 1차 리뷰 후 개선 방향
- [x] 객체를 직접 생성하는 것과 의존성 주입의 차이 알아보기  
  > 직접 객체를 생성하는 방식으로 구현하면  
  >다른 클래스와 인스턴스에 의존할 가능성이 있는 객체를 생성하지 않고서는 단위 테스트하는 것이 불가능해 문제가 된다.  
  >의존성 주입으로 코드를 작성하면, 외부의 어떤 클래스가 인스턴스 생성을 담당하게 된다.  
  >결합도가 낮아지고, 클래스를 테스트할 때 실제 인스턴스 대신 모의 개체를 주입하여 상호 작용을 확인하거나 제어 가능하다.

- [x] 불필요한 코드 삭제하기
- [x] 불변 객체 알아보고 적용하기
  > OOP에서 불변 객체는 생성 후 그 상태를 바꿀 수 없는 객체를 말한다(<-> 가변객체; 생성 후 상태 변경 가능)  
  > 즉, 재할당은 가능하지만, 한번 할당하면 내부 데이터를 변경할 수 없는 객체(ex. String; 값 변경 X, 새로운 객체 생성 후 참조)  
  > 불변 객체를 만드는 기본적인 아이디어: [Setter 구현X], [필드에 final 사용]

- [x] Referee 클래스의 judgementWinnerCars() 메소드; 예외처리 선행 후 로직 진행으로 변경
- [x] enum 장점 알아보기
  > 싱글톤을 만드는 가장 좋은 방법  
  > 잘못된 값이 할당되는 것을 컴파일 시점에서 방지 -> 타입 안전성 보장  

- [x] 유틸 클래스 알아보기(https://velog.io/@devrunner21/Static%EA%B3%BC-Utility-Class)
  > [새롭게 알게 된 것]  
  > static 변수는 static 영역에 저장되고 GC의 관리를 받지 않음  
  > static 메서드 안에서는 static 필드만 사용 가능한 이유: 클래스 로딩 -> main() 메소드 실행 -> new 연산자로 해당 인스턴스 생성 -> 지역변수, 메소드 생성

- [x] Validator 업무 과중 해결하기
- [x] 의미 전달에 어려움이 있는 부분 상수화하기
- [x] 테스트 코드 명명규칙 알아보기(https://dzone.com/articles/7-popular-unit-test-naming)
  > 1. MethodName_StateUnderTest_ExpectedBehavior(메서드명_테스트상태_기대행위)
  > 2. MethodName_ExpectedBehavior_StateUnderTest(메서드명_기대행위_테스트상태)
  > 3. test[Feature being tested](테스트[테스트중인 기능])(테스트할기능)
  > 4. Feature to be tested(테스트할기능)
  > 5. Should_ExpectedBehavior_When_StateUnderTest(Should_기대행위_when_테스트상태)
  > 6. When_StateUnderTest_Expect_ExpectedBehavior(When_테스트상태_Expect_기대행위)
  > 7. Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior(Given_사전조건_When_테스트상태_Then_예상동작)
  > 저는 5번 규칙으로 테스트 메소드 이름을 작성했습니다.

- [x] 테스트 메소드 명 영어로 변경 후 displayName 사용

---
# 구현할 기능 목록 

## 입력
- [x] 자동차 입력
  - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
  - Console.readLine() 활용
- [x] 진행할 라운드
  - Console.readLine() 활용

## 출력
- [x] 계산된 거리에 따라 '-' 출력
  - "실행 결과" 출력
  - [자동차 이름 : '-' * n] 형식으로 출력  
- [x] 우승자 출력
  - [x] 우승자가 여려명이면 쉼표(,)로 구분
    - [최종 우승자 : 자동차 이름] 형식으로 출력 

## 기능
- [x] 자동차 생성
  - [x] 0에서 9 사이 난수 생성
  - [x] Randoms.pickNumberInRange() 활용
  - 필드: 자동차 이름
  - [x] 예외처리
    - [x] 값이 안 들어올 때
    - [x] 이름 5자 초과일 때
    - [x] 같은 이름을 가진 자동차가 있을 때
  - [x] 4 이상이면 전진, 아니면 멈춤으로 판단
  - [x] 생성된 난수가 4인지 아닌지 판단
- [x] 심판 우승자 판단
  - [x] car 객체들의 movement를 비교하여 List<Car> winnerCars로 반환
- [x] 라운드 수 예외 처리
  - [x] 숫자가 아닐 때
  - [x] 0 혹은 음수일 때
  - [x] 정수가 아닐 때
  - [x] null 값일 때
- [x] 테스트 코드 작성
