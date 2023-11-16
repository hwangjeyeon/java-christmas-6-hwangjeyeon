# JAVA-CHRISTMAS-6

## 클래스 리스트: 

### domain
- DomainEntityManager
#### calender
- December
#### Info
- EventBadgeInfo
- GiftMenuInfo
- OrderInfo
#### menu
- Category
- MenuInfo
#### User
- UserBenefitInfo
- UserOrderInfo
- UserVisitDay

### service
- BasicService: 현재 미사용
- BusinessService
- InputService
- OutputService
#### util
- CalculateBenefits
- DDayCheck
- EventBadgeCheck
- GiftCheck
- GiftSave
- OrderInfoSave
- StarCheck
- WeekCategoryCheck
- 
### validate
- InputMenuValidate
- InputVisitDayValidate

### view
- InputView
- OutputView

## test
- ApplicationTest
- DomainEntityManagerTest
#### domain
- UserOrderInfoTest
- UserVisitDayTest



## 진행방식
- TDD(테스트 주도 개발)로 진행할 계획 -> 하나의 기능 만든 후, 단위 테스트로 검증하는 방식으로 개발할 것.

## 입력 예외 사항
- 입력한 날짜가 정수형 숫자인가?
- 입력한 날짜가 1~31범위안에 있는가
- 입력한 메뉴가 ","로 분리된 후, 다음 입력 형식을 따르는가? "문자-숫자"
- 입력한 메뉴명이 메뉴판에 있는 메뉴인가?
- 입력한 메뉴명에 중복이 있는가?
- 입력한 메뉴의 개수가 최소 ~ 최대 범위 안에 있는가
- 입력한 메뉴의 카테고리가 음료 이외의 것이 있는가

## 비즈니스 예외 요구사항 
- 1만원 이하 주문 혜택 미적용 

## 프로젝트 핵심 로직
- DomainEntityManager에서 모든 도메인 객체를 관리한다.
- DomainEntityManager는 InputService를 통해, 입력받은 값을 주입받는다
- BusinessService, OutputService는 DomainEntityManager를 주입받아 같은 객체의 도메인에 접근해서 활용한다
- Input은 InputView -> InputService 방향으로 주입받는다
- Output은 OutputService -> OutputView 방향으로 주입받는다

## 고려사항: 
- 도메인 접근은 DomainEntityManager에만 의존한다
- View는 단순 출력을 위함이며, InputService와 OutputService에서 출력을 위한 모든 로직을 처리한다
- BusinessService는 핵심 비즈니스를 관리한다. 각 세부 비즈니스 로직은 Util 패키지로 관리한다
- 중복 변수명은 상수처리한다
- MVC 패턴을 참고하여, 각 파트가 각자의 기능 구현에 집중하도록 최대한 분리한다

## 제출 이후 추가하고 싶은 기능:
- BasicService: 기본 메뉴 정보와 주의사항을 알려주는 서비스 -> 출력문 형식을 맞추기 위해 현재 주석처리
- 악의적인 반복 입력 사용자 차단: 일정 입력횟수 이상 입력될 경우, 사용자 ip를 받아와 차단
