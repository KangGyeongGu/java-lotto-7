# java-lotto-precourse

## 기능 요구사항 분석

### 1. 입력 기능
1-1. **구입 금액 입력**
- 구입 금액을 입력받고 1,000원 단위인지 확인한다.
- 유효하지 않은 금액 입력 시 `IllegalArgumentException`을 발생시킨다.

1-2. **당첨 번호 입력**
- 사용자로부터 당첨 번호 6개를 입력받는다.
- 입력된 번호가 1~45 범위 내에 있고, 중복되지 않았는지 확인한다.
- 유효하지 않은 경우 `IllegalArgumentException`을 발생시킨다.

1-3. **보너스 번호 입력**
- 보너스 번호 1개를 입력받는다.
- 당첨 번호와 중복되지 않으며, 번호가 1~45 범위 내에 있는지 확인한다.
- 유효하지 않은 경우 `IllegalArgumentException`을 발생시킨다.

### 2. 로또 발행 기능
2-1. **구매한 로또 개수 계산 및 발행**
- 구입 금액에 따라 구매 가능한 로또 개수를 계산한다.
- 각 로또 번호는 중복 없이 6개의 숫자로 구성되며, 오름차순으로 정렬된다.
- 발행된 로또 번호를 출력한다.

### 3. 당첨 확인 기능
3-1. **당첨 번호와 비교하여 등수 계산**
- 각 로또 번호가 당첨 번호와 몇 개 일치하는지 확인한다.
- 일치하는 개수에 따라 1등 ~ 5등의 등수를 판별한다.
- 보너스 번호 일치 여부로 2등을 판별한다.

### 4. 수익률 계산 기능
4-1. **당첨 상금 합산 및 수익률 계산**
- 당첨 등수에 따른 상금을 합산하여 총 수익을 계산한다.
- 수익률 = (총 수익 / 구입 금액) * 100 으로 계산한다.
- 수익률은 소수 둘째 자리까지 표시한다.

### 5. 결과 출력 기능
5-1. **로또 발행 결과 출력**
- 발행된 로또 번호와 구매한 로또 수량을 출력한다.

5-2. **당첨 통계 출력**
- 각 등수별 당첨 수량과 상금을 출력한다.
- 전체 수익률을 출력한다.


## 기능 구현 목록

### 1. 모델 (Model)
- **Lotto 클래스**
  - [x] 생성자 구현: 번호 유효성 검사를 포함하여 6개의 번호를 초기화한다.
  - [x] 번호 유효성 검사 메서드 구현: 번호의 중복, 범위(1~45) 체크.

- **LottoService 클래스**
  - [x] 로또 번호 생성 메서드 구현: `generateLottos(int quantity)`로 주어진 수량만큼 로또 번호를 생성한다.
  - [x] 당첨 결과 체크 메서드 구현: `checkResults(List<Lotto> purchasedLotto, List<Integer> usersLotto, int bonusNumber)`로 당첨 통계를 계산한다.
  - [x] 일치하는 번호 개수 카운트 메서드 구현: `countMatchingNumbers(List<Integer> eachPurchasedLotto, List<Integer> usersLotto)`.

- **LottoStatistics 클래스**
  - [x] 통계 초기화: 각 등수별 통계 초기화 구현.
  - [x] 통계 증가 메서드 구현: 특정 등수에 대한 카운트를 증가시키는 `increment(String key)` 메서드 구현.
  - [x] 수익 계산 메서드 구현: `calculateTotalEarnings()`로 총 수익을 계산.
  - [x] 통계 출력 메서드 구현: `printStatistics()`로 통계 정보를 출력.

### 2. 뷰 (View)
- **LottoView 클래스**
    - [x] 로또 구매 수 출력 메서드 구현: 구매한 로또 수를 출력.
    - [x] 로또 번호 출력 메서드 구현: 생성된 로또 번호를 출력.
    - [x] 통계 출력 메서드 구현: 통계 정보를 출력.
    - [x] 오류 메시지 출력 메서드 구현: 오류 메시지를 출력.
    - [x] 사용자 입력 메서드 구현:
        - 로또 구입 금액을 입력받는다.
        - 당첨 번호를 입력받는다.
        - 보너스 번호를 입력받는다.

### 3. 컨트롤러 (Controller)
- **LottoController 클래스**
    - [x] 시작 메서드 구현: `start()`로 프로그램의 흐름을 제어한다.
    - [x] 사용자 입력 처리 및 예외 처리: 입력값을 검증하고 잘못된 입력 시 오류 처리.
    - [x] 로또 구매 및 결과 확인 흐름 구현: 로또 번호 생성 및 당첨 결과를 확인하고 통계 출력.

### 4. 애플리케이션 실행
- **Application 클래스**
    - [x] main 메서드 구현: `LottoController`의 인스턴스를 생성하고 `start()` 메서드를 호출하여 프로그램을 시작한다.

## 기능 구현 로그

### 24.10.30.(수)
- **MVC 패턴 적용**
  - 명세한 기능 목록을 Model-View-Controller 패턴에 따라 설계합니다.
  - **Model**
    - 로또 게임 내 데이터 및 비즈니스 로직 처리를 담당하도록 설계합니다.
      - Lotto : 게임 내 로또 객체를 생성하고, 로또 번호 유효성을 검증하는 로직을 갖습니다.
      - LottoService : N개의 랜덤로또 번호를 생성하여 각각의 로또 객체로 반환하고, 사용자가 입력한 로또 번호와 일치하는지 검사하는 로직을 갖습니다.
      - LottoStatistics : 로또 게임의 통계 계산 로직을 갖습니다.
  - **ModelTest 단위테스트**
    - [x] LottoTest : 1~45 사이의 6개 정수 번호를 갖는 로또가 유효성 검증을 정상적으로 통과하는지 검증합니다.
    - [x] LottoServiceTest : N개 로또가 정상적으로 생성되는지 검사합니다. 또한 N개 로또에 대해 사용자의 로또 번호와 정상적으로 일치 여부를 반환하는지 검증합니다. 
    - LottoStatisticsTest : 사전 설정된 로또 일치 여부에 따라 정상적인 금액 통계를 반환하는지 검증합니다.

### 24.10.31 (목)
- **Controller 및 View 구현**
  - **View**
    - 사용자 입력 받기, 내용 출력하기, 에러내용 출력하기 에 대한 기능을 담당합니다.
  - **Controller**
    - View, Model 객체와의 상호작용을 통해 로또 게임을 제어합니다.
  - **ApplicationTest**
    - -[x] 기능_테스트() : 정상적인 입력 절차에 따라 예상되는 출력를 반환하는지 검증합니다.
- **Application.java Main() 구현**
  - View, Model 객체를 생성하여 Controller에 전달합니다.
  - Controller 내부 로직에 따라 View, Model 객체 제어를 통해 로또 게임을 수행합니다.

### 24.11.11.(금)
- **Model-View-Controller + Services**
  - **Model**
    -  한 장의 로또를 표현하는 Lotto 클래스, 로또 게임의 전체 로또 통계 데이터를 표현하는 LottoStatistics 클래스를 갖도록 수정합니다.
  - **View**
    - 기존 LottoStatistics 클래스에 구현된 통계 출력 메서드를 View로 분리하였습니다.
  - **Services**
    - Controller로부터 전달받은 데이터 작업 관련 요청을 처리합니다.
      - Model 객체 생성 요청 처리
      - LottoStatistics 객체의 통계데이터(Map) 및 수익률 (Yield) 데이터 갱신 작업을 수행합니다.
  - **Controller**
    - Controller 클래스에서는, Model,View,Services 객체에 대한 기능 동작 요청만 수행하도록 변경합니다.
    - Controller-Services 간 의존성 주입을 구현합니다.

### 24.11.11.(금).2
- **LottoStatistic**
  - **LottoStatistics Interface**
    - Service에서는 LottoStatistics 인터페이스의 `updateStatistics()`, `updateLottoYield()`만 호출하도록 변경합니다.
      - 정보 은닉 : 내부 데이터 처리 로직을 담당하는 private 메소드와 Service에서 호출할 public 데이터를 명확히 구분합니다.
      - 결합도 : Service에서 LottoStatistic 관련 요청 수행 시, 세부 구현 로직을 알 필요가 없도록 구현합니다.
  - **LottoStatisticDTO**
    - LottoStatistic-View 간 데이터 전송 시 데이터 직접참조 또는 getter/setter 없이 데이터를 참조할 수 있도록 합니다.
  - **LottoController**
    - LottoStatistic 인터페이스를 통해 LottoStatistics 객체에 대한 의존성을 주입하도록 변경합니다.