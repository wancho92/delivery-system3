# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 서비스 시나리오

- 기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다
1. 고객이 선택한 메뉴에 대해 결제한다.
1. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
1. 상점주는 주문을 수락하거나 거절할 수 있다
1. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
1. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
1. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
1. 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
1. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다

- 비기능적 요구사항
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven

# 분석/설계
### 모델
![image](https://user-images.githubusercontent.com/62365645/206515288-8b867bfb-95aa-4586-8387-d1e49da08e61.png)

### 기능 요구사항에 대한 검증
![image](https://user-images.githubusercontent.com/62365645/206517061-30b41c21-87c5-4e6b-a570-00bd24e8d56c.png)


    - 고객이 메뉴를 선택하여 주문한다. (ok)
    - 고객이 선택한 메뉴에 대해 결제한다. (ok)
    - 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다. (ok)

![image](https://user-images.githubusercontent.com/62365645/206518672-c3f21d49-d1d2-4422-acbb-8c84c3966175.png)


    - 상점주는 주문을 수락하거나 거절할 수 있다. (ok)
    - 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다. (ok)
    - 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다. (ok)

![image](https://user-images.githubusercontent.com/62365645/206518916-ef7bb52a-7b80-4567-9890-ceedd349c47e.png)


    - 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다. (ok)
    - 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다. (ok)
    - 고객이 주문상태를 중간중간 조회한다. (ok)
    
![image](https://user-images.githubusercontent.com/62365645/206519258-de4f029a-e027-4aec-be1c-924b7a53a560.png)

    
    - 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다. (ok)
    - 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다. (ok)

# 체크포인트

- Saga(Pub/Sub)
   -
   마이크로 서비스간의 통신에서 이벤트 메세지를 비동기(Pub/Sub)로 구현한다.
   
   
- CQRS
  -
  주문상태를 조회할 수 있도록 Query 모델(Materialized View)을 설계하여 조회한다.
 
  - ViewHandler.java 클래스 구현
  
  ![image](https://user-images.githubusercontent.com/62365645/206524553-c9636675-b69d-4e38-85a6-c15d2b851647.png)

  

- Compensation / Correlation
- Request / Response
- Circuit Breaker
- Gateway / Ingress
















