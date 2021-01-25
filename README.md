# JPA
* EntityManagerFactory는 하나만 생성하여 애플리케이션 전체에서 공유해야 한다.
* EntityManager는 Thread 간에 공유하면 안된다. (사용하고 버려야 한다.)
* JPA의 모든 데이터 변경은 Transaction 안에서 실행한다.

## DB 스키마 자동 생성
**hibernate.hbm2ddl.auto**
* create: 기존 테이블 삭제 후 재생성 (DROP + CREATE)
* create-drop: create와 같으나 종료 시점에 테이블 DROP
* update: 변경분만 반영
* validate: Entity와 테이블이 정상 맵핑되었는지 확인
* none: 사용하지 않음

### 주의
* 개발 : create, update
* 테스트 : update, validate
* 스테이징과 운영 : validate, none
