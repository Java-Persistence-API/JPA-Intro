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

---

## 연관 관계의 주인과 mappedBy

### 객체의 양방향 연관 관계
* 객체의 양방향 연관 관계는 사실 양방향 연관 관계가 아니라 서로 다른 단방향 연관 관계 2개다.
> 객체를 양방향으로 참조하려면 단방향 연관 관계를 2개 만들어야 한다.

### 테이블의 양방향 연관 관계
* 테이블은 FK 하나로 두 테이블의 연관 관계를 관리한다.
* MEMBER.TEAM_ID(FK) 하나로 양방향 연관 관계를 가진다. (양쪽으로 JOIN 할 수 있다.)

```sql
SELECT *
FROM MEMBER M 
JOIN TEAM T ON M.TEAM_ID = T.ID

SELECT *
FROM TEAM T 
JOIN MEMBER M ON T.ID = M.TEAM_ID
```

### 연관 관계의 주인 (Owner)
**양방향 맵핑 규칙**
* 객체의 두 관계 중 하나를 연관 관계의 주인으로 지정한다.
* 연관 관계의 주인만이 FK를 관리한다. (등록, 수정)
* 주인이 아닌 쪽은 Read만 가능하다.
* 주인은 mappedBy 속성 사용 X, 주인이 아니면 mappedBy 속성으로 주인 지정한다.

**누구를 주인으로?**
* FK가 있는 곳을 주인으로 한다.

**양방향 맵핑 언제?**
* 단방향 맵핑만으로도 이미 연관 관계 맵핑은 된 것이고, 양방향 맵핑은 반대 방향 조회(객체 그래프 탐색) 기능이 추가된 것뿐이다.
* JPQL에서 역방향으로 탐색할 일이 많다.
* 단방향 맵핑을 잘하고 양방향 맵핑은 필요할 때 추가해도 된다. (테이블에 영향이 없다.)





